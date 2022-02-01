import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class kyy
  implements Animation.AnimationListener
{
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_Kyx.a.getBackground();
  
  kyy(kyx paramkyx) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_Kyx.a.clearAnimation();
    this.jdField_a_of_type_Kyx.a.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.jdField_a_of_type_Kyx.a.setBackgroundResource(17170443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kyy
 * JD-Core Version:    0.7.0.1
 */