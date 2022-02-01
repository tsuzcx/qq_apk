import android.content.res.Resources;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.FriendProfileImageActivity;

public class ebw
  implements Runnable
{
  public ebw(FriendProfileImageActivity paramFriendProfileImageActivity) {}
  
  public void run()
  {
    this.a.d = false;
    if (!this.a.jdField_c_of_type_Boolean) {
      this.a.b.setVisibility(0);
    }
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, this.a.getResources().getDimension(2131493189), 0.0F);
    localTranslateAnimation.setDuration(300L);
    localTranslateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
    this.a.jdField_c_of_type_AndroidWidgetRelativeLayout.startAnimation(localTranslateAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ebw
 * JD-Core Version:    0.7.0.1
 */