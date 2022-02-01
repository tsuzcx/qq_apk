import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import com.dataline.activities.LiteActivity;

public class bd
  implements Animator.AnimatorListener
{
  public bd(LiteActivity paramLiteActivity, boolean paramBoolean, View paramView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity).setImageResource(2130837585);
      LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity).requestFocus();
      LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.setTranslationY(0.0F);
      LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, false);
      return;
      LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity).setVisibility(8);
      LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity).setImageResource(2130837573);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity, true);
    if (this.jdField_a_of_type_Boolean)
    {
      LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity).setVisibility(0);
      LiteActivity.a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bd
 * JD-Core Version:    0.7.0.1
 */