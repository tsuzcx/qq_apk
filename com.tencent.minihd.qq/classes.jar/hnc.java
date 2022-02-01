import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import com.tencent.mobileqq.app.PushSecSigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class hnc
  implements Runnable
{
  public hnc(PushSecSigHandler paramPushSecSigHandler) {}
  
  public void run()
  {
    QLog.d("PushSecSigHandler", 2, "mSecSigThread start");
    String str1 = SecUtil.a(this.a.a.getApplication().getApplicationInfo().sourceDir);
    if ((str1 == null) || (str1.length() == 0)) {
      return;
    }
    Object localObject1 = BaseApplication.getContext().getSharedPreferences("SecSig", 0);
    Object localObject2 = ((SharedPreferences)localObject1).edit();
    String str2 = ((SharedPreferences)localObject1).getString("SecMd5Entry", null);
    int i = ((SharedPreferences)localObject1).getInt("SecResEntry", -1);
    long l1 = ((SharedPreferences)localObject1).getLong("SecStampEntry", -1L);
    long l2 = System.currentTimeMillis();
    QLog.d("PushSecSigHandler", 2, " start:md5 = " + str1 + "cacheMd5 = " + str2 + "cacheRes = " + i + "cacheStamp = " + (l1 ^ 0x12) + "stamp = " + l2);
    ((SharedPreferences.Editor)localObject2).remove("SecResEntry");
    ((SharedPreferences.Editor)localObject2).remove("SecStampEntry");
    ((SharedPreferences.Editor)localObject2).putString("SecMd5Entry", str1);
    ((SharedPreferences.Editor)localObject2).commit();
    localObject1 = SecUtil.b(SecUtil.a(BaseApplication.getContext()));
    localObject2 = SecUtil.a(BaseApplication.getContext());
    if (!SecUtil.a(BaseApplication.getContext())) {}
    for (i = 0;; i = 1)
    {
      QLog.d("PushSecSigHandler", 2, "mSecSigThread start:publickKey:" + (String)localObject1 + "b0DayRepack:" + i);
      this.a.a(Long.parseLong(this.a.a.a()), 0, i, "MobileQQ", (String)localObject2, str1, (String)localObject1);
      PushSecSigHandler.a(this.a, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hnc
 * JD-Core Version:    0.7.0.1
 */