import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.qqfav.QfavHelper;
import cooperation.qqfav.QfavReport;

class dyx
  implements DialogInterface.OnClickListener
{
  dyx(dyw paramdyw) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QfavHelper.b(this.a.a.jdField_a_of_type_AndroidAppActivity, this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), new Intent().putExtra("is_share_flag", true), -1);
    QfavReport.c(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     dyx
 * JD-Core Version:    0.7.0.1
 */