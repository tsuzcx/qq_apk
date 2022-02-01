import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dating.DatingBaseActivity;

public class hzt
  implements View.OnClickListener
{
  public hzt(DatingBaseActivity paramDatingBaseActivity, QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (DatingBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingBaseActivity) != null)
    {
      DatingBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingBaseActivity).dismiss();
      DatingBaseActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingBaseActivity, null);
    }
    DatingBaseActivity.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     hzt
 * JD-Core Version:    0.7.0.1
 */