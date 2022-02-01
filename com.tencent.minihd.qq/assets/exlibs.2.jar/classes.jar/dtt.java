import android.content.Intent;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;

public class dtt
  extends HotChatObserver
{
  private dtt(Conversation paramConversation) {}
  
  protected void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, Boolean paramBoolean1)
  {
    this.a.g();
    this.a.app.c(Conversation.a(this.a));
    if (paramBoolean)
    {
      paramString3 = new Intent(this.a, ChatActivity.class);
      paramString3.putExtra("uin", paramString1);
      paramString3.putExtra("troop_uin", paramString2);
      paramString3.putExtra("uintype", 1);
      paramString3.putExtra("uinname", paramString4);
      paramString3.putExtra("hot_chat_from", 2);
      this.a.startActivity(paramString3);
      ReportController.b(this.a.app, "CliOper", "", "", "0X8004411", "0X8004411", 2, 0, "", "", "", "");
      return;
    }
    QQToast.a(this.a, paramString3, 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dtt
 * JD-Core Version:    0.7.0.1
 */