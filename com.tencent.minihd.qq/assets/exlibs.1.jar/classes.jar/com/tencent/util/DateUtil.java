package com.tencent.util;

import android.text.TextUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil
{
  public static int a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return 0;
    }
    Calendar localCalendar1 = Calendar.getInstance();
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar1.setTime(a("yyyyMMdd", paramString1));
    localCalendar2.setTime(a("yyyyMMdd", paramString2));
    localCalendar1.set(11, 0);
    localCalendar1.set(12, 0);
    localCalendar1.set(13, 0);
    localCalendar2.set(11, 0);
    localCalendar2.set(12, 0);
    localCalendar2.set(13, 0);
    return ((int)(localCalendar2.getTime().getTime() / 1000L) - (int)(localCalendar1.getTime().getTime() / 1000L)) / 3600 / 24;
  }
  
  public static long a()
  {
    return System.currentTimeMillis() / 1000L;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.isEmpty()) || (paramString1.equals("null"))) {
      return "";
    }
    String str;
    if (paramString2 != null)
    {
      str = paramString2;
      if (!paramString2.isEmpty()) {}
    }
    else
    {
      str = "yyyy-MM-dd HH:mm:ss";
    }
    return new SimpleDateFormat(str).format(new Date(Long.valueOf(paramString1 + "000").longValue()));
  }
  
  private static Date a(String paramString1, String paramString2)
  {
    paramString1 = new SimpleDateFormat(paramString1);
    try
    {
      paramString1 = paramString1.parse(paramString2);
      return paramString1;
    }
    catch (ParseException paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.util.DateUtil
 * JD-Core Version:    0.7.0.1
 */