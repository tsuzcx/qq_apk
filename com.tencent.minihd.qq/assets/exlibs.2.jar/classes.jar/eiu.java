import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.LoginActivity;

public class eiu
  implements Animation.AnimationListener
{
  public eiu(LoginActivity paramLoginActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    LoginActivity.a(this.a).clearAnimation();
    paramAnimation = (ViewGroup.MarginLayoutParams)LoginActivity.a(this.a).getLayoutParams();
    paramAnimation.topMargin += LoginActivity.b(this.a);
    LoginActivity.a(this.a).requestLayout();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eiu
 * JD-Core Version:    0.7.0.1
 */