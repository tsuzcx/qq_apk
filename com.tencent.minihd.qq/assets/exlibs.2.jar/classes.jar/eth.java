import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.qphone.base.util.QLog;

public class eth
  extends BroadcastReceiver
{
  public eth(QQMapActivity paramQQMapActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent.getAction().equals("android.intent.action.SCREEN_OFF")) && (!this.a.p) && (!this.a.q) && (GesturePWDUtils.getGesturePWDState(this.a, this.a.m) == 2) && (GesturePWDUtils.getGesturePWDMode(this.a, this.a.m) == 21))
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqbaseactivity", 2, "qqmapactivity.start lock. receive lock.");
      }
      paramContext = new Intent(this.a, GesturePWDUnlockActivity.class);
      QQMapActivity.b(this.a, paramContext);
      this.a.q = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eth
 * JD-Core Version:    0.7.0.1
 */