import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;

public final class ihs
  implements Runnable
{
  public ihs(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    FriendSystemMsgController.a().c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ihs
 * JD-Core Version:    0.7.0.1
 */