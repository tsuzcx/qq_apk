import android.os.Process;
import com.tencent.component.network.utils.thread.PriorityThreadFactory;

public class cwr
  extends Thread
{
  public cwr(PriorityThreadFactory paramPriorityThreadFactory, Runnable paramRunnable, String paramString)
  {
    super(paramRunnable, paramString);
  }
  
  public void run()
  {
    Process.setThreadPriority(PriorityThreadFactory.a(this.a));
    super.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     cwr
 * JD-Core Version:    0.7.0.1
 */