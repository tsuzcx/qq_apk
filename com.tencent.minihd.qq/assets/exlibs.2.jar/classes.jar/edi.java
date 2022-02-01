import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;

public class edi
  implements DialogInterface.OnDismissListener
{
  public edi(GesturePWDUnlockActivity paramGesturePWDUnlockActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!GesturePWDUnlockActivity.a(this.a))
    {
      GesturePWDUnlockActivity.a(this.a, true);
      return;
    }
    this.a.c();
    GesturePWDUtils.setGestureUnlockFailedType(this.a, 1);
    StatisticCollector.a(this.a.getBaseContext()).a(this.a.app, this.a.app.a(), "Gesture_pwd", "click_wrong_pwd", 0, 1, "0", null, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     edi
 * JD-Core Version:    0.7.0.1
 */