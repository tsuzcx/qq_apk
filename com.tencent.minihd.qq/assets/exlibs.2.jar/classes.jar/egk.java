import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.tencent.mobileqq.activity.Leba;

public class egk
  extends BroadcastReceiver
{
  public egk(Leba paramLeba) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    Log.i("app2", "LebaListRefreshBroadcastReceiver action=" + paramContext);
    if (paramContext.equals("leba_list_refresh"))
    {
      Log.i("app2", "onActivityResult lebalist resume=" + this.a.isResume());
      if (!this.a.isResume()) {
        this.a.doOnResume();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     egk
 * JD-Core Version:    0.7.0.1
 */