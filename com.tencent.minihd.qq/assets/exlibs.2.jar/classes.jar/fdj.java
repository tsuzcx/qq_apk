import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.SubAccountMessageActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;

public class fdj
  implements DialogInterface.OnClickListener
{
  public fdj(SubAccountMessageActivity paramSubAccountMessageActivity, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.app.a().c(SubAccountMessageActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity).subuin, 7000);
    paramDialogInterface = (SubAccountManager)this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.app.getManager(59);
    if (paramDialogInterface != null) {
      paramDialogInterface.b(SubAccountMessageActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity).subuin);
    }
    paramDialogInterface = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity, SubLoginActivity.class);
    paramDialogInterface.putExtra("is_need_bind", false);
    paramDialogInterface.putExtra("subuin", this.jdField_a_of_type_JavaLangString);
    paramDialogInterface.putExtra("fromWhere", this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.startActivity(paramDialogInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.b();
    this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountMessageActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fdj
 * JD-Core Version:    0.7.0.1
 */