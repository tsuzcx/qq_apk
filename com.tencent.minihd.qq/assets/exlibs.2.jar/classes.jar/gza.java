import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;

public class gza
  implements Animation.AnimationListener
{
  public gza(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    ShortVideoPlayActivity.a(this.a, true);
    ShortVideoPlayActivity.a(this.a).setVisibility(4);
    ShortVideoPlayActivity.b(this.a).setVisibility(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gza
 * JD-Core Version:    0.7.0.1
 */