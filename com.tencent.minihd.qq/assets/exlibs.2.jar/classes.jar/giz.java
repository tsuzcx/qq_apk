import android.app.Dialog;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.contact.troop.BaseTroopView;

public class giz
  implements Animation.AnimationListener
{
  public giz(BaseTroopView paramBaseTroopView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.jdField_a_of_type_AndroidAppDialog.show();
    this.a.c.setAnimation(null);
    this.a.findViewById(2131300437).setVisibility(8);
    this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.a.b.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     giz
 * JD-Core Version:    0.7.0.1
 */