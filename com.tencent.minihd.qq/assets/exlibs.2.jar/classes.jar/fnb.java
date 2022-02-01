import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.UserguideFaceMaskActivity;

public class fnb
  implements Animation.AnimationListener
{
  public fnb(UserguideFaceMaskActivity paramUserguideFaceMaskActivity, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    UserguideFaceMaskActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityUserguideFaceMaskActivity).sendEmptyMessageDelayed(2, 1300L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fnb
 * JD-Core Version:    0.7.0.1
 */