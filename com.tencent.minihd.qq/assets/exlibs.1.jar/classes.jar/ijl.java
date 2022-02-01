import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.VerifyPwdView;
import com.tencent.mobileqq.filemanager.util.IReport_Ver51;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;

public class ijl
  implements RadioGroup.OnCheckedChangeListener
{
  public ijl(FMActivity paramFMActivity) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    if (FMActivity.a(this.a) != null)
    {
      if (this.a.c())
      {
        FMActivity.b(this.a).setVisibility(0);
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.b.setVisibility(8);
      }
    }
    else
    {
      this.a.g();
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setVisibility(0);
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView != null)
      {
        this.a.b.removeAllViews();
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView.setVisibility(8);
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView.a();
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView = null;
        this.a.b.addView(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView);
      }
      if (paramInt != 2131299514) {
        break label172;
      }
      this.a.a().f();
      FMActivity.c(this.a);
    }
    label172:
    do
    {
      return;
      FMActivity.c(this.a).setVisibility(8);
      break;
      if (paramInt == 2131299515)
      {
        this.a.a().e();
        this.a.jdField_a_of_type_AndroidWidgetRadioButton.setSelected(false);
        FMActivity.d(this.a);
        return;
      }
    } while (paramInt != 2131299516);
    this.a.a().d();
    this.a.jdField_a_of_type_AndroidWidgetRadioButton.setSelected(false);
    FMActivity.a(this.a, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ijl
 * JD-Core Version:    0.7.0.1
 */