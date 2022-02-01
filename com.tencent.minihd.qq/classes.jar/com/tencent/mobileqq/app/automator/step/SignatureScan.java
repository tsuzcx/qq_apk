package com.tencent.mobileqq.app.automator.step;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSigHandler;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class SignatureScan
  extends AsyncStep
{
  private static final long jdField_c_of_type_Long = 604800000L;
  private static final String jdField_c_of_type_JavaLangString = "sec_sig_tag";
  
  protected int a()
  {
    QQAppInterface localQQAppInterface = this.a.a;
    if (QLog.isColorLevel()) {
      QLog.d("sec_sig_tag", 2, "mSecSigThread start");
    }
    String str1 = SecUtil.a(BaseApplicationImpl.a.getApplicationInfo().sourceDir);
    if ((str1 == null) || (str1.length() == 0)) {
      return 7;
    }
    Object localObject1 = BaseApplication.getContext().getSharedPreferences("SecSig", 0);
    Object localObject2 = ((SharedPreferences)localObject1).edit();
    String str2 = ((SharedPreferences)localObject1).getString("SecMd5Entry", null);
    int i = ((SharedPreferences)localObject1).getInt("SecResEntry", -1);
    long l1 = ((SharedPreferences)localObject1).getLong("SecStampEntry", -1L);
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("sec_sig_tag", 2, "mSecSigThread start:md5 = " + str1 + "cacheMd5 = " + str2 + "cacheRes = " + i + "cacheStamp = " + (0x12 ^ l1) + "stamp = " + l2);
    }
    if ((str2 != null) && (str2.equalsIgnoreCase(str1)) && (l1 != -1L) && (l2 <= (0x12 ^ l1) + 604800000L) && (i != -1) && ((i ^ 0x12) == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("sec_sig_tag", 2, "mSecSigTask:run:check ok");
      }
      return 7;
    }
    if (l2 > (0x12 ^ l1) + 604800000L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("sec_sig_tag", 2, "mSecSigThread start cache expired");
      }
      ((SharedPreferences.Editor)localObject2).remove("SecResEntry");
      ((SharedPreferences.Editor)localObject2).remove("SecStampEntry");
    }
    ((SharedPreferences.Editor)localObject2).putString("SecMd5Entry", str1);
    ((SharedPreferences.Editor)localObject2).commit();
    localObject1 = SecUtil.b(SecUtil.a(BaseApplication.getContext()));
    localObject2 = SecUtil.a(BaseApplication.getContext());
    if (!SecUtil.a(BaseApplication.getContext())) {}
    for (i = 0;; i = 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("sec_sig_tag", 2, "mSecSigThread start:publickKey:" + (String)localObject1 + "b0DayRepack:" + i);
      }
      if (Build.VERSION.RELEASE.startsWith("4.4")) {
        str1 = "art";
      }
      ((SecSigHandler)localQQAppInterface.a(23)).a(Long.parseLong(localQQAppInterface.a()), 0, i, "MobileQQ", (String)localObject2, str1, (String)localObject1);
      return 7;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.SignatureScan
 * JD-Core Version:    0.7.0.1
 */