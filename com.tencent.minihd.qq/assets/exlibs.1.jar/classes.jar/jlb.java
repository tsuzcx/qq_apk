import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.nearpeople.TurnBrandCardView;
import com.tencent.mobileqq.nearpeople.TurnBrandView;

public class jlb
  implements Animation.AnimationListener
{
  public jlb(TurnBrandView paramTurnBrandView, TurnBrandCardView paramTurnBrandCardView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearpeopleTurnBrandCardView.setVisibility(0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jlb
 * JD-Core Version:    0.7.0.1
 */