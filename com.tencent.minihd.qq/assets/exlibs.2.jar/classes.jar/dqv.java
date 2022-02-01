import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.ChatSettingForTroop;

public class dqv
  implements Runnable
{
  public dqv(ChatSettingForTroop paramChatSettingForTroop, View paramView) {}
  
  public void run()
  {
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131297595);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, -this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.ay, 0.0F, 0.0F);
    localTranslateAnimation.setDuration(800L);
    localTranslateAnimation.setInterpolator(new DecelerateInterpolator());
    localTranslateAnimation.setAnimationListener(new dqw(this, localLinearLayout));
    localLinearLayout.startAnimation(localTranslateAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dqv
 * JD-Core Version:    0.7.0.1
 */