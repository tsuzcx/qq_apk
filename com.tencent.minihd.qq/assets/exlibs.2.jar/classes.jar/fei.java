import android.view.View;
import com.tencent.mobileqq.activity.SubAccountSettingActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.SubAccountMessageProcessor;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class fei
  implements ActionSheet.OnButtonClickListener
{
  public fei(SubAccountSettingActivity paramSubAccountSettingActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    paramView = "";
    if (SubAccountSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountSettingActivity) != null) {
      paramView = SubAccountSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountSettingActivity).subuin;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountSettingActivity.app, "CliOper", "", paramView, "Bind_account", "Clean_msg_tipslist", 0, 0, "", "", "", "");
    if (SubAccountSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountSettingActivity) != null)
    {
      paramView = (SubAccountManager)this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountSettingActivity.app.getManager(59);
      if (paramView != null)
      {
        paramView.c(SubAccountSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountSettingActivity).subuin);
        this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountSettingActivity.app.a().c(SubAccountSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountSettingActivity).subuin, 7000);
        ((MessageHandler)this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountSettingActivity.app.a(0)).a().a(SubAccountSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountSettingActivity).subuin, "sub.account.none");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountSettingActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountSettingActivity.getString(2131366677));
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fei
 * JD-Core Version:    0.7.0.1
 */