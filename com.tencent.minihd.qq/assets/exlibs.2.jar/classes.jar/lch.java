import android.graphics.Bitmap;
import android.os.Message;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.open.agent.SmartHardwareActivity;

public class lch
  implements Runnable
{
  public lch(SmartHardwareActivity paramSmartHardwareActivity) {}
  
  public void run()
  {
    try
    {
      Bitmap localBitmap = DeviceHeadMgr.a().a(this.a.c);
      if (localBitmap != null) {
        Message.obtain(SmartHardwareActivity.a(this.a), 1, localBitmap).sendToTarget();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     lch
 * JD-Core Version:    0.7.0.1
 */