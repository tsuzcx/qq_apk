import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.facetoface.Face2FaceFriendBubbleView;

public class ije
  implements Animation.AnimationListener
{
  public static final int a = 0;
  public static final int b = 1;
  private View jdField_a_of_type_AndroidViewView = null;
  private int c = 0;
  
  public ije(Face2FaceFriendBubbleView paramFace2FaceFriendBubbleView, int paramInt, View paramView)
  {
    this.c = paramInt;
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    do
    {
      return;
      if (this.c == 0)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        return;
      }
    } while (this.c != 1);
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ije
 * JD-Core Version:    0.7.0.1
 */