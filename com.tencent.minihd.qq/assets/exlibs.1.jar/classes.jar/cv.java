import android.os.Handler;
import android.os.Looper;
import com.dataline.util.DLRouterSessionInfoRequestTask;
import java.util.TimerTask;

public class cv
  extends TimerTask
{
  public cv(DLRouterSessionInfoRequestTask paramDLRouterSessionInfoRequestTask, int paramInt, long paramLong) {}
  
  public void run()
  {
    new Handler(Looper.getMainLooper()).post(new cw(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cv
 * JD-Core Version:    0.7.0.1
 */