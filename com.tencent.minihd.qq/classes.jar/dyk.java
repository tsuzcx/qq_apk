import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class dyk
  implements DialogInterface.OnClickListener
{
  public dyk(ForwardOperations paramForwardOperations, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a.setResult(-1);
    this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     dyk
 * JD-Core Version:    0.7.0.1
 */