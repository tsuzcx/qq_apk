import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ThemeSwitchDlgActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.NightModeLogic;

public class ffk
  implements View.OnClickListener
{
  public ffk(ThemeSwitchDlgActivity paramThemeSwitchDlgActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_Boolean = true;
    this.a.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic = new NightModeLogic(this.a.getAppRuntime(), this.a);
    this.a.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.registerModeCallback(new ffl(this));
    if ((this.a.jdField_a_of_type_AndroidAppDialog != null) && (this.a.jdField_a_of_type_AndroidAppDialog.isShowing()))
    {
      this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.a.jdField_a_of_type_AndroidAppDialog = null;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqThemeNightModeLogic.setupNightTheme();
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Setting_tab", "Night_mode_us", 0, 0, "1", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ffk
 * JD-Core Version:    0.7.0.1
 */