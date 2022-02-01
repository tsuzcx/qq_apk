import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.widget.doyen.DoyenEarthLayout;

public class hcf
  implements Animation.AnimationListener
{
  public hcf(DoyenEarthLayout paramDoyenEarthLayout) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    DoyenEarthLayout.e(this.a).clearAnimation();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hcf
 * JD-Core Version:    0.7.0.1
 */