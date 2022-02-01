import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialogThreeBtns;

public class kss
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  
  public kss(QQCustomDialogThreeBtns paramQQCustomDialogThreeBtns, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogThreeBtns.a != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogThreeBtns.a.onClick(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogThreeBtns, this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogThreeBtns.a(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogThreeBtns.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     kss
 * JD-Core Version:    0.7.0.1
 */