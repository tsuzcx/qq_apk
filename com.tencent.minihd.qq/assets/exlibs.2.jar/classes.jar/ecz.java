import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.GesturePWDSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.statistics.ReportController;

public class ecz
  implements CompoundButton.OnCheckedChangeListener
{
  public ecz(GesturePWDSettingActivity paramGesturePWDSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = 1;
    paramCompoundButton = this.a;
    String str = this.a.app.a();
    if (paramBoolean)
    {
      i = 2;
      GesturePWDUtils.setGesturePWDState(paramCompoundButton, str, i);
      this.a.a(paramBoolean);
      paramCompoundButton = this.a.app;
      if (!paramBoolean) {
        break label93;
      }
    }
    label93:
    for (int i = j;; i = 0)
    {
      ReportController.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Setting_Gesture_password", 0, i, "", "", "", "");
      this.a.a();
      return;
      i = 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ecz
 * JD-Core Version:    0.7.0.1
 */