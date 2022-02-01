package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class LightTalkTipsData
{
  private static LightTalkTipsData a;
  public static final String a;
  public static final String b;
  public static final String c = "__";
  public static final String d;
  public String e;
  public String f;
  
  static
  {
    jdField_a_of_type_JavaLangString = BaseApplicationImpl.getContext().getFilesDir() + File.separator + "lightalkfiles";
    b = jdField_a_of_type_JavaLangString + File.separator + "lightalk_tips_config";
    d = jdField_a_of_type_JavaLangString + File.separator + "qq_aio_tips_lightalk_icon";
    jdField_a_of_type_ComTencentMobileqqActivityRecentLightTalkTipsData = null;
  }
  
  public static LightTalkTipsData a()
  {
    long l1 = SystemClock.uptimeMillis();
    b();
    long l2 = SystemClock.uptimeMillis();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("read config cost ").append(l2 - l1).append(" , result is ");
      if (jdField_a_of_type_ComTencentMobileqqActivityRecentLightTalkTipsData != null) {
        break label71;
      }
    }
    label71:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("lightalktips", 2, bool);
      return jdField_a_of_type_ComTencentMobileqqActivityRecentLightTalkTipsData;
    }
  }
  
  public static void a()
  {
    jdField_a_of_type_ComTencentMobileqqActivityRecentLightTalkTipsData = null;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if ((StringUtil.b(paramString1)) || (StringUtil.b(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("lightalktips", 2, "save config failed, param is null");
      }
      return;
    }
    new File(jdField_a_of_type_JavaLangString).mkdirs();
    File localFile = new File(b);
    if (localFile.exists()) {
      localFile.delete();
    }
    try
    {
      localFile.createNewFile();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("__");
      localStringBuilder.append(paramString2);
      paramString1 = localStringBuilder.toString().getBytes("UTF-8");
      paramString2 = new FileOutputStream(localFile);
      paramString2.write(paramString1);
      paramString2.flush();
      return;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private static void b()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityRecentLightTalkTipsData != null) {
      if (QLog.isColorLevel()) {
        QLog.d("lightalktips", 2, "sTips has been initialised");
      }
    }
    for (;;)
    {
      return;
      Object localObject1 = new File(b);
      Object localObject2 = new File(d);
      if ((((File)localObject1).exists()) && (((File)localObject1).length() > 0L) && (((File)localObject2).exists())) {
        try
        {
          localObject1 = new FileInputStream((File)localObject1);
          localObject2 = new byte[((FileInputStream)localObject1).available()];
          ((FileInputStream)localObject1).read((byte[])localObject2);
          localObject1 = new String((byte[])localObject2, "UTF-8");
          if (localObject1 != null)
          {
            localObject1 = ((String)localObject1).split("__");
            if (localObject1.length == 2)
            {
              jdField_a_of_type_ComTencentMobileqqActivityRecentLightTalkTipsData = new LightTalkTipsData();
              jdField_a_of_type_ComTencentMobileqqActivityRecentLightTalkTipsData.e = localObject1[0];
              jdField_a_of_type_ComTencentMobileqqActivityRecentLightTalkTipsData.f = localObject1[1];
              return;
            }
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          jdField_a_of_type_ComTencentMobileqqActivityRecentLightTalkTipsData = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.LightTalkTipsData
 * JD-Core Version:    0.7.0.1
 */