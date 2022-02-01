import android.widget.ImageView;
import com.tencent.mobileqq.dating.widget.CustomTabBarView;
import com.tencent.mobileqq.dating.widget.CustomTabBarView.OnTabChangeListener;

public class iep
  implements Runnable
{
  public iep(CustomTabBarView paramCustomTabBarView, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    if (CustomTabBarView.a(this.jdField_a_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView) != null) {
      CustomTabBarView.a(this.jdField_a_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean);
    }
    this.jdField_a_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView.a.clearAnimation();
    this.jdField_a_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView.f = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqDatingWidgetCustomTabBarView.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iep
 * JD-Core Version:    0.7.0.1
 */