import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.view.VipProfileSimpleView;

public class jor
  implements Animation.AnimationListener
{
  public jor(VipProfileSimpleView paramVipProfileSimpleView, ProfileCardInfo paramProfileCardInfo) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileViewVipProfileSimpleView.b = true;
    this.jdField_a_of_type_ComTencentMobileqqProfileViewVipProfileSimpleView.d(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jor
 * JD-Core Version:    0.7.0.1
 */