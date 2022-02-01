package com.tencent.device.utils;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public final class SmartDeviceReport
{
  public static final String a = "SmartDevice";
  
  public static void a(AppRuntime paramAppRuntime, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramAppRuntime, paramString, paramInt1, paramInt2, paramInt3, 0, "", "");
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, String paramString3)
  {
    QQAppInterface localQQAppInterface = null;
    if ((paramAppRuntime instanceof QQAppInterface)) {
      localQQAppInterface = (QQAppInterface)paramAppRuntime;
    }
    String str1 = "" + paramInt3;
    String str2 = "" + paramInt4;
    if (paramString2 == null)
    {
      paramAppRuntime = "";
      if (paramString3 != null) {
        break label107;
      }
    }
    label107:
    for (paramString2 = "";; paramString2 = paramString3)
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "SmartDevice", paramString1, paramInt1, paramInt2, str1, str2, paramAppRuntime, paramString2);
      return;
      paramAppRuntime = paramString2;
      break;
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean, long paramLong)
  {
    String[] arrayOfString = new String[3];
    if (NetworkUtil.a(paramAppRuntime.getApplication().getApplicationContext()) == 1) {
      arrayOfString[1] = "param_WIFIFlow";
    }
    for (;;)
    {
      arrayOfString[2] = "param_Flow";
      paramAppRuntime.sendAppDataIncermentMsg(paramAppRuntime.getAccount(), arrayOfString, paramLong);
      return;
      arrayOfString[1] = "param_XGFlow";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.device.utils.SmartDeviceReport
 * JD-Core Version:    0.7.0.1
 */