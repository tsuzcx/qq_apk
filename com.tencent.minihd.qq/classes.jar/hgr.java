import android.os.Process;
import com.tencent.mobileqq.app.BrowserAppInterface;

public class hgr
  implements Runnable
{
  public hgr(BrowserAppInterface paramBrowserAppInterface) {}
  
  public void run()
  {
    Process.killProcess(Process.myPid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hgr
 * JD-Core Version:    0.7.0.1
 */