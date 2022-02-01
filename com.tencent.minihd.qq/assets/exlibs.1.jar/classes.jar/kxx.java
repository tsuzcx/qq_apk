import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.widget.ExpandableEntranceLayout;

public class kxx
  implements Animation.AnimationListener
{
  public kxx(ExpandableEntranceLayout paramExpandableEntranceLayout, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (ExpandableEntranceLayout.a(this.jdField_a_of_type_ComTencentMobileqqWidgetExpandableEntranceLayout))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    ExpandableEntranceLayout.a(this.jdField_a_of_type_ComTencentMobileqqWidgetExpandableEntranceLayout, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kxx
 * JD-Core Version:    0.7.0.1
 */