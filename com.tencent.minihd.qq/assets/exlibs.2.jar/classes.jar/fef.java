import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.SubAccountSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.SubAccountControll;

public class fef
  implements CompoundButton.OnCheckedChangeListener
{
  public fef(SubAccountSettingActivity paramSubAccountSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    SubAccountControll.a(this.a.app, SubAccountSettingActivity.a(this.a).subuin, paramBoolean);
    QQAppInterface localQQAppInterface = this.a.app;
    if (paramBoolean) {}
    for (paramCompoundButton = "1";; paramCompoundButton = "0")
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "Bind_account", "Top_bind_account", 0, 0, paramCompoundButton, "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fef
 * JD-Core Version:    0.7.0.1
 */