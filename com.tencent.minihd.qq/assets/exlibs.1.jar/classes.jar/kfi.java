import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.troop.activity.TroopAdminList;
import com.tencent.mobileqq.troop.activity.TroopAdminList.ViewHolder;

public class kfi
  implements View.OnClickListener
{
  public kfi(TroopAdminList paramTroopAdminList) {}
  
  public void onClick(View paramView)
  {
    paramView = (TroopAdminList.ViewHolder)paramView.getTag();
    if (paramView != null)
    {
      paramView = paramView.b;
      if (!this.a.app.a().equals(paramView)) {
        break label53;
      }
      paramView = new ProfileActivity.AllInOne(paramView, 0);
    }
    for (;;)
    {
      ProfileActivity.b(this.a, paramView);
      return;
      label53:
      Friends localFriends = ((FriendManager)this.a.app.getManager(8)).c(paramView);
      if ((localFriends != null) && (localFriends.isFriend()))
      {
        paramView = new ProfileActivity.AllInOne(paramView, 1);
        paramView.h = localFriends.name;
        paramView.i = localFriends.remark;
      }
      else
      {
        paramView = new ProfileActivity.AllInOne(paramView, 19);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kfi
 * JD-Core Version:    0.7.0.1
 */