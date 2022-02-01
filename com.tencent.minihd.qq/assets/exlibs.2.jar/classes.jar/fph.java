import com.tencent.mobileqq.activity.aio.PanelAdapter;
import com.tencent.mobileqq.activity.aio.PlusPanel;

public class fph
  implements Runnable
{
  public fph(PlusPanel paramPlusPanel) {}
  
  public void run()
  {
    int i = 0;
    while (i < this.a.a.getCount())
    {
      this.a.a.c(i);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fph
 * JD-Core Version:    0.7.0.1
 */