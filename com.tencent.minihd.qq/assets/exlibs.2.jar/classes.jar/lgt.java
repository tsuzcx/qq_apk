import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.MyAppApi;

public class lgt
  extends BroadcastReceiver
{
  public lgt(MyAppApi paramMyAppApi) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    LogUtility.c("MyAppApi", "onReceive ---INTENT = " + paramIntent);
    if ((paramIntent != null) && (paramIntent.getAction().equals("mqq.intent.action.ACCOUNT_EXPIRED"))) {
      this.a.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     lgt
 * JD-Core Version:    0.7.0.1
 */