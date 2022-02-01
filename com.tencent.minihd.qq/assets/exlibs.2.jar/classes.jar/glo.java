import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.flaotaio.BaseFloatChatPie;
import com.tencent.mobileqq.activity.flaotaio.FloatAioPage;
import com.tencent.widget.XListView;

public class glo
  extends AnimatorListenerAdapter
{
  public glo(FloatAioPage paramFloatAioPage, View paramView1, View paramView2, View paramView3, View paramView4, View paramView5, TextView paramTextView, XListView paramXListView, View paramView6, View paramView7, ImageView paramImageView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = this.c.getLayoutParams();
    paramAnimator.height = -1;
    this.c.setLayoutParams(paramAnimator);
    this.d.setVisibility(0);
    this.e.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    paramAnimator = ObjectAnimator.ofFloat(this.d, "alpha", new float[] { 0.0F, 1.0F });
    paramAnimator.setDuration(150L);
    paramAnimator.start();
    this.jdField_a_of_type_ComTencentWidgetXListView.postDelayed(new glp(this), 1500L);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage.a.a = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage.a.b = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatAioPage.a.a(true);
    paramAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    paramAnimator.setDuration(100L);
    paramAnimator.addUpdateListener(new glq(this));
    paramAnimator.addListener(new glr(this));
    paramAnimator.start();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setAlpha(0.0F);
    this.b.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     glo
 * JD-Core Version:    0.7.0.1
 */