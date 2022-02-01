package cooperation.qqwifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class AutoConnectReceiver
  extends BroadcastReceiver
{
  public static final String a = "AutoConnectReceiver";
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AutoConnectReceiver", 2, "onReceive-qqwifi autoconnect");
    }
    if ((paramIntent != null) && (!TextUtils.isEmpty(paramIntent.getAction())) && (paramIntent.getAction().equals("com.tencent.mobileqq.msf.qqwifi.autoconnect"))) {
      QQWiFiHelper.a((QQAppInterface)BaseApplicationImpl.a().a(), paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qqwifi.AutoConnectReceiver
 * JD-Core Version:    0.7.0.1
 */