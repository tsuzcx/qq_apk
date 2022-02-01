import android.telephony.PhoneStateListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qav.log.AVLog;
import com.tencent.qav.monitor.PhoneStatusMonitor;
import com.tencent.qav.monitor.PhoneStatusMonitor.PhoneStatusListener;

public class lju
  extends PhoneStateListener
{
  private lju(PhoneStatusMonitor paramPhoneStatusMonitor) {}
  
  public void onCallStateChanged(int paramInt, String paramString)
  {
    AVLog.d("PhoneStatusMonitor", String.format("onCallStateChanged state=%s incomingNumber=%s", new Object[] { Integer.valueOf(paramInt), paramString }));
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (!PhoneStatusMonitor.a(this.a));
        ThreadManager.b(new ljv(this));
        return;
      } while (PhoneStatusMonitor.a(this.a));
      PhoneStatusMonitor.a(this.a, true);
    } while (PhoneStatusMonitor.a(this.a) == null);
    PhoneStatusMonitor.a(this.a).c(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lju
 * JD-Core Version:    0.7.0.1
 */