package com.tencent.smtt.sdk.a;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class a
{
  public static String a(long paramLong)
  {
    return String.format(Locale.getDefault(), "%d(%s)", new Object[] { Long.valueOf(paramLong), new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date(paramLong)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.a.a
 * JD-Core Version:    0.7.0.1
 */