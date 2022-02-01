import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.activity.contact.newfriend.RecommendListView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.RecommendContactMsg;
import com.tencent.mobileqq.model.FriendManager;
import java.util.ArrayList;

public class gik
  implements View.OnClickListener
{
  gik(RecommendListView paramRecommendListView) {}
  
  public void onClick(View paramView)
  {
    RecommendContactMsg localRecommendContactMsg = ((gim)paramView.getTag()).a;
    if ((localRecommendContactMsg.source != null) && (localRecommendContactMsg.source.length() > 0))
    {
      paramView = (FriendManager)this.a.a.getManager(8);
      if (paramView != null)
      {
        Friends localFriends = paramView.c(localRecommendContactMsg.uin);
        if ((localFriends != null) && (localFriends.isFriend()))
        {
          paramView = new ProfileActivity.AllInOne(localRecommendContactMsg.uin, 1);
          paramView.h = localFriends.name;
          paramView.i = localFriends.remark;
          paramView.l = localRecommendContactMsg.nickName;
          paramView.g = 66;
        }
      }
    }
    for (;;)
    {
      ProfileActivity.a((Activity)this.a.getContext(), paramView, 2);
      return;
      paramView = new ProfileActivity.AllInOne(localRecommendContactMsg.uin, 52);
      paramView.l = localRecommendContactMsg.nickName;
      paramView.g = 66;
      continue;
      paramView = new ProfileActivity.AllInOne(localRecommendContactMsg.uin, 52);
      paramView.l = localRecommendContactMsg.nickName;
      paramView.g = 66;
      continue;
      if (localRecommendContactMsg.groupId < 0) {
        break;
      }
      paramView = new ProfileActivity.AllInOne(localRecommendContactMsg.uin, 30);
      paramView.a = new ArrayList();
      paramView.h = localRecommendContactMsg.nickName;
      paramView.k = localRecommendContactMsg.contactName;
      paramView.a.add(new ProfileActivity.CardContactInfo(localRecommendContactMsg.contactName, localRecommendContactMsg.mobileCode, localRecommendContactMsg.nationCode));
      paramView.g = 67;
    }
    paramView = localRecommendContactMsg.mobileNo;
    if (localRecommendContactMsg.originBinder == 3L) {}
    for (int i = 51;; i = 50)
    {
      paramView = new ProfileActivity.AllInOne(paramView, i);
      paramView.h = localRecommendContactMsg.nickName;
      paramView.k = localRecommendContactMsg.contactName;
      paramView.a = new ArrayList();
      paramView.a.add(new ProfileActivity.CardContactInfo(localRecommendContactMsg.contactName, localRecommendContactMsg.mobileCode, localRecommendContactMsg.nationCode));
      paramView.g = 67;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gik
 * JD-Core Version:    0.7.0.1
 */