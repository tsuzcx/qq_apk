import android.database.Cursor;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter;

public class dnb
  implements Runnable
{
  public dnb(ChatHistory.ChatHistoryAdapter paramChatHistoryAdapter, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    try
    {
      Cursor localCursor = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.a(this.jdField_a_of_type_JavaLangString, this.b, this.c);
      Message localMessage = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.a.obtainMessage(8);
      localMessage.obj = localCursor;
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.a.sendMessage(localMessage);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dnb
 * JD-Core Version:    0.7.0.1
 */