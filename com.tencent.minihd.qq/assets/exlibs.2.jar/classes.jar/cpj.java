import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.biz.webviewplugin.Ad;

public class cpj
  implements Animation.AnimationListener
{
  public cpj(Ad paramAd) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838991);
    this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cpj
 * JD-Core Version:    0.7.0.1
 */