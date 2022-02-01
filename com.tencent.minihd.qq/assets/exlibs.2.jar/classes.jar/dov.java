import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import java.util.List;

public class dov
  extends ShieldListObserver
{
  public dov(ChatSettingActivity paramChatSettingActivity) {}
  
  protected void a(boolean paramBoolean, List paramList)
  {
    if (!ChatSettingActivity.c(this.a)) {}
    do
    {
      return;
      ChatSettingActivity.c(this.a, false);
      ChatSettingActivity.e(this.a);
    } while (!paramBoolean);
    paramList = (ShieldMsgManger)this.a.app.getManager(15);
    if ((paramList != null) && (!TextUtils.isEmpty(ChatSettingActivity.d(this.a)))) {
      ChatSettingActivity.b(this.a, paramList.a(ChatSettingActivity.d(this.a)));
    }
    ChatSettingActivity.c(this.a);
  }
  
  protected void b(boolean paramBoolean, List paramList)
  {
    if (!ChatSettingActivity.c(this.a)) {
      return;
    }
    ChatSettingActivity.c(this.a, false);
    ChatSettingActivity.e(this.a);
    if (paramBoolean)
    {
      paramList = (ShieldMsgManger)this.a.app.getManager(15);
      if ((paramList != null) && (!TextUtils.isEmpty(ChatSettingActivity.d(this.a)))) {
        ChatSettingActivity.b(this.a, paramList.a(ChatSettingActivity.d(this.a)));
      }
      ChatSettingActivity.c(this.a);
      return;
    }
    ChatSettingActivity.a(this.a, 2131367041, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dov
 * JD-Core Version:    0.7.0.1
 */