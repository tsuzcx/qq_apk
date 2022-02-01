import android.os.Looper;
import android.os.Message;
import com.tencent.device.file.DeviceAVFileMsgObserver;
import com.tencent.mobileqq.transfile.TransProcessorHandler;

public class czv
  extends TransProcessorHandler
{
  public czv(DeviceAVFileMsgObserver paramDeviceAVFileMsgObserver, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    this.a.a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     czv
 * JD-Core Version:    0.7.0.1
 */