import android.os.Handler;
import android.widget.EditText;
import com.tencent.mobileqq.activity.activateFriend.SendBirthdayWishesActivity;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsObserver;
import com.tencent.widget.XPanelContainer;

public class fok
  extends ActivateFriendsObserver
{
  public fok(SendBirthdayWishesActivity paramSendBirthdayWishesActivity) {}
  
  public void a(int paramInt)
  {
    this.a.f();
    SendBirthdayWishesActivity.a(this.a, paramInt);
    this.a.jdField_a_of_type_AndroidWidgetEditText.removeTextChangedListener(this.a);
    this.a.jdField_a_of_type_AndroidWidgetEditText.setText("");
    if (this.a.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0) {
      this.a.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    }
    if (paramInt != 2)
    {
      SendBirthdayWishesActivity.a(this.a).removeCallbacks(SendBirthdayWishesActivity.a(this.a));
      SendBirthdayWishesActivity.a(this.a).postDelayed(SendBirthdayWishesActivity.a(this.a), 600L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fok
 * JD-Core Version:    0.7.0.1
 */