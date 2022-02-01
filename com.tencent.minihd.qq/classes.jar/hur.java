import android.os.Handler;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.utils.MessageRoamHandler;

public class hur
  extends MessageObserver
{
  public hur(MessageRoamHandler paramMessageRoamHandler) {}
  
  protected void a(boolean paramBoolean)
  {
    Handler localHandler = this.a.a.a(ChatHistoryForC2C.class);
    if (!paramBoolean)
    {
      localHandler.sendMessageDelayed(localHandler.obtainMessage(7), 0L);
      return;
    }
    localHandler.sendMessageDelayed(localHandler.obtainMessage(8), 0L);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, Object paramObject)
  {
    paramString = this.a.a.a(ChatHistoryForC2C.class);
    int j = 1;
    int i;
    if (!paramBoolean1)
    {
      if (paramBoolean2) {
        j = 2;
      }
      i = j;
      if (paramObject != null)
      {
        i = j;
        if ((paramObject instanceof String))
        {
          i = j;
          if ("CODE_51".equals((String)paramObject)) {
            i = 3;
          }
        }
      }
    }
    for (;;)
    {
      paramString.sendMessageDelayed(paramString.obtainMessage(i), 0L);
      return;
      MessageRoamManager localMessageRoamManager = (MessageRoamManager)this.a.a.getManager(86);
      if ((paramObject != null) && ((paramObject instanceof Long)) && (localMessageRoamManager.a(((Long)paramObject).longValue()))) {
        i = 0;
      } else {
        i = 4;
      }
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    Handler localHandler = this.a.a.a(ChatHistoryForC2C.class);
    if (!paramBoolean)
    {
      localHandler.sendMessageDelayed(localHandler.obtainMessage(6), 0L);
      return;
    }
    localHandler.sendMessageDelayed(localHandler.obtainMessage(5), 0L);
  }
  
  protected void j(boolean paramBoolean)
  {
    Handler localHandler = this.a.a.a(ChatHistoryForC2C.class);
    if (!paramBoolean)
    {
      localHandler.sendMessageDelayed(localHandler.obtainMessage(1), 0L);
      return;
    }
    this.a.a.a().c();
    localHandler.sendMessageDelayed(localHandler.obtainMessage(0), 0L);
  }
  
  protected void k(boolean paramBoolean)
  {
    Handler localHandler = this.a.a.a(ChatHistoryForC2C.class);
    if (!paramBoolean)
    {
      localHandler.sendMessageDelayed(localHandler.obtainMessage(1), 0L);
      return;
    }
    this.a.a.a().c();
    localHandler.sendMessageDelayed(localHandler.obtainMessage(0), 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hur
 * JD-Core Version:    0.7.0.1
 */