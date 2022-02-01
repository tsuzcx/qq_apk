import android.widget.Button;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid.GridCallBack;
import com.tencent.mobileqq.activity.activateFriend.BirthdayActivatePage;

public class fof
  implements ActivateFriendGrid.GridCallBack
{
  public fof(BirthdayActivatePage paramBirthdayActivatePage) {}
  
  public void a(int paramInt)
  {
    if (paramInt > 0)
    {
      this.a.a.setEnabled(true);
      return;
    }
    this.a.a.setEnabled(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fof
 * JD-Core Version:    0.7.0.1
 */