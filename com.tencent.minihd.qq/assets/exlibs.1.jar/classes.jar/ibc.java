import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.mobileqq.dating.DatingDetailAdapter;
import com.tencent.widget.AbsListView.LayoutParams;

public class ibc
  implements Animator.AnimatorListener
{
  public ibc(DatingDetailAdapter paramDatingDetailAdapter, View paramView, AbsListView.LayoutParams paramLayoutParams) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidViewView.setAlpha(1.0F);
    this.jdField_a_of_type_ComTencentWidgetAbsListView$LayoutParams.height = -2;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(this.jdField_a_of_type_ComTencentWidgetAbsListView$LayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailAdapter.a();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ibc
 * JD-Core Version:    0.7.0.1
 */