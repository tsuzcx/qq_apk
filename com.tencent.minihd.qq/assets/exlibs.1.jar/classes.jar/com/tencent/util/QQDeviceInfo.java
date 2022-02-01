package com.tencent.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.UUID;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class QQDeviceInfo
{
  public static final int a = 1;
  public static String a;
  private static ArrayList jdField_a_of_type_JavaUtilArrayList;
  private static boolean jdField_a_of_type_Boolean = false;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  
  static
  {
    jdField_a_of_type_JavaLangString = "QQDeviceInfo";
  }
  
  public static String a()
  {
    Object localObject2 = BaseApplicationImpl.getContext();
    Object localObject1 = "";
    if ((Build.VERSION.SDK_INT >= 23) && (((Context)localObject2).checkSelfPermission("android.permission.READ_PHONE_STATE") != 0))
    {
      localObject1 = UUID.randomUUID().toString();
      return MD5.toMD5("" + (String)localObject1);
    }
    try
    {
      localObject2 = Settings.Secure.getString(((Context)localObject2).getContentResolver(), "android_id");
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      label66:
      break label66;
    }
    localObject2 = UUID.randomUUID().toString();
    return MD5.toMD5((String)localObject1 + (String)localObject2);
  }
  
  public static String a(String paramString)
  {
    a(paramString);
    return "";
  }
  
  public static String a(String paramString, int paramInt)
  {
    return a(paramString);
  }
  
  private static void a(String paramString)
  {
    if (!jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      Object localObject;
      if (jdField_a_of_type_JavaUtilArrayList == null) {
        localObject = BaseApplicationImpl.getContext();
      }
      try
      {
        localObject = ((Context)localObject).getResources().getAssets().open("SensiveAuthorityFile.xml");
        localXmlPullParser = Xml.newPullParser();
        localXmlPullParser.setInput((InputStream)localObject, "utf-8");
        i = localXmlPullParser.getEventType();
        break label192;
        for (;;)
        {
          i = localXmlPullParser.next();
          break;
          jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          XmlPullParser localXmlPullParser;
          localIOException.printStackTrace();
          if ((jdField_a_of_type_JavaUtilArrayList == null) || (jdField_a_of_type_JavaUtilArrayList.contains(paramString))) {
            break;
          }
          throw new IllegalArgumentException("busiId not registed ,please first regist");
          if (localXmlPullParser.getName().equalsIgnoreCase("business"))
          {
            String str = localXmlPullParser.getAttributeValue(null, "id");
            if (QLog.isDevelopLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 4, " init busiId  = " + str);
            }
            jdField_a_of_type_JavaUtilArrayList.add(str);
          }
        }
      }
      catch (XmlPullParserException localXmlPullParserException)
      {
        for (;;)
        {
          int i;
          localXmlPullParserException.printStackTrace();
          continue;
          label192:
          do
          {
            localXmlPullParserException.close();
            break;
          } while (i == 1);
          switch (i)
          {
          }
        }
      }
    }
  }
  
  public static String b(String paramString)
  {
    a(paramString);
    return "";
  }
  
  public static String b(String paramString, int paramInt)
  {
    return b(paramString);
  }
  
  public static String c(String paramString)
  {
    a(paramString);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.util.QQDeviceInfo
 * JD-Core Version:    0.7.0.1
 */