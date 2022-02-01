import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.trick.TrickHelper;
import com.tencent.qphone.base.util.QLog;

public class kbh
  extends BroadcastReceiver
{
  private kbh(TrickHelper paramTrickHelper) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("TrickHelper", 2, "received with " + paramContext);
    }
    if ("android.intent.action.SCREEN_OFF".equals(paramContext))
    {
      TrickHelper.b = false;
      ThreadManager.a().removeCallbacks(TrickHelper.a(this.a));
    }
    while (!"android.intent.action.SCREEN_ON".equals(paramContext)) {
      return;
    }
    TrickHelper.b = true;
    ThreadManager.a().postDelayed(TrickHelper.a(this.a), 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     kbh
 * JD-Core Version:    0.7.0.1
 */