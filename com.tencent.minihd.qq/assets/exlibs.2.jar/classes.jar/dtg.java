import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.Conversation;

public class dtg
  implements ValueAnimator.AnimatorUpdateListener
{
  public dtg(Conversation paramConversation) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.a.getParent().findViewById(2131297977).scrollTo(i, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dtg
 * JD-Core Version:    0.7.0.1
 */