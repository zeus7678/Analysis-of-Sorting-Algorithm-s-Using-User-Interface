package sortingalgorithms;
import java.applet.Applet;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author ravi
 */
public class SortingAlgorithms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new StartPaige();
    }
    
}
class StartPaige {
	private static JTextField array[]=new JTextField[10];
	private JTextArea showText;
	private JLabel label ,label2,label3,label4;
	private JPanel MainPanel,mPanel,mPanel2,mPanel3,mPanel4;
	Font font=new Font("Arial",Font.PLAIN,35);
	
	StartPaige()
	{
		 JFrame jf=new JFrame();
		 JPanel MainPanel=new JPanel();
		 mPanel=new JPanel();
		 JPanel mPanelb=new JPanel();
		 label=new JLabel ("                                                  PROJECT                                                        ");
		 label2=new JLabel("                                          SORTING ALGORITHM ANALSISYS                                             ");
		 label.setFont(font);
		 label.setVisible(true);
		 label2.setFont(font);
		 label2.setVisible(true);
		 mPanel.add(label);
		 mPanelb.add(label2);
		 mPanel.setVisible(true);
		 mPanelb.setVisible(true);
		 mPanelb.setBackground(Color.BLUE);
		 mPanel.setBackground(Color.BLUE);
		 JPanel mPanel2=new JPanel();
		 mPanel2.setVisible(true);
		 mPanel2.setBackground(Color.GREEN);
		 for(int i=0;i<10;i++)
		 {
			 array[i]=new JTextField(2);
			 array[i].setEditable(true);
			 array[i].setVisible(true);
			 array[i].setFont(font);
			 array[i].setBorder(BorderFactory.createCompoundBorder(
	                    new CustomeBorder(), 
	                    (Border) new EmptyBorder(new Insets(15, 25, 5, 20))));
			 mPanel2.add(array[i]);
		 }
	     
		 
	     JButton rondom=new  JButton("Random");
	     JButton compaire=new  JButton("Comapire");
	     rondom.setVisible(true);
	     rondom.addActionListener(new ActionListener(){  
	         public void actionPerformed(ActionEvent e){
	        	Random rand=new Random();
	 			for(int i=0;i<10;i++)
	 			{
	 				array[i].setText(String.valueOf(rand.nextInt(99)));
	 			}
	        	 } 
	          });
	     compaire.setVisible(true);
	     JPanel panelr=new JPanel();
	     panelr.setVisible(true);
	     panelr.add(rondom);
	     JPanel panels=new JPanel();
	     panels.setVisible(true);
	     panels.add(compaire);
	     String sorting[]={"MergeSort","SelectionSort","QuickSort","HeapSort"};
	     
	     JComboBox selectArg=new JComboBox(sorting);
	     JPanel panelc=new JPanel();
	     panelc.setVisible(true);
	     panelc.add(selectArg);
	     
	     selectArg.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {

					JComboBox comboBox = (JComboBox) event.getSource();
					if(comboBox.getSelectedItem().equals("SelectionSort"))
					{
					new SelectionSort();
					jf.dispose();	
					}
					if(comboBox.getSelectedItem().equals("MergeSort"))
					{
					new MergeSort();
					jf.dispose();
						
					}
					if(comboBox.getSelectedItem().equals("QuickSort"))
					{
					new QuickSort();
					jf.dispose();
						
					}
					if(comboBox.getSelectedItem().equals("HeapSort"))
					{
					new HeapSort();
					jf.dispose();
						
					}
					
					}});
		
	     
		 MainPanel.add(mPanel);
		 MainPanel.add(mPanelb);
		 MainPanel.add(mPanel2);
		 MainPanel.add(panelr);
		 MainPanel.add(panels);
		 MainPanel.add(panelc);
		 jf.add(MainPanel);
		 jf.setSize(1200,800);
		 jf.setVisible(true);
		 jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static JTextField[] returnField()
	{
		return array;
		
	}

	
	
}
class CustomeBorder extends AbstractBorder
{
       
       public void paintBorder(Component c, Graphics g, int x, int y,
               int width, int height)
       {
          
           super.paintBorder(c, g, x, y, width, height);
           Graphics2D g2d = (Graphics2D)g;   
           //System.out.println("width,height "+width+","+height);
       g2d.drawRoundRect(x, y, width - 1, height - 1, 25, 25);
          // g2d.drawOval(x, y, width - 35, height - 1);
          // g2d.drawRoundRect(x, y, 80, 80, 250, 250);
       }   
}
class CircularBorder extends AbstractBorder
{
       
       public void paintBorder(Component c, Graphics g, int x, int y,
               int width, int height)
       {
          
           super.paintBorder(c, g, x, y, width, height);
           Graphics2D g2d = (Graphics2D)g;            
        // g2d.drawRoundRect(x, y, width - 1, height - 1, 25, 25);
          // g2d.drawOval(x, y, width - 35, height - 1);
           g2d.drawRoundRect(x, y, 65,65, 250, 250);
       }   
}

class SelectionSort {

	SelectionSort(){
	 JTextField array[]=StartPaige.returnField();
	 int temp[]=new int[10];
	 
	 for(int i=0;i<10;i++)
	 {
		 temp[i]=Integer.parseInt(array[i].getText());
	 }
	 new ShowGUI(temp);
	
	

	}

}
class ShowGUI{
	static Font font=new Font("Arial",Font.PLAIN,35);
	Font fonts=new Font("Arial",Font.PLAIN,40);
	private JTextField array[]=new JTextField[10];
	ShowGUI(int temp[])
	{
		JFrame jf=new JFrame();
		JPanel main=new JPanel();
		//main.setBackground(Color.CYAN);
		JLabel label1=new JLabel("Selection Sorting");
		label1.setFont(font);
		label1.setVisible(true);
		label1.setBounds(500,50,500,50);
		JPanel arrayPanel=new JPanel();
		//arrayPanel.setBackground(Color.BLUE);
		JLabel arrayl=new JLabel("Initial Array");
		arrayPanel.setBackground(Color.CYAN);
		arrayl.setVisible(true);
		arrayl.setEnabled(true);
		arrayl.setFont(fonts);
		JLabel arrayg=new JLabel("    ");
		arrayl.setVisible(true);
		arrayl.setEnabled(true);
		arrayl.setFont(fonts);
		arrayPanel.add(arrayl,0);
		arrayPanel.add(arrayg,1);
		for(int i=0;i<10;i++)
		 {
			 array[i]=new JTextField(String.valueOf(temp[i]));
			 array[i].setEditable(false);
			 array[i].setVisible(true);
			 array[i].setFont(font);
			 
			 array[i].setBorder(BorderFactory.createCompoundBorder(
	                    new CustomeBorder(), 
	                    (Border) new EmptyBorder(new Insets(15, 25, 5, 20))));
			 arrayPanel.add(array[i]);
		 }
		arrayPanel.setBounds(20, 150, 1100, 100);
		arrayPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		arrayPanel.setVisible(true);
		
		JLabel jb=new JLabel("Starting");
		jb.setVisible(true);
		jb.setFont(fonts);
		jb.setBounds(30,330,600,90);
		jb.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(20)));
		JTextField jt[]=new JTextField[10];
		jb.setBackground(Color.CYAN);
				
		for(int i=0;i<10;i++) {
		 jt[i]=new JTextField(String.valueOf(temp[i]));
		 jt[i].setEditable(false);
		 jt[i].setVisible(true);
		 jt[i].setFont(font);
		 jt[i].setBounds(40+i*100,540, 100, 80);
		 System.out.println(jt[i].getBounds().x);
		 System.out.println(jt[i].getBounds().y);
		 jt[i].setBorder(BorderFactory.createCompoundBorder(
                   new CustomeBorder(), 
                   (Border) new EmptyBorder(new Insets(15, 25, 15, 20))));
		 main.add(jt[i]);
		}
		for(int i=0;i<10;i++)
		{
			System.out.println(temp[i]);
		}
		for(int i=0;i<10;i++)
		{
			System.out.println("Field Value-->"+jt[i].getText());
		}
		NewThread t=new NewThread(temp,jb,jt);
		t.start();
		//Swap swap=new Swap(jt[3],jt[7]);
		//swap.start();
		
		arrayl.setFont(fonts);
		main.add(arrayPanel);
		main.add(label1);
		main.add(ShowGUI.returnAni1());
		main.add(jb);
		
		main.setVisible(true);
		main.setLayout(null);
		//JScrollPane sp=new JScrollPane(jf); 
		jf.add(main);
		jf.setSize(1200,800);
		jf.setVisible(true);
		jf.setLayout(null);
				
	}
	public static JPanel returnAni1()
	{
		JPanel sorta=new JPanel();
		JLabel arraySorting=new JLabel("Sorting");
		arraySorting.setVisible(true);
		arraySorting.setEnabled(true);
		arraySorting.setFont(font);
		JLabel arraySortina1=new JLabel("...");
		arraySortina1.setVisible(true);
		arraySortina1.setEnabled(true);
		arraySortina1.setFont(font);
		JLabel arraySortina2=new JLabel("...");
		arraySortina2.setVisible(true);
		arraySortina2.setEnabled(true);
		arraySortina2.setFont(font);
		JLabel arraySortinga3=new JLabel("...");
		arraySortinga3.setVisible(true);
		arraySortinga3.setEnabled(true);
		arraySortinga3.setFont(font);
		sorta.add(arraySorting);
		sorta.add(arraySortina1);
		sorta.add(arraySortina2);
		sorta.add(arraySortinga3);
		//sorta.setBackground(Color.CYAN);
		sorta.setLayout(new FlowLayout(FlowLayout.LEFT));
		sorta.setVisible(true);
		sorta.setBounds(20,270,300, 60);;
		return sorta;
	}

}
class NewThread extends Thread
{
	
  int temp[];
  JLabel jb;
private JTextField[] jt;
	public NewThread(int[] temp, JLabel jb,JTextField jt[]) 
	{
		this.temp=temp;
		this.jb=jb;
		this.jt=jt;
	}

	public void run()
	{ int irecord = 0;
		int minimum;        
        for(int i = 0; i < temp.length-1 ; i++)  {

          
             minimum = i ;

        

            for(int j = i+1; j < temp.length ; j++ ) {
            	jb.setText("Comparison "+temp[i]+","+temp[j]);
            //	System.out.println("Comparison "+temp[i]+","+temp[j]);
            	try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	
                if(temp[ j ] < temp[ minimum ])  {               
                minimum = j ;
                
                }
             
             }
            if(!jt[i].getText().equals(jt[minimum].getText())) {
            	jb.setText("Min Value For Sort :"+temp[minimum]);
                try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
              
            	Swap  sp=new Swap(i,minimum,jt,100,80);
                sp.start();
                long time=sp.getDelay();
            try {
            	jb.setText("Swaping "+temp[i]+","+temp[minimum]);
            	System.out.println(time);
				Thread.sleep(time+50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
        else {
        	jb.setText("Equal Value ::");}
          int tempn=temp[ minimum ];
          temp[ minimum ]=temp[ i ];
          temp[i]=tempn;
        }
        
		jb.setText("Done");
}}
class Swap extends Thread{
private JTextField jti,jtj,jt[];
int i,j;
private int width;
private int height;
private  long time=0;
private long delay=1;
	public Swap(int i,int min,JTextField jt[],int width,int height) {
		this.jti=jt[i];
		this.jtj=jt[min];
		this.jt=jt;
		this.i=i;
		this.j=min;
		this.width=width;
		this.height=height;
		this.time=(long) (this.time+2*(delay*(height+20))+(jtj.getBounds().x-jti.getBounds().x)*(delay));
	}
	public void run()
	{int ix=jti.getBounds().x,iy=jti.getBounds().y;
	int jx=jtj.getBounds().x,jy=jtj.getBounds().y;
	
	int n1 = 0,n2 = 0;
	  for(int i=0,j=0;i<=height+20 &&j<=height+20;i++,j++)
	  {  try {
		//  time+=delay;
		Thread.sleep(delay);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		  jti.setBounds(ix,iy-i,width,height);
		  n1=iy-i;
		  jtj.setBounds(jx,jy+j,width,height);
		  n2=jy+j;
	  }
	  int z1 = 0,z2 = 0;
	  int ilimit=jtj.getBounds().x,jlimit=jti.getBounds().x;
	  for(int i=0,j=0;i<=jx-ix &&j<=jx-ix;i++,j++)
	  {
		  if(jx-ix>=800) 
	      {
		  try {   
			 // time+=(delay)*0.800;
			Thread.sleep((long) ((delay)*0.800));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  }
		  else 
		  {
			  try {
				 // time+=(delay);
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
	  
		  jti.setBounds(ix+i,n1,width,height);
		  z1=ix+i;
		  jtj.setBounds(jx-j,n2,width,height);
		  z2=jx-j;
	  }
	  for(int i=0,j=0;i<height+20&&j<=height+20;i++,j++)
	  {  try {
		  //time+=(delay);
		Thread.sleep(delay);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  jti.setBounds(z1,n1+i,width,height);
	  jtj.setBounds(z2,n2-j,width,height);
	  }
	  JTextField tf=jt[i];
		jt[i]=jt[j];
		jt[j]=tf; 
	
	}
	public long getDelay()
	{
		return time;
	}
	public void setDelay(long delay)
	{
		this.delay=delay;
	}
	
}
class SwapLevel extends Thread{
	private 
                JTextField jti,jtj,jt[];
	int i,j;
	private int width;
	private int height;
	private long time=0;
	private long delay=1;
		public SwapLevel(int i,int min,JTextField jt[],int width,int height) {
			this.jti=jt[i];
			this.jtj=jt[min];
			this.jt=jt;
			this.i=i;
			this.j=min;
			this.width=width;
			this.height=height;
			this.time=(long) (this.time+(jtj.getBounds().x-jti.getBounds().x)*(delay));
		}
		public void run()
		{int ix=jti.getBounds().x,iy=jti.getBounds().y;
		int jx=jtj.getBounds().x,jy=jtj.getBounds().y;
	
		 
		  for(int i=0,j=0;i<=jx-ix &&j<=jx-ix;i++,j++)
		  {
			  if(jx-ix>=800) 
		      {
			  try {   
				  time+=(delay)*0.800;
				Thread.sleep((long) ((delay)*0.800));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  }
			  else 
			  {
				  try {
					  time+=(delay);
					Thread.sleep(delay);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  }
		  
			  jti.setBounds(ix+i,iy,width,height);
			
			  jtj.setBounds(jx-j,jy,width,height);
			 
		  }
		  JTextField tf=jt[i];
			jt[i]=jt[j];
			jt[j]=tf; 
		
		}
		public long getDelay()
		{
			return time;
		}
		public void setDelay(long delay)
		{
			this.delay=delay;
		}
		
}
class QuickSort {
	private JFrame jf=new JFrame();
	private static JPanel headpanel=new JPanel();
	private static JPanel animationpanel=new JPanel();
	private static JPanel sortingpanel=new JPanel();
	static JTextField jt[]=new JTextField[10];
	static Font fonts=new Font("Serif",Font.ITALIC,20);
	QuickSort()
	{
		JTextField array[]=StartPaige.returnField();
		 int temp[]=new int[10];
		 
		 for(int i=0;i<10;i++)
		 {
			 temp[i]=Integer.parseInt(array[i].getText());
		 }
	    JPanel main=new JPanel();
		main.setVisible(true);
		main.setLayout(null);
		main.add(QuickSort.returnHead(temp,"QuickSort"));
		main.add(QuickSort.returnAni1());
		main.add(QuickSort.returnSorting(temp));
		main.setBounds(5,5,1190,790);
		main.setBackground(Color.LIGHT_GRAY);
		SortQuick t1=new SortQuick(jt, temp, 0, 9);
		t1.start();
		jf.add(main);
		jf.setSize(1200,800);
		jf.setVisible(true);
		jf.setLayout(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	public static JPanel returnHead(int temp[], String string)
	{   JTextField array[]=new JTextField[10];
		headpanel.setLayout(new BoxLayout(headpanel,BoxLayout.PAGE_AXIS));
		headpanel.setVisible(true);
		
		JPanel head1=new JPanel();
		head1.setVisible(true);
		head1.setBackground(Color.YELLOW);
		//head1.setBounds(5,5,1180,100);
		head1.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel heading=new JLabel(string);
		heading.setFont(fonts);
		head1.add(heading);
		
		JPanel arrayp=new JPanel();
		arrayp.setVisible(true);
		arrayp.setBackground(Color.green);
		
		//head1.setBounds(5,105,1180,100);
		arrayp.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel init=new JLabel("Intial Arrray : ");
		init.setVisible(true);
		init.setFont(fonts);
		arrayp.add(init);
		for(int i=0;i<10;i++)
		{
			array[i]=new JTextField(String.valueOf(temp[i]));
			array[i].setVisible(true);
			array[i].setEditable(false); 
			array[i].setBorder(BorderFactory.createCompoundBorder(
	                    new CustomeBorder(), 
	                    (Border) new EmptyBorder(new Insets(15, 25, 5, 20))));
			array[i].setFont(fonts);
			arrayp.add(array[i]);
		}
		headpanel.setBounds(5,5,1175,160);
		headpanel.add(head1);
		headpanel.add(arrayp);
		headpanel.setBackground(Color.BLUE);
		return headpanel;
	}
	public static JPanel returnAni1()
	{
		
		JLabel arraySorting=new JLabel("Sorting");
		arraySorting.setVisible(true);
		arraySorting.setEnabled(true);
		arraySorting.setFont(fonts);
		JLabel arraySortina1=new JLabel("...");
		arraySortina1.setVisible(true);
		arraySortina1.setEnabled(true);
		arraySortina1.setFont(fonts);
		JLabel arraySortina2=new JLabel("...");
		arraySortina2.setVisible(true);
		arraySortina2.setEnabled(true);
		arraySortina2.setFont(fonts);
		JLabel arraySortinga3=new JLabel("...");
		arraySortinga3.setVisible(true);
		arraySortinga3.setEnabled(true);
		arraySortinga3.setFont(fonts);
		animationpanel.add(arraySorting);
		animationpanel.setBounds(5,170,1175,80);
		animationpanel.add(arraySortina1);
		animationpanel.add(arraySortina2);
		animationpanel.add(arraySortinga3);
		animationpanel.setBackground(Color.CYAN);
		animationpanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		animationpanel.setVisible(true);
		//animationpanel.setBounds(20,270,300, 60);;
		return animationpanel;
	}
	public static JPanel returnSorting(int temp[])
	{
		for(int i=0;i<10;i++) {
			 jt[i]=new JTextField(String.valueOf(temp[i]));
			 jt[i].setEditable(false);
			 jt[i].setVisible(true);
			 jt[i].setFont(fonts);
			 jt[i].setBounds(250+i*70,150, 70, 55);
			// jt[i].setBackground(Color.GREEN);
			 jt[i].setOpaque(false);
			 System.out.println(jt[i].getBounds().x);
			 System.out.println(jt[i].getBounds().y);
			 jt[i].setBorder(BorderFactory.createCompoundBorder(
	                   new CustomeBorder(), 
	                   (Border) new EmptyBorder(new Insets(15, 25, 15, 20))));
			 sortingpanel.add(jt[i]);
			}
		
		sortingpanel.setVisible(true);
		sortingpanel.setLayout(null);
		sortingpanel.setBounds(5,250,1175,500);
		sortingpanel.setBackground(Color.GREEN);
		return  sortingpanel;
	}
	public static JTextField[] rtJt()
	{
		return jt;
	}

}
class SortQuick extends Thread{
	private JTextField jt[];
	int temp[],l,r;
	SortQuick(JTextField jt[],int temp[],int l,int r)
	{
		this.jt=jt;
		this.temp=temp;
		this.r=r;
		this.l=l;
	}
	public void run()
	{
		Quick_sort(temp, l, r);
	}
	int pivatfind ( int temp[],int start ,int end) {
	    int i = start + 1;
	    int piv = temp[start] ;            //make the first element as pivot element.
	    for(int j =start + 1; j <= end ; j++ )  {
	    

	          if ( temp[ j ] < piv) {
	        	  Swap swap=new Swap(i, j, jt,70,55);
	        	  swap.start();
	        	  try {
					Thread.sleep(1350);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	               
	               {
	            		 int temp1=temp[i];
	            		 temp[i]=temp[j];
	            		 temp[j]=temp1;
	            	 }
	            i += 1;
	        }
	   }
	  Swap swap1=new Swap(start,i-1, jt,70,55);
  	  swap1.start();
  	  try {
			Thread.sleep(1350);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	
  	 {
  		 int temp1=temp[start];
  		 temp[start]=temp[i-1];
  		 temp[i-1]=temp1;
  	 }
	   return i-1;                      //return the position of the pivot
	}
	
	void Quick_sort ( int temp[ ] ,int start , int end ) {
		   if( start < end ) {
		        
		         int piv_pos = pivatfind (temp,start , end ) ;     
		         Quick_sort (temp,start , piv_pos -1);   
		         Quick_sort ( temp,piv_pos +1 , end) ;
		   }
		}
	
}
class SortHeap extends Thread{
	private JTextField jt[];
	int temp[],l,r;
	SortHeap(JTextField jt[],int temp[],int l,int r)
	{
		this.jt=jt;
		this.temp=temp;
		this.r=r;
		this.l=l;
	}
	public void run()
	{
		
	}
}
class MergeSort {
	private JFrame jf=new JFrame();
	private static JPanel headpanel=new JPanel();
	private static JPanel animationpanel=new JPanel();
	private static JPanel sortingpanel=new JPanel();
	private static JTextField jt[]=new JTextField[10];
	static Font fonts=new Font("Serif",Font.ITALIC,20);
	MergeSort()
	{
		JTextField array[]=StartPaige.returnField();
		 int temp[]=new int[10];
		 for(int i=0;i<10;i++)
		 {
			 temp[i]=Integer.parseInt(array[i].getText()); 
		 }
	    JPanel main=new JPanel();
		main.setVisible(true);
		main.setLayout(null);
		main.add(MergeSort.returnHead(temp,"MergeSort"));
		main.add(MergeSort.returnAni1());
		main.add(MergeSort.returnSorting(temp));
		main.setBounds(5,5,1190,790);
		main.setBackground(Color.LIGHT_GRAY);  
		SortL sortl=new SortL(temp,0,9);
		sortl.start();
		jf.add(main);
		jf.setSize(1200,800);
		jf.setVisible(true);
		jf.setLayout(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	public static JPanel returnHead(int temp[],String string)
	{   JTextField array[]=new JTextField[10];
		headpanel.setLayout(new BoxLayout(headpanel,BoxLayout.PAGE_AXIS));
		headpanel.setVisible(true);
		
		JPanel head1=new JPanel();
		head1.setVisible(true);
		head1.setBackground(Color.YELLOW);
		//head1.setBounds(5,5,1180,100);
		head1.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel heading=new JLabel(string);
		heading.setFont(fonts);
		head1.add(heading);
		
		JPanel arrayp=new JPanel();
		arrayp.setVisible(true);
		arrayp.setBackground(Color.green);
		arrayp.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel init=new JLabel("Intial Arrray : ");
		init.setVisible(true);
		init.setFont(fonts);
		arrayp.add(init);
		for(int i=0;i<10;i++) 
		{
			array[i]=new JTextField(String.valueOf(temp[i]));
			array[i].setVisible(true);
			array[i].setEditable(false); 
			array[i].setBorder(BorderFactory.createCompoundBorder(
	                    new CustomeBorder(), 
	                    (Border) new EmptyBorder(new Insets(15, 25, 5, 20))));
			array[i].setFont(fonts);
			arrayp.add(array[i]);
		}
		headpanel.setBounds(5,5,1175,160);
		headpanel.add(head1);
		headpanel.add(arrayp);
		headpanel.setBackground(Color.BLUE);
		return headpanel;
	}
	public static JPanel returnAni1()
	{
		
		JLabel arraySorting=new JLabel("Sorting");
		arraySorting.setVisible(true);
		arraySorting.setEnabled(true);
		arraySorting.setFont(fonts);
		JLabel arraySortina1=new JLabel("...");
		arraySortina1.setVisible(true);
		arraySortina1.setEnabled(true);
		arraySortina1.setFont(fonts);
		JLabel arraySortina2=new JLabel("...");
		arraySortina2.setVisible(true);
		arraySortina2.setEnabled(true);
		arraySortina2.setFont(fonts);
		JLabel arraySortinga3=new JLabel("...");
		arraySortinga3.setVisible(true);
		arraySortinga3.setEnabled(true);
		arraySortinga3.setFont(fonts);
		animationpanel.add(arraySorting);
		animationpanel.setBounds(5,170,1175,80);
		animationpanel.add(arraySortina1);
		animationpanel.add(arraySortina2);
		animationpanel.add(arraySortinga3);
		animationpanel.setBackground(Color.CYAN);
		animationpanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		animationpanel.setVisible(true);
		//animationpanel.setBounds(20,270,300, 60);;
		return animationpanel;
	}
	public static JPanel returnSorting(int temp[])
	{
		for(int i=0;i<10;i++) {
			 jt[i]=new JTextField(String.valueOf(temp[i]));
			 jt[i].setEditable(false);
			 jt[i].setVisible(true);
			 jt[i].setFont(fonts);
			 jt[i].setBounds(250+i*70,20, 70, 70);
			// System.out.println(jt[i].getBounds().x);
			// System.out.println(jt[i].getBounds().y);
			 jt[i].setBorder(BorderFactory.createCompoundBorder(
	                   new CustomeBorder(), 
	                   (Border) new EmptyBorder(new Insets(15, 25, 15, 20))));
			 sortingpanel.add(jt[i]);
			}
		
		sortingpanel.setVisible(true);
		sortingpanel.setLayout(null);
		sortingpanel.setBounds(5,250,1175,500);
		sortingpanel.setBackground(Color.GREEN);
		return  sortingpanel;
	}
	public static JTextField[] rtJt()
	{
		return jt;
	}

}
class SortL extends  Thread{
	private JTextField jt[];
	int temp[],l,r;
	SortL(int temp[],int l,int r)
	{
		this.jt=MergeSort.rtJt();
		this.temp=temp;
		this.l=l;
		this.r=r;
		/*for(int i=0;i<10;i++)
		{
			System.out.println("array :i,value "+i+","+temp[i]+",,, field :i,value "+i+","+jt[i].getText());
		}*/
	}
	public void run()
	{
		mergeSort(temp,l,r);
		
	}
	public void guismerge(int l,int m,int r)
	{
		for(int i=l;i<=m;i++)
		{
			
		}
			
	}
	void merge(int arr[], int l, int m, int r) 
	{ 
		MergeLevelArrange levelsort=new  MergeLevelArrange(jt, l, r);
		levelsort.start();
		try {
			//Thread.sleep(4000);
                        levelsort.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    int i, j, k; 
	    int n1 = m - l + 1; 
	    int n2 =  r - m; 
	  
	  
	    int L[]=new int[n1];
	    int  R[]=new int[n2]; 
	
	    for (i = 0; i < n1; i++) 
	        L[i] = arr[l + i]; 
	    for (j = 0; j < n2; j++) 
	        R[j] = arr[m + 1+ j]; 
	  
	   
	    i = 0; 
	    j = 0; 
	    k = l; 
	    while (i < n1 && j < n2) 
	    { 
	        if (L[i] <=R[j]) 
	        { 
	            arr[k] = L[i]; 
	            i++;
	        } 
	        else
	        { /*&System.out.print("Swaping no  Field "+jt[l+i].getText()+","+jt[m+1+j].getText()+"   ,,,,,,  ");
	          System.out.println("Swaping no in arrar "+L[i]+","+R[j]);
	        	Swap swap=new Swap(l+i,m+1+j,MergeSort.rtJt(),70,55);
	        	swap.start();
	        	try {
					Thread.sleep(1350);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
	            arr[k] = R[j]; 
	            j++; 
	        } 
	        k++; 
	    } 
	  
	    
	    while (i < n1) 
	    { 
	    	
	        arr[k] = L[i]; 
	        i++; 
	        k++; 
	    } 
	  
	   
	    while (j < n2) 
	    { 
	        arr[k] = R[j]; 
	        j++; 
	        k++; 
	    }
	    SmallMoveLU t1=new SmallMoveLU(jt,l,m);
	    t1.start();
	    SmallMoveRU t2=new SmallMoveRU(jt,m+1,r);
	    t2.start();
	    try {
			t1.join();
                        t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
		
	
		}
	  

	void mergeSort(int arr[], int l, int r) 
	{ 
	    if (l < r) 
	    { 
	       int m = l+(r-l)/2;
	     
	         
	         SmallMoveLD t1=new SmallMoveLD(jt,l,m);
	         t1.start();
	         try {
				///Thread.sleep(2000);
                                t1.join();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        mergeSort(arr, l, m);
	            
	        //right thread    
	          // System.out.println("Right GO");
	    	   SmallMoveRD t2=new SmallMoveRD(jt,m+1,r);
		       t2.start();
		        try {
                            t2.join();
					//Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
	        mergeSort(arr,m+1, r);
	        
	        // Meging thread
	        for(int i=l;i<=r;i++)
			{
				System.out.println(" Merging value------>>  array :i,value "+i+","+temp[i]+",,, field :i,value "+i+","+jt[i].getText());
			}
	        merge(arr, l, m, r);
	    } 
	} 
	
}

class SmallMoveLD extends Thread {
	private JTextField jt1[];
	private int i,j;
	private CordinateRecord cr[];
	SmallMoveLD( JTextField jt[],int i,int j)
	{
		this.jt1=jt;
		this.i=i;
		this.j=j;
		this.cr=new CordinateRecord[j-i+1];
		setRecord();
		//System.out.println("index from left :"+i+","+j);
		
	}
	
	private void setRecord() {
		
		for(int h=i,counter=0;h<=j &&counter<cr.length ;h++,counter++)
		{   
			//System.out.println("x,y for jt::"+h);
			this.cr[counter]=new CordinateRecord(jt1[h].getBounds().x,jt1[h].getBounds().y);
			
		}
		
	}
	public void run()
	{
		for(int m=0;m<40;m++)
		{
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int no=i,c=0;no<=j&& c<cr.length;no++,c++)
			{
				jt1[no].setBounds(cr[c].getXi()-m,cr[c].getYi(), 70,70);
				cr[c].setXt(cr[c].getXi()-m);
				cr[c].setYt(cr[c].getYi());
			}
		}
		for(int m=0;m<55;m++)
		{
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int no=i,c=0;no<=j&& c<cr.length;no++,c++)
			{
				jt1[no].setBounds(cr[c].getXt(),cr[c].getYi()+m, 70,70);
				cr[c].setXt(cr[c].getXt());
				cr[c].setYt(cr[c].getYi()+m);
			}
		}
		
	}
}
class SmallMoveLU extends Thread {
	private JTextField jt1[];
	private int i,j;
	private CordinateRecord cr[];
	SmallMoveLU( JTextField jt[],int i,int j)
	{
		this.jt1=jt;
		this.i=i;
		this.j=j;
		this.cr=new CordinateRecord[j-i+1];
		setRecord();
	
		
	}
	
	private void setRecord() {
		
		for(int h=i,counter=0;h<=j &&counter<cr.length ;h++,counter++)
		{   
			//System.out.println("x,y for jt::"+h);
			this.cr[counter]=new CordinateRecord(jt1[h].getBounds().x,jt1[h].getBounds().y);
			
		}
		
	}
	public void run()
	{
		for(int m=0;m<55;m++)
		{
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int no=i,c=0;no<=j&& c<cr.length;no++,c++)
			{
				jt1[no].setBounds(cr[c].getXi(),cr[c].getYi()-m, 70,70);
				cr[c].setXt(cr[c].getXi());
				cr[c].setYt(cr[c].getYi()-m);
			}
		}
		for(int m=0;m<40;m++)
		{
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int no=i,c=0;no<=j&& c<cr.length;no++,c++)
			{
				jt1[no].setBounds(cr[c].getXt()+m,cr[c].getYt(), 70,70);
				//cr[c].setXt(cr[c].getX()+m);
				//cr[c].setYt(cr[c].getYi());
			}
		}
		
	}
}
class MergeLevelArrange extends Thread
{
private JTextField[] jt;
private int r;
private int l;
	public MergeLevelArrange(JTextField jt[],int l,int r) 
	{
		
		this.l=l;
		this.r=r;
		this.jt=jt;
	}

	public void run()
	{ 
		int minimum;        
        for(int i = l; i < r ; i++)  {

          
             minimum = i ;

        

            for(int j = i+1; j <=r ; j++ )
            {
                if(Integer.parseInt(jt[ j ].getText()) < Integer.parseInt(jt[ minimum ].getText()))  {              
                minimum = j ;
                }
             
             }
            if(!jt[i].getText().equals(jt[minimum].getText())) {
            
            	SwapLevel sp=new SwapLevel(i,minimum,jt,70,70);
                sp.start();
            try {
				///Thread.sleep(500);
                                sp.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
        else {
        	}
         
        }

}}
class SmallMoveRD extends Thread {
	private JTextField jt1[];
	private int i,j;
	private CordinateRecord cr[];
	SmallMoveRD( JTextField jt[],int i,int j)
	{
		this.jt1=jt;
		this.i=i;
		this.j=j;
		this.cr=new CordinateRecord[j-i+1];
		setRecord();
		//System.out.println("index from right:: "+i+","+j);
		
	}
	
	private void setRecord() {
		
		for(int h=i,counter=0;h<=j &&counter<cr.length ;h++,counter++)
		{   
			//System.out.println("x,y for jt::"+h);
			this.cr[counter]=new CordinateRecord(jt1[h].getBounds().x,jt1[h].getBounds().y);
			
		}
		
	}
	public void run()
	{
		for(int m=0;m<40;m++)
		{
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int no=i,c=0;no<=j&& c<cr.length;no++,c++)
			{
				jt1[no].setBounds(cr[c].getXi()+m,cr[c].getYi(), 70,70);
				cr[c].setXt(cr[c].getXi()+m);
				cr[c].setYt(cr[c].getYi());
			}
		}
		for(int m=0;m<55;m++)
		{
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int no=i,c=0;no<=j&& c<cr.length;no++,c++)
			{
				jt1[no].setBounds(cr[c].getXt(),cr[c].getYi()+m, 70,70);
				cr[c].setXt(cr[c].getXt());
				cr[c].setYt(cr[c].getYi()+m);
			}
		}
		
	}
}
class SmallMoveRU extends Thread {
	private JTextField jt1[];
	private int i,j;
	private CordinateRecord cr[];
	SmallMoveRU( JTextField jt[],int i,int j)
	{
		this.jt1=jt;
		this.i=i;
		this.j=j;
		this.cr=new CordinateRecord[j-i+1];
		setRecord();
		//System.out.println("index from left :"+i+","+j);
		
	}
	
	private void setRecord() {
		
		for(int h=i,counter=0;h<=j &&counter<cr.length ;h++,counter++)
		{   
			//System.out.println("x,y for jt::"+h);
			this.cr[counter]=new CordinateRecord(jt1[h].getBounds().x,jt1[h].getBounds().y);
			
		}
		
	}
	public void run()
	{
		for(int m=0;m<55;m++)
		{
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int no=i,c=0;no<=j&& c<cr.length;no++,c++)
			{
				jt1[no].setBounds(cr[c].getXi(),cr[c].getYi()-m, 70,70);
				cr[c].setXt(cr[c].getXt());
				cr[c].setYt(cr[c].getYi()-m);
			}
		}
		for(int m=0;m<40;m++)
		{
			try {
				Thread.sleep(1); 
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int no=i,c=0;no<=j&& c<cr.length;no++,c++)
			{
				jt1[no].setBounds(cr[c].getXi()-m,cr[c].getYt(), 70,70);
				//cr[c].setXt(cr[c].getXi()-m);
				//cr[c].setYt(cr[c].getYi());
			}
		}
		
	}
}
class CordinateRecord{
	int xi,yi;
	int xt,yt;
	public CordinateRecord(int x, int y) {
		this.xi=x;
		this.yi=y;
	}
	public int getXi() {
		return xi;
	}
	public void setXi(int xi) {
		this.xi = xi;
	}
	public int getYi() {
		return yi;
	}
	public void setYi(int yi) {
		this.yi = yi;
	}
	public int getXt() {
		return xt;
	}
	public void setXt(int xt) {
		this.xt = xt;
	}
	public int getYt() {
		return yt;
	}
	public void setYt(int yt) {
		this.yt = yt;
	}
	public int getXf() {
		return xf;
	}
	public void setXf(int xf) {
		this.xf = xf;
	}
	public int getYf() {
		return yf;
	}
	public void setYf(int yf) {
		this.yf = yf;
	}
	int xf,yf;
}
class HeapSort {
	private JFrame jf=new JFrame();
	private static JPanel headpanel=new JPanel();
	private static JPanel animationpanel=new JPanel();
	private static JPanel sortingpanel=new JPanel();
	private static JTextField jt[]=new JTextField[10];
	
	private static JLabel jflabel[]=new JLabel[10];
	static Font fonts=new Font("Serif",Font.ITALIC,20);

	HeapSort()
	{
		JTextField array[]=StartPaige.returnField();
		 int temp[]=new int[10];
		 
		 for(int i=0;i<10;i++)
		 {
			 temp[i]=Integer.parseInt(array[i].getText()); 
		 }
	    JPanel main=new JPanel();
		main.setVisible(true);
		main.setLayout(null);
		main.add(MergeSort.returnHead(temp,"HeapSort"));
		main.add(MergeSort.returnAni1());
		main.add(HeapSort.returnSorting(temp));
		main.setBounds(5,5,1190,790);
		main.setBackground(Color.LIGHT_GRAY);  
		
		jf.add(main);
		jf.setSize(1200,800);
		jf.setVisible(true);
		jf.setLayout(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	public static JPanel getspanel()
	{
		return sortingpanel;
	}
	private static Component returnSorting(int[] temp) {
		
		for(int i=0;i<10;i++){
			 jt[i]=new JTextField(String.valueOf(temp[i]));
			 jt[i].setEditable(false);
			 jt[i].setVisible(true);
			 jt[i].setFont(fonts);
			 jt[i].setBounds(250+i*70,20, 70, 55);
			
			 jt[i].setBorder(BorderFactory.createCompoundBorder(
	                   new CustomeBorder(), 
	                   (Border) new EmptyBorder(new Insets(15, 25, 15, 20))));
			 sortingpanel.add(jt[i]);
			}
		new CreateHeap();
		sortingpanel.setVisible(true);
		sortingpanel.setLayout(null);
		sortingpanel.setBounds(5,250,1175,500);
		//sortingpanel.setBackground(Color.GREEN);//
		return  sortingpanel;
	}
	public static JTextField[] findField()
	{
		return jt;
	}
	public static JLabel[] findLabel()
	{
		return jflabel;
	}
}
class CreateHeap extends Applet{
	JLabel jflabel[]=HeapSort.findLabel();
	JTextField jt1[]=HeapSort.findField();
	public void paint(Graphics g) {
	for(int i=0;i<10;i++)
	{
		System.out.println("inpaint");
	jflabel[i]=new JLabel(jt1[i].getText())	;
	jflabel[i].setVisible(true);
	jflabel[i].setBackground(Color.MAGENTA);
	jflabel[i].setBorder(BorderFactory.createCompoundBorder(new CircularBorder(),(Border)new EmptyBorder(new Insets(15,25,15,20))));
    if(i==0)
    {
    jflabel[i].setBounds(200,130, 65,65);	
    }
    else if(i%2==0)
    {
    int parent=(i-2)/2;
    int px=jflabel[parent].getBounds().x;
    int py=jflabel[parent].getBounds().y;
    jflabel[i].setBounds(px+90, py+75, 65, 65);
    }
    else if(i%2!=0)
    {
    	int parent=(i-1)/2;
        int px=jflabel[parent].getBounds().x;
        int py=jflabel[parent].getBounds().y;
        jflabel[i].setBounds(px-60, py+65, 65,65);
    }
    HeapSort.getspanel().add(jflabel[i]);
	}
	{
		
	}
	
}
class Position{
	private int x,y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}}
