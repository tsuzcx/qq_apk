import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.TroopMemberListActivity;

class fjb
  implements Runnable
{
  fjb(fja paramfja) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.e = false;
    this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.a.startAnimation(this.a.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getWindow().peekDecorView().getWindowToken(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fjb
 * JD-Core Version:    0.7.0.1
 */