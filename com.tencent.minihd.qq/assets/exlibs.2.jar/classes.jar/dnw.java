import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;

class dnw
  implements Runnable
{
  dnw(dnv paramdnv) {}
  
  public void run()
  {
    if (ChatHistoryForC2C.a(this.a.a))
    {
      ChatHistoryForC2C.a(this.a.a, false);
      ((MessageRoamManager)this.a.a.app.getManager(86)).f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dnw
 * JD-Core Version:    0.7.0.1
 */