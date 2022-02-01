import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.LebaListMgrActivity;
import com.tencent.mobileqq.adapter.LebaListMgrAdapter.ViewHolder;

public class egu
  implements Animation.AnimationListener
{
  public egu(LebaListMgrActivity paramLebaListMgrActivity, LebaListMgrAdapter.ViewHolder paramViewHolder) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = new RelativeLayout.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter$ViewHolder.a.getLayoutParams());
    paramAnimation.addRule(15);
    paramAnimation.setMargins((int)(32.0F * LebaListMgrActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityLebaListMgrActivity)), 0, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter$ViewHolder.a.setLayoutParams(paramAnimation);
    this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter$ViewHolder.a.clearAnimation();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     egu
 * JD-Core Version:    0.7.0.1
 */