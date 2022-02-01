import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;

public class dog
  implements Animation.AnimationListener
{
  public dog(ChatHistoryForC2C paramChatHistoryForC2C, View paramView, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidViewView.requestLayout();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dog
 * JD-Core Version:    0.7.0.1
 */