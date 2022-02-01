import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mqp.app.sec.MQPSensitiveMsgUtil;

public final class kzu
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {}
    while ((!paramContext.equals("mqq.intent.action.ACCOUNT_CHANGED")) || (paramIntent.getIntExtra("type", 0) == 0)) {
      return;
    }
    MQPSensitiveMsgUtil.a(paramIntent.getStringExtra("account"));
    MQPSensitiveMsgUtil.b(MQPSensitiveMsgUtil.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kzu
 * JD-Core Version:    0.7.0.1
 */