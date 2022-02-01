import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qav.log.AVLog;
import com.tencent.qav.monitor.PhoneStatusMonitor;

public class ljs
  extends BroadcastReceiver
{
  private ljs(PhoneStatusMonitor paramPhoneStatusMonitor) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    AVLog.d("PhoneStatusMonitor", String.format("onReceive action=%s", new Object[] { paramContext }));
    if ("android.intent.action.NEW_OUTGOING_CALL".equals(paramContext)) {
      return;
    }
    ThreadManager.b(new ljt(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ljs
 * JD-Core Version:    0.7.0.1
 */