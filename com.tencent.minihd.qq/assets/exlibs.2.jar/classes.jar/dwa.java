import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.DiscussionMemberActivity;

class dwa
  implements Runnable
{
  dwa(dvz paramdvz) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity.a.startAnimation(this.a.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.a.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity.getWindow().peekDecorView().getWindowToken(), 0);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity.removeObserver(this.a.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dwa
 * JD-Core Version:    0.7.0.1
 */