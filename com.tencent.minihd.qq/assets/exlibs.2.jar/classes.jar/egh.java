import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.util.ThreadPriorityManager;

public class egh
  implements Animation.AnimationListener
{
  public egh(Leba paramLeba) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    Leba.a(this.a).offsetTopAndBottom(this.a.getTitleBarHeight());
    Leba.a(this.a).requestLayout();
    paramAnimation = this.a.findViewById(2131297977);
    if (paramAnimation != null) {
      paramAnimation.setBackgroundResource(0);
    }
    ThreadPriorityManager.a(false);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     egh
 * JD-Core Version:    0.7.0.1
 */