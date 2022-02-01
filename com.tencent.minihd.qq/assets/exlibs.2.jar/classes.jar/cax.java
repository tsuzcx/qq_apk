import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.PoiMapActivity;

public class cax
  implements Animation.AnimationListener
{
  public cax(PoiMapActivity paramPoiMapActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = (RelativeLayout.LayoutParams)this.a.d.getLayoutParams();
    paramAnimation.bottomMargin = (-this.a.p);
    this.a.d.setLayoutParams(paramAnimation);
    this.a.d.clearAnimation();
    this.a.a.setImageResource(2130839029);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cax
 * JD-Core Version:    0.7.0.1
 */