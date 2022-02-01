import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.SubAccountSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.subaccount.SubAccountProtocManager;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class fej
  implements ActionSheet.OnButtonClickListener
{
  public fej(SubAccountSettingActivity paramSubAccountSettingActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while ((!this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountSettingActivity.b()) || ((SubAccountSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountSettingActivity) != null) && (TextUtils.isEmpty(SubAccountSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountSettingActivity).subuin))));
    this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountSettingActivity.a(2131368738);
    paramView = (SubAccountProtocManager)this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountSettingActivity.app.getManager(27);
    if (paramView != null) {
      paramView.a(SubAccountSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountSettingActivity).subuin);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fej
 * JD-Core Version:    0.7.0.1
 */