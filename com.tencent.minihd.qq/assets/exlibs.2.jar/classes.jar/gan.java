import android.content.res.Resources;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.activity.aio.tips.GatherContactsTips;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

public class gan
  extends FriendListObserver
{
  public gan(FriendChatPie paramFriendChatPie) {}
  
  protected void a(boolean paramBoolean, List paramList)
  {
    if ((paramBoolean) && (FriendChatPie.a(this.a) != null))
    {
      if ((FriendChatPie.a(this.a).a()) && (!FriendChatPie.a(this.a).b()))
      {
        FriendChatPie.a(this.a).b(1);
        FriendChatPie.a(this.a).a(2);
      }
      return;
    }
    QQToast.a(this.a.a, this.a.a.getResources().getString(2131369868), 0).b(this.a.a.getTitleBarHeight());
  }
  
  protected void b(boolean paramBoolean, List paramList)
  {
    if ((paramBoolean) && (FriendChatPie.a(this.a) != null)) {
      FriendChatPie.a(this.a).b(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gan
 * JD-Core Version:    0.7.0.1
 */