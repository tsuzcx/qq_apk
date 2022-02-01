import android.app.Dialog;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.qphone.base.util.QLog;

public class flq
  implements Animation.AnimationListener
{
  public flq(UncommonlyUsedContactsActivity paramUncommonlyUsedContactsActivity, long paramLong) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.jdField_a_of_type_AndroidAppDialog.show();
      label10:
      this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.jdField_a_of_type_AndroidWidgetRelativeLayout.setAnimation(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.jdField_a_of_type_AndroidViewView.setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.d("Q.PerfTrace", 2, "contactTab search up anim time: " + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
      }
      ThreadPriorityManager.a(false);
      return;
    }
    catch (Exception paramAnimation)
    {
      break label10;
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     flq
 * JD-Core Version:    0.7.0.1
 */