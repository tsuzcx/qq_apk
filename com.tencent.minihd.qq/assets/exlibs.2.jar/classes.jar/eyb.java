import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;

public class eyb
  implements Runnable
{
  public eyb(RegisterQQNumberActivity paramRegisterQQNumberActivity) {}
  
  public void run()
  {
    ((PhoneContactManager)this.a.app.getManager(10)).f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eyb
 * JD-Core Version:    0.7.0.1
 */