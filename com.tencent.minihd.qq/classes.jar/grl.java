import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.phone.SettingActivity2;
import java.lang.ref.WeakReference;

public class grl
  extends Handler
{
  private WeakReference a;
  
  public grl(SettingActivity2 paramSettingActivity2)
  {
    this.a = new WeakReference(paramSettingActivity2);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((SettingActivity2)this.a.get() == null) {
      return;
    }
    switch (paramMessage.what)
    {
    }
    throw new RuntimeException("Unknown message: " + paramMessage.what);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     grl
 * JD-Core Version:    0.7.0.1
 */