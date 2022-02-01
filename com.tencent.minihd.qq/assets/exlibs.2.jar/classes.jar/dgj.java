import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class dgj
  implements CompoundButton.OnCheckedChangeListener
{
  public dgj(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = 1;
    AssistantSettingActivity.i(this.a).setContentDescription("在底部标签栏展示通话功能");
    SplashActivity.a(paramBoolean);
    if (paramBoolean)
    {
      ReportController.b(this.a.app, "CliOper", "", "", "0X8004EDD", "0X8004EDD", 0, 0, "", "", "", "");
      ((CardHandler)this.a.app.a(2)).b(paramBoolean, true);
      paramCompoundButton = new Integer[7];
      paramCompoundButton[0] = Integer.valueOf(1);
      if (!paramBoolean) {
        break label157;
      }
      i = 1;
      label91:
      paramCompoundButton[3] = Integer.valueOf(i);
      if (!paramBoolean) {
        break label162;
      }
    }
    label157:
    label162:
    for (int i = j;; i = 0)
    {
      paramCompoundButton[4] = Integer.valueOf(i);
      this.a.app.a(paramCompoundButton);
      return;
      ReportController.b(this.a.app, "CliOper", "", "", "0X8004EDC", "0X8004EDC", 0, 0, "", "", "", "");
      break;
      i = 0;
      break label91;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dgj
 * JD-Core Version:    0.7.0.1
 */