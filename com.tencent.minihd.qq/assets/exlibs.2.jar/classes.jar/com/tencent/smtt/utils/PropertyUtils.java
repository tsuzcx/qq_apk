package com.tencent.smtt.utils;

import android.text.TextUtils;
import java.lang.reflect.Method;

public class PropertyUtils
{
  private static Class a;
  private static Method b;
  
  static
  {
    try
    {
      a = Class.forName("android.os.SystemProperties");
      b = a.getDeclaredMethod("get", new Class[] { String.class, String.class });
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private static String a(String paramString1, String paramString2)
  {
    if ((a == null) || (b == null)) {
      return paramString2;
    }
    try
    {
      paramString1 = (String)b.invoke(a, new Object[] { paramString1, paramString2 });
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
    }
    return paramString2;
  }
  
  public static String getQuickly(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString2;
    }
    return a(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.utils.PropertyUtils
 * JD-Core Version:    0.7.0.1
 */