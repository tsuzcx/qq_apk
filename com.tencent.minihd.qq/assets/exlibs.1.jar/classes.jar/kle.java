import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic;
import com.tencent.mobileqq.troop.widget.TroopAioFeedsCenterView;

public class kle
  implements Animation.AnimationListener
{
  public kle(TroopFeedsCenterLogic paramTroopFeedsCenterLogic) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.f = false;
    if (this.a.jdField_b_of_type_AndroidViewAnimationTranslateAnimation == paramAnimation)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView.setVisibility(4);
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView.clearAnimation();
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.d = false;
      }
      if (this.a.jdField_b_of_type_Boolean)
      {
        this.a.c(true);
        this.a.jdField_b_of_type_Boolean = false;
      }
      if (this.a.jdField_b_of_type_AndroidWidgetImageView != null)
      {
        if (!this.a.g) {
          break label130;
        }
        this.a.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839442);
      }
    }
    label130:
    do
    {
      do
      {
        return;
        this.a.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839426);
        return;
      } while (this.a.jdField_a_of_type_AndroidViewAnimationTranslateAnimation != paramAnimation);
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView.setVisibility(0);
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView.clearAnimation();
        if (this.a.c)
        {
          this.a.c = false;
          this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAioFeedsCenterView.a(true);
        }
      }
    } while (this.a.jdField_b_of_type_AndroidWidgetImageView == null);
    if (this.a.g)
    {
      this.a.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839443);
      return;
    }
    this.a.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839427);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.f = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kle
 * JD-Core Version:    0.7.0.1
 */