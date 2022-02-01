import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSvcObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class kqr
  extends SecSvcObserver
{
  public kqr(AntiFraudConfigFileUtil paramAntiFraudConfigFileUtil) {}
  
  protected void b(int paramInt, Bundle paramBundle)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localQQAppInterface != null) {
      localQQAppInterface.c(AntiFraudConfigFileUtil.a(this.a));
    }
    if (paramInt != 1) {
      if (QLog.isColorLevel()) {
        QLog.d("SecSvcObserver", 2, "invalid notification type for onGetUinSafetyWordingConfig:" + Integer.toString(paramInt));
      }
    }
    while (paramBundle == null) {
      return;
    }
    ThreadManager.b(new kqs(this, paramBundle.getString("config_name"), paramBundle.getInt("effect_time", 0), paramBundle.getString("md5"), paramBundle.getString("download_url")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kqr
 * JD-Core Version:    0.7.0.1
 */