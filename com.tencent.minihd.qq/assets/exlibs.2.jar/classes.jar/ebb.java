import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.VipUtils;

public class ebb
  implements DialogInterface.OnClickListener
{
  public ebb(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.d == 1) {
      VipUtils.a(this.a, 1, ProfileCardUtil.a(3));
    }
    for (;;)
    {
      this.a.s();
      return;
      if (this.a.d == 2) {
        VipUtils.b(this.a, 1, ProfileCardUtil.a(6));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ebb
 * JD-Core Version:    0.7.0.1
 */