import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.qphone.base.util.QLog;

public class drx
  implements Animation.AnimationListener
{
  public drx(Contacts paramContacts, long paramLong) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContacts.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog.show();
      label10:
      this.jdField_a_of_type_ComTencentMobileqqActivityContacts.jdField_a_of_type_AndroidWidgetRelativeLayout.setAnimation(null);
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
 * Qualified Name:     drx
 * JD-Core Version:    0.7.0.1
 */