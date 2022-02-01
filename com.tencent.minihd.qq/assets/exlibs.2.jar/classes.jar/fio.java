import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class fio
  implements DialogInterface.OnClickListener
{
  public fio(TroopMemberCardActivity paramTroopMemberCardActivity, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.getApplicationContext()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.a.i(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c);
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.a(0, 2131367795, 0);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.getString(2131367136));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fio
 * JD-Core Version:    0.7.0.1
 */