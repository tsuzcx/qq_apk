import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;

public class ede
  implements View.OnClickListener
{
  public ede(GesturePWDUnlockActivity paramGesturePWDUnlockActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.c();
    GesturePWDUtils.setGestureUnlockFailedType(this.a, 0);
    StatisticCollector.a(this.a.getBaseContext()).a(this.a.app, this.a.app.a(), "Gesture_pwd", "click_forgive", 0, 1, "0", null, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ede
 * JD-Core Version:    0.7.0.1
 */