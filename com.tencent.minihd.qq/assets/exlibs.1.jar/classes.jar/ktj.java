import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomSplitDialog;

public class ktj
  implements View.OnClickListener
{
  public ktj(QQCustomSplitDialog paramQQCustomSplitDialog, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSplitDialog, 0);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomSplitDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ktj
 * JD-Core Version:    0.7.0.1
 */