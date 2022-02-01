import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.view.ProfileTagView;
import com.tencent.mobileqq.profile.view.VipTagView;

public class jok
  implements Animation.AnimationListener
{
  public jok(ProfileTagView paramProfileTagView, boolean paramBoolean, VipTagView paramVipTagView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.a.a.a != 0) && (this.jdField_a_of_type_ComTencentMobileqqProfileViewVipTagView.getTag(2131296433) != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileViewVipTagView.getTag(2131296433).equals(Boolean.valueOf(true))))
    {
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipTagView.setTag(2131296433, Boolean.valueOf(false));
      ProfileTagView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView, this.jdField_a_of_type_ComTencentMobileqqProfileViewVipTagView, ((Long)this.jdField_a_of_type_ComTencentMobileqqProfileViewVipTagView.getTag(2131296434)).longValue());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqProfileViewVipTagView.setShakingState(true);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jok
 * JD-Core Version:    0.7.0.1
 */