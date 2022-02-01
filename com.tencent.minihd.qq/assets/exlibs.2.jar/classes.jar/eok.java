import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.util.BadgeUtils;

public class eok
  implements CompoundButton.OnCheckedChangeListener
{
  public eok(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    label23:
    String str;
    if (paramBoolean)
    {
      BadgeUtils.a();
      QQAppInterface localQQAppInterface = this.a.app;
      if (!paramBoolean) {
        break label92;
      }
      paramCompoundButton = "0X8004BE7";
      if (!paramBoolean) {
        break label98;
      }
      str = "0X8004BE7";
      label30:
      ReportController.b(localQQAppInterface, "CliOper", "", "", paramCompoundButton, str, 0, 1, "1", "", "", "");
      if (!paramBoolean) {
        break label104;
      }
    }
    label92:
    label98:
    label104:
    for (paramCompoundButton = "打开";; paramCompoundButton = "关闭")
    {
      paramCompoundButton = String.format("桌面图标显示未读消息数开关，%s，连按两次来切换设置", new Object[] { paramCompoundButton });
      NotifyPushSettingActivity.c(this.a).setContentDescription(paramCompoundButton);
      return;
      BadgeUtils.b();
      break;
      paramCompoundButton = "0X8004BE6";
      break label23;
      str = "0X8004BE6";
      break label30;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eok
 * JD-Core Version:    0.7.0.1
 */