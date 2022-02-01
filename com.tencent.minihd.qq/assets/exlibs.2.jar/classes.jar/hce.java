import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.widget.doyen.DoyenEarthLayout;

public class hce
  implements Animation.AnimationListener
{
  public hce(DoyenEarthLayout paramDoyenEarthLayout) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = AnimationUtils.loadAnimation(DoyenEarthLayout.a(this.a), 2130968615);
    DoyenEarthLayout.d(this.a).startAnimation(paramAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hce
 * JD-Core Version:    0.7.0.1
 */