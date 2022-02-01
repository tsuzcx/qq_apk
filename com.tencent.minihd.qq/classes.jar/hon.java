import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.app.QQTabActivity;
import com.tencent.mobileqq.widget.QQTabHost;

public class hon
  extends AnimatorListenerAdapter
{
  public hon(QQTabActivity paramQQTabActivity, QQTabHost paramQQTabHost) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hon
 * JD-Core Version:    0.7.0.1
 */