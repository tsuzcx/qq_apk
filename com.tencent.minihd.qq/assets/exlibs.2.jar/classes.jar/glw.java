import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.tencent.mobileqq.activity.flaotaio.FloatHbCircle;

public class glw
  extends BroadcastReceiver
{
  public glw(FloatHbCircle paramFloatHbCircle) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("circle_hb_opend".equals(paramIntent.getAction()))
    {
      paramContext = paramIntent.getStringExtra("nativeAndroid");
      if (paramContext != null)
      {
        paramIntent = FloatHbCircle.a(this.a, paramContext);
        Log.i("app2", "initHbReciver onReceive" + paramContext + " hbMsg=" + paramIntent);
        if (paramIntent != null) {
          this.a.b(paramIntent);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     glw
 * JD-Core Version:    0.7.0.1
 */