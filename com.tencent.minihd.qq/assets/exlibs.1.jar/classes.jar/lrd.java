import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.widget.ActionSheet;

class lrd
  implements Animation.AnimationListener
{
  lrd(lrc paramlrc) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.a();
    ActionSheet.a(this.a.a, true);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lrd
 * JD-Core Version:    0.7.0.1
 */