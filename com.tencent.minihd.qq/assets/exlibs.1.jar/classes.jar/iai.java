import android.app.Dialog;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.dating.DatingDestinationActivity;

public class iai
  implements Animation.AnimationListener
{
  public iai(DatingDestinationActivity paramDatingDestinationActivity, TranslateAnimation paramTranslateAnimation1, Dialog paramDialog, int paramInt, TranslateAnimation paramTranslateAnimation2) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    if (paramAnimation == this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation)
    {
      this.jdField_a_of_type_AndroidAppDialog.show();
      localLayoutParams.height = (DatingDestinationActivity.b(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDestinationActivity).getHeight() + this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      DatingDestinationActivity.b(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDestinationActivity).setLayoutParams(localLayoutParams);
      return;
      if (paramAnimation == this.b) {
        localLayoutParams.height = (DatingDestinationActivity.b(this.jdField_a_of_type_ComTencentMobileqqDatingDatingDestinationActivity).getHeight() - this.jdField_a_of_type_Int);
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iai
 * JD-Core Version:    0.7.0.1
 */