import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qqmusicplayerprocess.netspeed.VkeyManager;

public class lqb
  extends Handler
{
  public lqb(VkeyManager paramVkeyManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    this.a.getVKey();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lqb
 * JD-Core Version:    0.7.0.1
 */