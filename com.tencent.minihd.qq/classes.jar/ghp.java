import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.newfriend.BaseNewFriendView.INewFriendContext;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;

public class ghp
  implements View.OnClickListener
{
  public ghp(NewFriendActivity paramNewFriendActivity) {}
  
  public void onClick(View paramView)
  {
    switch (((Integer)paramView.getTag()).intValue())
    {
    default: 
      return;
    case 0: 
      if (!NewFriendActivity.c(this.a))
      {
        paramView = new ghq(this);
        this.a.app.a(paramView);
        return;
      }
      if (this.a.a == null) {
        this.a.a = ((CircleManager)this.a.app.getManager(34));
      }
      boolean bool;
      label132:
      QQAppInterface localQQAppInterface;
      if (NetworkUtil.e(this.a))
      {
        paramView = this.a.a;
        if (!this.a.c)
        {
          bool = true;
          paramView.a(bool, true);
          localQQAppInterface = this.a.app;
          if (!this.a.c) {
            break label231;
          }
        }
      }
      label231:
      for (paramView = "0";; paramView = "1")
      {
        ReportController.b(localQQAppInterface, "CliOper", "", "", "Network_circle", "Network_circle_setting", 59, 0, paramView, "", "", "");
        return;
        bool = false;
        break;
        if ((this.a.isFinishing()) || (NewFriendActivity.a(this.a) == null)) {
          break label132;
        }
        NewFriendActivity.a(this.a).a(this.a.getResources().getString(2131367328), 1);
        break label132;
      }
    }
    if (NewFriendActivity.a(this.a) != null) {
      NewFriendActivity.a(this.a).k();
    }
    paramView = new ghr(this);
    this.a.app.a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     ghp
 * JD-Core Version:    0.7.0.1
 */