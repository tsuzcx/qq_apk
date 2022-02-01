import android.app.Dialog;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.AccountManageActivity;

class ddd
  implements Runnable
{
  ddd(ddc paramddc) {}
  
  public void run()
  {
    int i = 0;
    try
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidWidgetLinearLayout.removeViewAt(this.a.jdField_a_of_type_Int);
      label22:
      if (!this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.b) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.a(false);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidViewView = null;
      int j = this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      while (i < j)
      {
        View localView = this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
        if (localView.getTag() != null) {
          localView.setTag(Integer.valueOf(i));
        }
        i += 1;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidAppDialog.dismiss();
      return;
    }
    catch (Exception localException)
    {
      break label22;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ddd
 * JD-Core Version:    0.7.0.1
 */