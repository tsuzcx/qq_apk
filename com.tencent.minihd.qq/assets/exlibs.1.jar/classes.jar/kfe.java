import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.QLifeCommentActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class kfe
  implements DialogInterface.OnClickListener
{
  public kfe(QLifeCommentActivity paramQLifeCommentActivity, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
    }
    QLifeCommentActivity.b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityQLifeCommentActivity);
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "qlife_comment", "cancel", 0, 0, "", "", "", QLifeCommentActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityQLifeCommentActivity));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kfe
 * JD-Core Version:    0.7.0.1
 */