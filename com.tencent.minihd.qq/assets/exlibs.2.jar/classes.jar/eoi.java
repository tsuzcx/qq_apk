import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class eoi
  implements CompoundButton.OnCheckedChangeListener
{
  public eoi(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    NotifyPushSettingActivity.a(this.a).setContentDescription("夜间防骚扰模式");
    SettingCloneUtil.writeValue(this.a, null, "no_disturb_mode", "qqsetting_nodisturb_mode_key", paramBoolean);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ReportController.b(this.a.app, "CliOper", "", "", "Setting_tab", "Clk_night_mode", 0, i, String.valueOf(i), "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eoi
 * JD-Core Version:    0.7.0.1
 */