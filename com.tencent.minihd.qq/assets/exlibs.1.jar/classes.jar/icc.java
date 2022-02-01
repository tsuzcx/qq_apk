import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.dating.DatingUserCenterActivity;

public class icc
  implements View.OnClickListener
{
  public icc(DatingUserCenterActivity paramDatingUserCenterActivity, boolean paramBoolean, int paramInt, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (DatingUserCenterActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingUserCenterActivity) != null)
    {
      DatingUserCenterActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingUserCenterActivity).dismiss();
      DatingUserCenterActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingUserCenterActivity, null);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      DatingUserCenterActivity.b(this.jdField_a_of_type_ComTencentMobileqqDatingDatingUserCenterActivity, this.jdField_a_of_type_Int);
      return;
    }
    DatingUserCenterActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingUserCenterActivity, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     icc
 * JD-Core Version:    0.7.0.1
 */