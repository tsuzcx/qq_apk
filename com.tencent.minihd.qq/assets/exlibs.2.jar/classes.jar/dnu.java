import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;

public class dnu
  implements Runnable
{
  public dnu(ChatHistoryForC2C paramChatHistoryForC2C) {}
  
  public void run()
  {
    if (!this.a.isFinishing())
    {
      MessageRecord localMessageRecord = new MessageRecord();
      localMessageRecord.shmsgseq = ChatHistoryForC2C.a(this.a);
      this.a.a(this.a.app.a().a(this.a.c, this.a.a, localMessageRecord));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dnu
 * JD-Core Version:    0.7.0.1
 */