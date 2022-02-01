import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;

class ehw
  implements Animation.AnimationListener
{
  ehw(ehv paramehv) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    LoginActivity.c(this.a.a).clearAnimation();
    LoginActivity.c(this.a.a).setAnimation(null);
    LoginActivity.a(this.a.a).invalidate();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ehw
 * JD-Core Version:    0.7.0.1
 */