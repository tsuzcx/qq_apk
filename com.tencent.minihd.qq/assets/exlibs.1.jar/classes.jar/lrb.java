import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import com.tencent.widget.ActionSheet;

public class lrb
  implements Runnable
{
  public lrb(ActionSheet paramActionSheet) {}
  
  public void run()
  {
    if (ActionSheet.a(this.a) == null)
    {
      ActionSheet.a(this.a, new TranslateAnimation(0.0F, 0.0F, ActionSheet.a(this.a).getHeight(), 0.0F));
      ActionSheet.a(this.a).setFillEnabled(true);
    }
    try
    {
      ActionSheet.a(this.a).setInterpolator(AnimationUtils.loadInterpolator(ActionSheet.a(this.a), 17432582));
      label72:
      ActionSheet.a(this.a).setDuration(ActionSheet.a(this.a));
      ActionSheet.a(this.a, true);
      ActionSheet.a(this.a).startAnimation(ActionSheet.a(this.a));
      return;
    }
    catch (NoSuchFieldError localNoSuchFieldError)
    {
      break label72;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lrb
 * JD-Core Version:    0.7.0.1
 */