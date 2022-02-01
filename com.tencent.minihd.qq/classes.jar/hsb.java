import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.UpdateFriend;
import com.tencent.qphone.base.util.QLog;

public class hsb
  extends FriendListObserver
{
  private hsb(UpdateFriend paramUpdateFriend) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((UpdateFriend.a(this.a) == 7) || (UpdateFriend.b(this.a) == 3))
    {
      if (paramBoolean1) {
        break label37;
      }
      this.a.a(6);
    }
    label37:
    while ((!paramBoolean1) || (!paramBoolean2)) {
      return;
    }
    UpdateFriend.a(this.a).a.edit().putBoolean("isFriendlistok", true).commit();
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "onUpdateFriendList put PREF_ISFRIENDLIST_OK true");
    }
    UpdateFriend.b(this.a).a(3, true, Integer.valueOf(1));
    this.a.a(7);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (UpdateFriend.c(this.a) == 8)
    {
      if (paramBoolean1) {
        break label26;
      }
      this.a.a(6);
    }
    label26:
    while (!paramBoolean2) {
      return;
    }
    this.a.a(7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hsb
 * JD-Core Version:    0.7.0.1
 */