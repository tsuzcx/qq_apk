import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqwifi.QQWiFiPluginInstallActivity;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public class lzt
  extends WtloginObserver
{
  public lzt(QQWiFiPluginInstallActivity paramQQWiFiPluginInstallActivity) {}
  
  public void OnCheckDevLockStatus(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (this.a.isFinishing()) {}
    for (;;)
    {
      return;
      if ((paramInt == 0) && (paramDevlockInfo != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d(QQWiFiPluginInstallActivity.a(), 2, "重新获取设备锁成功 OnCheckDevLockStatus ret = " + paramInt);
        }
        QQWiFiPluginInstallActivity.a(this.a, paramDevlockInfo);
        QQWiFiPluginInstallActivity.a(this.a, true);
        this.a.a(paramDevlockInfo);
      }
      while (QQWiFiPluginInstallActivity.a(this.a) != null)
      {
        QQWiFiPluginInstallActivity.a(this.a).dismiss();
        return;
        if (QLog.isColorLevel())
        {
          QLog.d(QQWiFiPluginInstallActivity.a(), 2, "重新获取设备锁失败 OnCheckDevLockStatus ret = " + paramInt);
          if (paramErrMsg != null) {
            QLog.d(QQWiFiPluginInstallActivity.a(), 2, "重新获取设备锁失败 OnCheckDevLockStatus errMsg:" + paramErrMsg.getMessage());
          }
          if (paramDevlockInfo == null) {
            QLog.d(QQWiFiPluginInstallActivity.a(), 2, "重新获取设备锁失败 OnCheckDevLockStatus DevlockInfo is null");
          }
        }
        if (QQWiFiPluginInstallActivity.a(this.a) != null) {
          QQWiFiPluginInstallActivity.a(this.a).dismiss();
        }
        QQToast.a(this.a.getApplicationContext(), "获取帐户信息失败, 请绑定通讯录", 0).a();
        QQWiFiPluginInstallActivity.a(this.a, "OnCheckDevLockStatus");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lzt
 * JD-Core Version:    0.7.0.1
 */