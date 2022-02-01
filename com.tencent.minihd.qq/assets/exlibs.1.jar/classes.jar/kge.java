import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.troop.activity.ExtendGridView;
import com.tencent.mobileqq.troop.activity.TroopBarImagePreviewAdapter;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import java.util.ArrayList;

public class kge
  implements Animation.AnimationListener
{
  public kge(TroopBarPublishActivity paramTroopBarPublishActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    boolean bool = false;
    paramAnimation = this.a;
    paramAnimation.ac -= 1;
    if (this.a.ac == 0)
    {
      this.a.n = false;
      int i = 0;
      while (i < this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.getCount())
      {
        paramAnimation = this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityExtendGridView.getChildAt(i);
        if (paramAnimation != null) {
          paramAnimation.clearAnimation();
        }
        i += 1;
      }
      this.a.c.clearAnimation();
      this.a.b.remove(this.a.ad);
      paramAnimation = this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter;
      if (this.a.b.size() < this.a.ae) {
        bool = true;
      }
      paramAnimation.a(bool, true);
      this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarImagePreviewAdapter.a(this.a.b);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kge
 * JD-Core Version:    0.7.0.1
 */