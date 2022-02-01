import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import cooperation.qqfav.widget.LocationDetailActivity;

public class lzn
  implements Animation.AnimationListener
{
  public lzn(LocationDetailActivity paramLocationDetailActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.g.clearAnimation();
    this.a.g.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lzn
 * JD-Core Version:    0.7.0.1
 */