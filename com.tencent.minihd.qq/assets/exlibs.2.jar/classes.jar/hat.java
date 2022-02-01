import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity.ViewHolder;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity.ViewHolderLayoutParams;
import com.tencent.widget.XListView;

public class hat
  implements Animation.AnimationListener
{
  public hat(SpecailCareListActivity paramSpecailCareListActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    SpecailCareListActivity.a(this.a).clearAnimation();
    this.a.jdField_a_of_type_AndroidWidgetLinearLayout.clearAnimation();
    SpecailCareListActivity.b(this.a).setVisibility(4);
    SpecailCareListActivity.c(this.a).setClickable(true);
    SpecailCareListActivity.d(this.a).setText("完成");
    SpecailCareListActivity.e(this.a).setContentDescription("完成 按钮");
    this.a.c = true;
    paramAnimation = this.a.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(0).getTag();
    if ((paramAnimation != null) && ((paramAnimation instanceof SpecailCareListActivity.ViewHolder)))
    {
      paramAnimation = (SpecailCareListActivity.ViewHolder)paramAnimation;
      if (this.a.b == null)
      {
        this.a.b = new SpecailCareListActivity.ViewHolderLayoutParams();
        this.a.b.a = ((RelativeLayout.LayoutParams)paramAnimation.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams());
        this.a.b.b = ((RelativeLayout.LayoutParams)paramAnimation.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams());
        this.a.b.c = ((RelativeLayout.LayoutParams)paramAnimation.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams());
        this.a.b.d = ((RelativeLayout.LayoutParams)paramAnimation.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams());
        this.a.b.e = ((RelativeLayout.LayoutParams)paramAnimation.b.getLayoutParams());
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hat
 * JD-Core Version:    0.7.0.1
 */