import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleNewAIOAnim;
import com.tencent.mobileqq.vas.AvatarPendantManager;

public class hux
  extends AnimatorListenerAdapter
{
  public hux(BubbleNewAIOAnim paramBubbleNewAIOAnim) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.a("animator set end!");
    if (this.a.c != null)
    {
      BubbleNewAIOAnim.a(this.a).removeView(this.a.c);
      this.a.c = null;
      if (this.a.d == null) {
        break label178;
      }
      BubbleNewAIOAnim.b(this.a).removeView(this.a.d);
      this.a.d = null;
    }
    for (;;)
    {
      if (this.a.e != null)
      {
        this.a.e.setVisibility(0);
        paramAnimator = (AvatarPendantManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(45);
        paramAnimator.a = -1L;
        paramAnimator.b();
      }
      if (this.a.jdField_b_of_type_AndroidViewView != null) {
        this.a.jdField_b_of_type_AndroidViewView.invalidate();
      }
      this.a.jdField_a_of_type_JavaLangString = "";
      this.a.jdField_b_of_type_JavaLangString = "";
      return;
      this.a.a("something wrong, bubble view is null!");
      break;
      label178:
      this.a.a("something wrong, pendview is null!");
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.a("animator set start!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     hux
 * JD-Core Version:    0.7.0.1
 */