package com.tencent.gamecenter.common.util;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class TrafficStatistics
{
  private static AppInterface a;
  public static final String a;
  public static final short a = 0;
  public static final short b = 1;
  
  static
  {
    jdField_a_of_type_JavaLangString = TrafficStatistics.class.getSimpleName();
    jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  }
  
  public static void a()
  {
    jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  }
  
  public static void a(AppInterface paramAppInterface)
  {
    if (jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    }
  }
  
  private static void a(String paramString, long paramLong)
  {
    String[] arrayOfString;
    if (NetworkUtil.b(BaseApplication.getContext()) == 1)
    {
      arrayOfString = new String[3];
      arrayOfString[0] = "param_WIFIGameCenterDownloadFlow";
      arrayOfString[1] = "param_WIFIFlow";
      arrayOfString[2] = "param_Flow";
    }
    for (;;)
    {
      a(paramString, arrayOfString, paramLong);
      return;
      arrayOfString = new String[3];
      arrayOfString[0] = "param_XGGameCenterDownloadFlow";
      arrayOfString[1] = "param_XGFlow";
      arrayOfString[2] = "param_Flow";
    }
  }
  
  public static void a(String paramString, long paramLong, short paramShort)
  {
    if (paramShort == 0) {
      a(paramString, paramLong);
    }
    while (paramShort != 1) {
      return;
    }
    b(paramString, paramLong);
  }
  
  private static void a(String paramString, String[] paramArrayOfString, long paramLong)
  {
    if ((jdField_a_of_type_ComTencentCommonAppAppInterface == null) || (paramArrayOfString == null)) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "application or tags is null, return.");
      }
    }
    for (;;)
    {
      return;
      try
      {
        String str = jdField_a_of_type_ComTencentCommonAppAppInterface.a();
        jdField_a_of_type_ComTencentCommonAppAppInterface.a(str, paramArrayOfString, paramLong);
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, paramString + " fileSize: " + paramLong);
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private static void b(String paramString, long paramLong)
  {
    String[] arrayOfString;
    if (NetworkUtil.b(BaseApplication.getContext()) == 1)
    {
      arrayOfString = new String[3];
      arrayOfString[0] = "param_WIFIGameCenterUploadFlow";
      arrayOfString[1] = "param_WIFIFlow";
      arrayOfString[2] = "param_Flow";
    }
    for (;;)
    {
      a(paramString, arrayOfString, paramLong);
      return;
      arrayOfString = new String[3];
      arrayOfString[0] = "param_XGGameCenterUploadFlow";
      arrayOfString[1] = "param_XGFlow";
      arrayOfString[2] = "param_Flow";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.TrafficStatistics
 * JD-Core Version:    0.7.0.1
 */