import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomSingleButtonDialog;

public class ktd
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  
  public ktd(QQCustomSingleButtonDialog paramQQCustomSingleButtonDialog, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSingleButtonDialog.a != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSingleButtonDialog.a.onClick(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSingleButtonDialog, this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSingleButtonDialog.a(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSingleButtonDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ktd
 * JD-Core Version:    0.7.0.1
 */