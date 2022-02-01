import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SubAccountMessageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.SubAccountControll;

public class fdn
  implements View.OnClickListener
{
  public fdn(SubAccountMessageActivity paramSubAccountMessageActivity, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.app;
    Object localObject = SubAccountMessageActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity).subuin;
    boolean bool;
    if (!this.jdField_a_of_type_Boolean)
    {
      bool = true;
      SubAccountControll.a(paramView, (String)localObject, bool);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.app;
      if (this.jdField_a_of_type_Boolean) {
        break label81;
      }
    }
    label81:
    for (paramView = "1";; paramView = "0")
    {
      ReportController.b((QQAppInterface)localObject, "CliOper", "", "", "Bind_account", "Top_bind_account", 0, 0, paramView, "", "", "");
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fdn
 * JD-Core Version:    0.7.0.1
 */