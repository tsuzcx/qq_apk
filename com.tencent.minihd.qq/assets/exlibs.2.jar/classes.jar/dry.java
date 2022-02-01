import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.Contacts;

public class dry
  implements Animation.AnimationListener
{
  public dry(Contacts paramContacts) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.setAnimation(null);
    this.a.a.offsetTopAndBottom(0);
    this.a.a.requestLayout();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dry
 * JD-Core Version:    0.7.0.1
 */