import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.UserguideBaseActivity;
import com.tencent.qphone.base.util.QLog;

public class fmt
  implements Animation.AnimationListener
{
  public fmt(UserguideBaseActivity paramUserguideBaseActivity, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UserguideBaseActivity", 2, "fadeOut onAnimationEnd");
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UserguideBaseActivity", 2, "fadeOut onAnimationStart");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fmt
 * JD-Core Version:    0.7.0.1
 */