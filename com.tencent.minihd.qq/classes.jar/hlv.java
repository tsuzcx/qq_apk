import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;

public class hlv
  extends Handler
{
  public hlv(MessageHandler paramMessageHandler, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      paramMessage = paramMessage.getData();
    } while ((paramMessage == null) || (!paramMessage.containsKey("update_unread_uin")) || (!paramMessage.containsKey("update_unread_time")));
    this.a.a.a().a(paramMessage.getString("update_unread_uin"), paramMessage.getInt("update_unread_type", 0), paramMessage.getLong("update_unread_time"));
    MessageHandler.a(this.a, 2002, true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hlv
 * JD-Core Version:    0.7.0.1
 */