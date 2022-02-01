import SecurityAccountServer.RespondQueryQQBindingStat;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.phone.BindNumberBusinessActivity;
import com.tencent.mobileqq.activity.phone.BindNumberDialogActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.qphone.base.util.QLog;

public class gpq
  extends ContactBindObserver
{
  public gpq(BindNumberDialogActivity paramBindNumberDialogActivity, PhoneContactManager paramPhoneContactManager) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBindNumberDialogActivity.app.unRegistObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBindNumberDialogActivity.a = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBindNumberDialogActivity.a();
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.a();
    int i = this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.b();
    if (localRespondQueryQQBindingStat != null)
    {
      if ((localRespondQueryQQBindingStat.type == 0) && (!TextUtils.isEmpty(localRespondQueryQQBindingStat.mobileNo)) && (i != 2))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBindNumberDialogActivity.c = localRespondQueryQQBindingStat.mobileNo;
        BindNumberDialogActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBindNumberDialogActivity);
        return;
      }
      if ((1 == localRespondQueryQQBindingStat.type) && (QLog.isColorLevel())) {
        QLog.d("BindNumberBusinessActivity", 2, "already bind mobile = " + localRespondQueryQQBindingStat.mobileNo);
      }
    }
    BindNumberBusinessActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBindNumberDialogActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBindNumberDialogActivity.c, this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBindNumberDialogActivity.b);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneBindNumberDialogActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gpq
 * JD-Core Version:    0.7.0.1
 */