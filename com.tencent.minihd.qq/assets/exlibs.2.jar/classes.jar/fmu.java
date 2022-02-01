import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.UserguideBaseActivity;
import com.tencent.qphone.base.util.QLog;

public class fmu
  implements Animation.AnimationListener
{
  public fmu(UserguideBaseActivity paramUserguideBaseActivity, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UserguideBaseActivity", 2, "fadeIn onAnimationEnd");
    }
    this.jdField_a_of_type_AndroidViewView.setAlpha(1.0F);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UserguideBaseActivity", 2, "fadeIn onAnimationStart");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fmu
 * JD-Core Version:    0.7.0.1
 */