import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.LebaListMgrActivity;
import com.tencent.mobileqq.adapter.LebaListMgrAdapter.ViewHolder;

public class egt
  implements Animation.AnimationListener
{
  public egt(LebaListMgrActivity paramLebaListMgrActivity, LebaListMgrAdapter.ViewHolder paramViewHolder) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter$ViewHolder.b.setVisibility(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     egt
 * JD-Core Version:    0.7.0.1
 */