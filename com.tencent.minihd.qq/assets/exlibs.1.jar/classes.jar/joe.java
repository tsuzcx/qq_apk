import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.profile.view.ProfileTagView;

public class joe
  implements Animation.AnimationListener
{
  public joe(ProfileTagView paramProfileTagView, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    ProfileTagView.b(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView);
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    ProfileTagView.b(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView, false);
    if (ProfileTagView.c(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView) == 0) {
      ProfileTagView.c(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     joe
 * JD-Core Version:    0.7.0.1
 */