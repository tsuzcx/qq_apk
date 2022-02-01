import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.widget.WidgetContainer;
import com.tencent.mobileqq.customviews.CircleMenuManager;

public class dth
  implements Animator.AnimatorListener
{
  public dth(Conversation paramConversation) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.findViewById(2131297306).setVisibility(0);
    Conversation.a(this.a).j();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    CircleMenuManager.a(241, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dth
 * JD-Core Version:    0.7.0.1
 */