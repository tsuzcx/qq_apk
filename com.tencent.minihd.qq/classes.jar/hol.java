import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.mobileqq.app.QQTabActivity;
import com.tencent.mobileqq.widget.QQTabHost;

public class hol
  extends AnimatorListenerAdapter
{
  public hol(QQTabActivity paramQQTabActivity, QQTabHost paramQQTabHost, View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQTabHost.a = false;
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.post(new hom(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hol
 * JD-Core Version:    0.7.0.1
 */