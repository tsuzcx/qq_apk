import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.widget.qqmusic.business.vkey.VkeyNet;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.ApnManager;

public class hdf
  extends Handler
{
  public hdf(VkeyNet paramVkeyNet, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message arg1)
  {
    for (;;)
    {
      synchronized (VkeyNet.a(this.a))
      {
        if (VkeyNet.a(this.a) < 5)
        {
          if (ApnManager.a())
          {
            VkeyNet.b(this.a);
            if (!VkeyNet.a(this.a)) {
              VkeyNet.a(this.a).sendEmptyMessageDelayed(0, 5000L);
            }
            return;
          }
          VkeyNet.a(this.a, true);
        }
      }
      VkeyNet.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hdf
 * JD-Core Version:    0.7.0.1
 */