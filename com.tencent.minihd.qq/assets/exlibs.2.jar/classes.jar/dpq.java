import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.widget.XListView;

public class dpq
  implements Runnable
{
  public dpq(ChatSettingForTroop paramChatSettingForTroop, int paramInt) {}
  
  public void run()
  {
    View localView = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ArrayOfAndroidViewView[this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.az];
    if ((localView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentWidgetXListView != null))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.getResources().getDisplayMetrics();
      int[] arrayOfInt = new int[2];
      localView.getLocationOnScreen(arrayOfInt);
      if (arrayOfInt[1] + localView.getMeasuredHeight() >= ((DisplayMetrics)localObject).heightPixels)
      {
        localView.getBottom();
        this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentWidgetXListView.d(this.jdField_a_of_type_Int);
      }
      localObject = new AlphaAnimation(0.1F, 1.0F);
      ((AlphaAnimation)localObject).setDuration(1500L);
      localView.startAnimation((Animation)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dpq
 * JD-Core Version:    0.7.0.1
 */