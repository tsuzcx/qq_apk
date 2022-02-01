import android.database.Cursor;
import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;

public class hlw
  implements Runnable
{
  public hlw(MessageRoamManager paramMessageRoamManager, Pair paramPair, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    int i = -1;
    if (MessageRoamManager.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager))
    {
      i = MessageRoamManager.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager).a().a(MessageRoamManager.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager), 0, ((Long)this.jdField_a_of_type_AndroidUtilPair.first).longValue(), MessageRoamManager.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager)) - 1;
      MessageRoamManager.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager, false);
      MessageRoamManager.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager, null);
    }
    Handler localHandler = MessageRoamManager.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager).a(ChatHistoryForC2C.class);
    try
    {
      Cursor localCursor = MessageRoamManager.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager, this.jdField_a_of_type_JavaLangString, this.b, this.c);
      if (localCursor != null)
      {
        localMessage = localHandler.obtainMessage(18);
        localMessage.obj = localCursor;
        localMessage.arg1 = i;
        localHandler.sendMessage(localMessage);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = null;
        continue;
        Message localMessage = localHandler.obtainMessage(17);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hlw
 * JD-Core Version:    0.7.0.1
 */