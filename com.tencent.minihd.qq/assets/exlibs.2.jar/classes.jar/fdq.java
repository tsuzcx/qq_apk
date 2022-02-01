import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.SubAccountMessageActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.List;
import mqq.app.MobileQQ;

public class fdq
  implements ActionSheet.OnButtonClickListener
{
  public fdq(SubAccountMessageActivity paramSubAccountMessageActivity, boolean paramBoolean1, ActionSheet paramActionSheet, boolean paramBoolean2) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    boolean bool = true;
    int i = paramInt;
    if (!this.jdField_a_of_type_Boolean) {
      i = paramInt + 1;
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
    Object localObject;
    switch (i)
    {
    default: 
      return;
    case 0: 
      localObject = SubLoginActivity.class;
      Intent localIntent = new Intent();
      List localList = this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.app.getApplication().getAllAccounts();
      paramView = (View)localObject;
      if (localList != null)
      {
        paramView = (View)localObject;
        if (localList.size() > 2) {
          paramView = SubAccountBindActivity.class;
        }
      }
      localIntent.setClass(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity, paramView);
      localIntent.putExtra("fromWhere", this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.a);
      this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.startActivity(localIntent);
      ReportController.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.app, "CliOper", "", "", "0X800445A", "0X800445A", 0, 0, "", "", "", "");
      return;
    case 1: 
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.app;
      localObject = SubAccountMessageActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity).subuin;
      if (!this.b)
      {
        SubAccountControll.a(paramView, (String)localObject, bool);
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.app;
        if (this.b) {
          break label261;
        }
      }
      for (paramView = "1";; paramView = "0")
      {
        ReportController.b((QQAppInterface)localObject, "CliOper", "", "", "Bind_account", "Top_bind_account", 0, 0, paramView, "", "", "");
        return;
        bool = false;
        break;
      }
    case 2: 
      label261:
      SubAccountMessageActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity, true, false);
      return;
    }
    SubAccountMessageActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity, false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fdq
 * JD-Core Version:    0.7.0.1
 */