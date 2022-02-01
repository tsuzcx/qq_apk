import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.ForwardRecentActivity;

public class eaf
  implements Animation.AnimationListener
{
  public eaf(ForwardRecentActivity paramForwardRecentActivity, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity.findViewById(2131300437).setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity.a.setAnimation(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity.a.offsetTopAndBottom(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityForwardRecentActivity.a.requestLayout();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     eaf
 * JD-Core Version:    0.7.0.1
 */