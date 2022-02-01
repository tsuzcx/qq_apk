import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;

public class hnj
  implements Runnable
{
  public hnj(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    PhoneContactManager localPhoneContactManager = (PhoneContactManager)this.a.getManager(10);
    if (localPhoneContactManager != null) {
      localPhoneContactManager.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hnj
 * JD-Core Version:    0.7.0.1
 */