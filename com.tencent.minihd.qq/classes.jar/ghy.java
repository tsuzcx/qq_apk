import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;

public class ghy
  implements View.OnClickListener
{
  public ghy(NewFriendActivity paramNewFriendActivity, SharedPreferences paramSharedPreferences) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("newfriend_enter_time", System.currentTimeMillis()).commit();
    NewFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendActivity, false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     ghy
 * JD-Core Version:    0.7.0.1
 */