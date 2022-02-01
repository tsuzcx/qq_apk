import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.LoginActivity;

public class eiv
  implements Animation.AnimationListener
{
  public eiv(LoginActivity paramLoginActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    LoginActivity.a(this.a).clearAnimation();
    paramAnimation = (ViewGroup.MarginLayoutParams)LoginActivity.a(this.a).getLayoutParams();
    paramAnimation.topMargin -= LoginActivity.b(this.a);
    LoginActivity.a(this.a).requestLayout();
    LoginActivity.c(this.a, false);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    LoginActivity.c(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eiv
 * JD-Core Version:    0.7.0.1
 */