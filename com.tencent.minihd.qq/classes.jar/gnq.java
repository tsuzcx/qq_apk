import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.MsgTabUnreadListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BadgeUtils;

public class gnq
  implements MsgTabUnreadListener
{
  public gnq(MainAssistObserver paramMainAssistObserver) {}
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("SplashActivity", 4, "msg fresh callback...");
    }
    if ((this.a.a == null) || (this.a.a.app == null)) {}
    QQAppInterface localQQAppInterface;
    QQMessageFacade localQQMessageFacade;
    do
    {
      return;
      localQQAppInterface = this.a.a.app;
      localQQMessageFacade = localQQAppInterface.a();
    } while (localQQMessageFacade == null);
    int i = localQQMessageFacade.e();
    this.a.a(32, 16, Integer.valueOf(i));
    Object localObject = new Intent("com.tencent.qq.syncQQMessage");
    localQQAppInterface.a().sendBroadcast((Intent)localObject);
    if (QLog.isDevelopLevel()) {
      QLog.d("SplashActivity", 4, "msg fresh callback.msgNum.." + i);
    }
    localObject = localQQAppInterface.a();
    i = 0;
    if (localObject != null) {
      i = ((QCallFacade)localObject).a();
    }
    BadgeUtils.a(localQQAppInterface.a(), i + localQQMessageFacade.e());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gnq
 * JD-Core Version:    0.7.0.1
 */