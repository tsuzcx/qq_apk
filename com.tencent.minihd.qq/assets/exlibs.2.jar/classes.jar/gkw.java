import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.tencent.mobileqq.activity.flaotaio.BaseFloatChatPie;

public class gkw
  extends BroadcastReceiver
{
  public gkw(BaseFloatChatPie paramBaseFloatChatPie) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.SCREEN_OFF"))
    {
      this.a.a.removeMessages(248);
      this.a.a.sendEmptyMessageDelayed(248, 10000L);
    }
    do
    {
      return;
      if (paramContext.equals("android.intent.action.SCREEN_ON"))
      {
        this.a.a.removeMessages(248);
        return;
      }
      if (paramContext.equals("hongbao_money_get"))
      {
        BaseFloatChatPie.a(this.a, paramIntent);
        return;
      }
    } while (!"action_for_item_click".equals(paramContext));
    this.a.g();
    BaseFloatChatPie.a(this.a, paramIntent.getStringExtra("hongbao_sender_uin"));
    BaseFloatChatPie.b(this.a, paramIntent.getStringExtra("wish_word"));
    BaseFloatChatPie.a(this.a, paramIntent.getLongExtra("msg_uni_seq", -1L));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gkw
 * JD-Core Version:    0.7.0.1
 */