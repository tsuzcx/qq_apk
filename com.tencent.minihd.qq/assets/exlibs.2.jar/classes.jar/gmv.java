import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.mobileqq.activity.flaotaio.RootCallBack;
import com.tencent.mobileqq.activity.flaotaio.SlipFrameLayout;

public class gmv
  extends AnimatorListenerAdapter
{
  public gmv(SlipFrameLayout paramSlipFrameLayout, View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (SlipFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioSlipFrameLayout) != null) {
      SlipFrameLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioSlipFrameLayout).b(this.jdField_a_of_type_AndroidViewView);
    }
    this.jdField_a_of_type_AndroidViewView.setLayerType(0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gmv
 * JD-Core Version:    0.7.0.1
 */