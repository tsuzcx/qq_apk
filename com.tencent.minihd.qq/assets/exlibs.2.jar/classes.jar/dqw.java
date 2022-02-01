import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.ChatSettingForTroop;

class dqw
  implements Animation.AnimationListener
{
  dqw(dqv paramdqv, LinearLayout paramLinearLayout) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = new TranslateAnimation(-this.jdField_a_of_type_Dqv.a.ay, 0.0F, 0.0F, 0.0F);
    paramAnimation.setDuration(800L);
    paramAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(paramAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dqw
 * JD-Core Version:    0.7.0.1
 */