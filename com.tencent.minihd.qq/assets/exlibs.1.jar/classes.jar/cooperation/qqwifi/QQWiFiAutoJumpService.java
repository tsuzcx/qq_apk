package cooperation.qqwifi;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppService;

public class QQWiFiAutoJumpService
  extends AppService
{
  public static final String a = "QQWiFiAutoJumpService";
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQWiFiAutoJumpService", 2, "onStartCommand");
    }
    if ((paramIntent != null) && (!TextUtils.isEmpty(paramIntent.getAction())) && (paramIntent.getAction().equals("com.tencent.mobileqq.msf.qqwifi.autoconnect"))) {
      QQWiFiHelper.a((QQAppInterface)this.app, paramIntent);
    }
    stopSelf();
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qqwifi.QQWiFiAutoJumpService
 * JD-Core Version:    0.7.0.1
 */