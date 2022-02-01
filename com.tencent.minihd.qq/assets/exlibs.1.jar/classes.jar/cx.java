import android.os.Handler;
import android.os.Looper;
import com.dataline.util.DLRouterSessionInfoRequestTask;
import java.util.TimerTask;

public class cx
  extends TimerTask
{
  public cx(DLRouterSessionInfoRequestTask paramDLRouterSessionInfoRequestTask) {}
  
  public void run()
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread()) {
      new Handler(localLooper).post(new cy(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cx
 * JD-Core Version:    0.7.0.1
 */