import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.tencent.mobileqq.app.QQTabActivity;

public class hoj
  extends BroadcastReceiver
{
  public hoj(QQTabActivity paramQQTabActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    Log.i("app2", "splash task receive stop=" + QQTabActivity.a(this.a) + " onStart=" + QQTabActivity.b(this.a) + " action=" + paramContext);
    if ((paramContext.equals("splash_task_show")) && (QQTabActivity.a(this.a)) && (!QQTabActivity.b(this.a))) {
      paramContext = (ActivityManager)this.a.getSystemService("activity");
    }
    while (!paramContext.equals("splash_task_hdie")) {
      try
      {
        Log.i("app2", "splash task receive ");
        paramContext.moveTaskToFront(this.a.getTaskId(), 0);
        return;
      }
      catch (Exception paramContext)
      {
        Log.i("app2", "move splash Task To Front error ", paramContext);
        return;
      }
    }
    try
    {
      this.a.moveTaskToBack(true);
      return;
    }
    catch (Exception paramContext) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hoj
 * JD-Core Version:    0.7.0.1
 */