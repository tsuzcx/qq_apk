import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class dos
  implements CompoundButton.OnCheckedChangeListener
{
  public dos(ChatSettingActivity paramChatSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (ChatSettingActivity.a(this.a) == paramBoolean) {
      return;
    }
    if (paramBoolean) {
      ReportController.b(this.a.app, "CliOper", "", "", "0X80040EE", "0X80040EE", 0, 0, "2", "1", "", "");
    }
    for (;;)
    {
      ChatSettingActivity.a(this.a);
      return;
      ReportController.b(this.a.app, "CliOper", "", "", "0X80040EE", "0X80040EE", 0, 0, "2", "0", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dos
 * JD-Core Version:    0.7.0.1
 */