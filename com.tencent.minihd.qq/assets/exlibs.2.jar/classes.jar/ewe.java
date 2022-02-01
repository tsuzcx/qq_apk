import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.activity.RecommendedGatherListActivity;
import com.tencent.mobileqq.fpsreport.FPSPinnedHeaderExpandableListView;

public class ewe
  implements Animation.AnimationListener
{
  public ewe(RecommendedGatherListActivity paramRecommendedGatherListActivity, boolean paramBoolean, float paramFloat) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      paramAnimation = (FrameLayout.LayoutParams)RecommendedGatherListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecommendedGatherListActivity).getLayoutParams();
      paramAnimation.bottomMargin = ((int)this.jdField_a_of_type_Float);
      RecommendedGatherListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecommendedGatherListActivity).setLayoutParams(paramAnimation);
      RecommendedGatherListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecommendedGatherListActivity).requestLayout();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ewe
 * JD-Core Version:    0.7.0.1
 */