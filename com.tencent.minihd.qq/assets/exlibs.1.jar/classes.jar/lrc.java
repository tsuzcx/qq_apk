import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import com.tencent.widget.ActionSheet;

public class lrc
  implements Runnable
{
  public lrc(ActionSheet paramActionSheet) {}
  
  public void run()
  {
    if (ActionSheet.b(this.a) == null)
    {
      ActionSheet.b(this.a, new TranslateAnimation(0.0F, 0.0F, 0.0F, ActionSheet.a(this.a).getHeight()));
      ActionSheet.b(this.a).setInterpolator(AnimationUtils.loadInterpolator(ActionSheet.a(this.a), 17432582));
      ActionSheet.b(this.a).setDuration(200L);
      ActionSheet.b(this.a).setFillAfter(true);
    }
    ActionSheet.b(this.a).setAnimationListener(new lrd(this));
    ActionSheet.a(this.a).startAnimation(ActionSheet.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lrc
 * JD-Core Version:    0.7.0.1
 */