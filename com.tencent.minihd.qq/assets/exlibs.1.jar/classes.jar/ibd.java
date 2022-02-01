import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.mobileqq.dating.DatingDetailAdapter;
import com.tencent.widget.AbsListView.LayoutParams;

public class ibd
  implements Animator.AnimatorListener
{
  public ibd(DatingDetailAdapter paramDatingDetailAdapter, AbsListView.LayoutParams paramLayoutParams, View paramView, boolean paramBoolean, int paramInt) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView$LayoutParams.height = -2;
    this.jdField_a_of_type_AndroidViewView.setAlpha(1.0F);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(this.jdField_a_of_type_ComTencentWidgetAbsListView$LayoutParams);
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailAdapter.c(this.jdField_a_of_type_Int);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ibd
 * JD-Core Version:    0.7.0.1
 */