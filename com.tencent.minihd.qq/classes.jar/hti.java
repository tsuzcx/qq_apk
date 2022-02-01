import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ProfileCardMessageProcessor;

public class hti
  implements Runnable
{
  public hti(ProfileCardMessageProcessor paramProfileCardMessageProcessor) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.a.a.getAccount())) {
      ((FriendListHandler)this.a.a.a(1)).b(this.a.a.getAccount());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hti
 * JD-Core Version:    0.7.0.1
 */