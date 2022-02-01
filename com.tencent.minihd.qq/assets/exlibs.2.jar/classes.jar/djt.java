import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;

public class djt
  implements Runnable
{
  public djt(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    ((FriendsManagerImp)this.a.a.getManager(8)).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     djt
 * JD-Core Version:    0.7.0.1
 */