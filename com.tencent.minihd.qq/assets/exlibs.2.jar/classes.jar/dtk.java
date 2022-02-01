import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.customviews.CircleMenuManager;

public class dtk
  implements Animator.AnimatorListener
{
  public dtk(Conversation paramConversation) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.a(false, null);
    this.a.findViewById(2131297306).setVisibility(8);
    CircleMenuManager.b(241, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dtk
 * JD-Core Version:    0.7.0.1
 */