import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.contact.troop.NotificationView;
import com.tencent.mobileqq.activity.contact.troop.RecommendTroopView;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RecentManagerFor3rdPart;
import com.tencent.mobileqq.app.RecommendTroopManagerImp;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.RecommendTroopMsg;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class gkb
  implements View.OnClickListener
{
  public gkb(TroopActivity paramTroopActivity) {}
  
  public void onClick(View paramView)
  {
    int k = ((Integer)paramView.getTag()).intValue();
    int i = 0;
    paramView = (RecommendTroopManagerImp)this.a.app.getManager(21);
    long l = 0L;
    int j = 0;
    switch (k)
    {
    default: 
      j = 0;
    case 0: 
      for (;;)
      {
        this.a.app.a().b(AppConstants.ap, 9000, -j);
        paramView = (RecentManagerFor3rdPart)this.a.app.getManager(32);
        if (i == 0) {
          break;
        }
        paramView.b(AppConstants.ap, 9000);
        paramView = this.a.app.a(Conversation.class);
        if (paramView != null) {
          paramView.sendMessage(paramView.obtainMessage(1009));
        }
        return;
        j = GroupSystemMsgController.a().a(this.a.app);
        Handler localHandler = this.a.app.a(NotificationView.class);
        if (localHandler != null) {
          localHandler.sendEmptyMessage(1014);
        }
        if (paramView != null) {}
        for (paramView = paramView.a();; paramView = null)
        {
          if ((paramView != null) && (paramView.size() != 0)) {
            break label218;
          }
          i = 1;
          break;
        }
        label218:
        l = ((RecommendTroopMsg)paramView.get(0)).timeStamp;
      }
    }
    i = j;
    if (paramView != null)
    {
      j = RecommendTroopManagerImp.a(this.a.app);
      paramView.b();
      paramView.a();
      paramView = this.a.app.a(RecommendTroopView.class);
      i = j;
      if (paramView != null)
      {
        paramView.sendEmptyMessage(105);
        i = j;
      }
    }
    j = i;
    paramView = this.a.app.a().a(AppConstants.ak, 0);
    if ((paramView == null) || (paramView.size() == 0)) {
      l = 0L;
    }
    for (i = 1;; i = 0)
    {
      ReportController.b(this.a.app, "CliOper", "", "", "Grp_recommend", "Grp_recom_empty", 0, 0, "", "", "", "");
      break;
      l = ((MessageForSystemMsg)paramView.get(paramView.size() - 1)).getSystemMsg().msg_time.get() * 1000L;
    }
    paramView.a(AppConstants.ap, 9000, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gkb
 * JD-Core Version:    0.7.0.1
 */