import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.Call;

public class dkt
  extends BroadcastReceiver
{
  public dkt(Call paramCall) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (("android.intent.action.TIME_SET".equals(paramContext)) || ("android.intent.action.TIMEZONE_CHANGED".equals(paramContext)) || ("android.intent.action.DATE_CHANGED".equals(paramContext))) {
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dkt
 * JD-Core Version:    0.7.0.1
 */