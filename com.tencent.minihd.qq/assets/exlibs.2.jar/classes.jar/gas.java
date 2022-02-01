import android.os.Handler;
import android.os.Message;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import java.util.List;

public class gas
  extends Handler
{
  public gas(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing());
        try
        {
          PublicAccountChatPie.a(this.a);
          return;
        }
        catch (Exception paramMessage)
        {
          paramMessage.printStackTrace();
          return;
        }
        paramMessage = PublicAccountChatPie.a(this.a).a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.a());
        PublicAccountChatPie.a(this.a, paramMessage);
      } while ((paramMessage == null) || (paramMessage.isEmpty()));
      this.a.f(true);
      return;
      PublicAccountChatPie.b(this.a);
      PublicAccountChatPie.c(this.a);
    } while (this.a.cf == 1);
    PublicAccountChatPie.a(this.a, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gas
 * JD-Core Version:    0.7.0.1
 */