package cooperation.qwallet.plugin;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.QLog;

public abstract class QWalletPayBridge
{
  public static boolean a(Activity paramActivity, QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    return a(paramActivity, paramQQAppInterface, paramBundle, null);
  }
  
  public static boolean a(Activity paramActivity, QQAppInterface paramQQAppInterface, Bundle paramBundle, Dialog paramDialog)
  {
    if ((paramActivity == null) || (paramBundle == null)) {}
    do
    {
      return false;
      if (paramQQAppInterface != null) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("Q.qwallet.pay", 4, "launchService appInterface == null :" + TimeFormatterUtils.a(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss SSS"));
    return false;
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.qwallet.pay", 4, "Launch PayPlugin:" + TimeFormatterUtils.a(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss SSS"));
    }
    QWalletHelper.a(paramActivity, paramQQAppInterface, paramBundle, paramDialog);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qwallet.plugin.QWalletPayBridge
 * JD-Core Version:    0.7.0.1
 */