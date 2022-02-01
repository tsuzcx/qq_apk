import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.dating.DismissAnimationAdapter;

public class idd
  implements Animator.AnimatorListener
{
  public idd(DismissAnimationAdapter paramDismissAnimationAdapter, ViewGroup.LayoutParams paramLayoutParams, int paramInt1, View paramView, boolean paramBoolean, int paramInt2) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.height = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidViewView.setAlpha(1.0F);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqDatingDismissAnimationAdapter.c(this.b);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     idd
 * JD-Core Version:    0.7.0.1
 */