import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;

public class dme
  implements Runnable
{
  public dme(ChatHistory paramChatHistory) {}
  
  public void run()
  {
    if (!this.a.isFinishing())
    {
      MessageRecord localMessageRecord = new MessageRecord();
      localMessageRecord.shmsgseq = ChatHistory.a(this.a);
      this.a.a(this.a.app.a().a(this.a.d, this.a.a, localMessageRecord));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dme
 * JD-Core Version:    0.7.0.1
 */