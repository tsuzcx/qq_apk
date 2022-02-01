package com.tencent.mobileqq.activity.widget.qqmusic.utils.parser;

import com.tencent.mobileqq.activity.widget.qqmusic.utils.MusicUtil;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Response
{
  public static final int a = 100;
  public static final int b = -100;
  public final Reader a;
  
  public Response(Reader paramReader)
  {
    this.a = paramReader;
  }
  
  public static float a(String paramString, float paramFloat)
  {
    float f = paramFloat;
    if (paramString != null)
    {
      f = paramFloat;
      if (paramString.length() <= 0) {}
    }
    try
    {
      f = Float.parseFloat(paramString);
      return f;
    }
    catch (Exception paramString) {}
    return paramFloat;
  }
  
  public static int a(String paramString, int paramInt)
  {
    int i = paramInt;
    if (paramString != null)
    {
      i = paramInt;
      if (paramString.length() <= 0) {}
    }
    try
    {
      i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString) {}
    return paramInt;
  }
  
  public static long a(String paramString, int paramInt)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      try
      {
        long l = Long.parseLong(paramString);
        return l;
      }
      catch (Exception paramString) {}
    }
    return paramInt;
  }
  
  public static String a(String paramString)
  {
    return MusicUtil.b(paramString);
  }
  
  public static Date a(String paramString)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
    try
    {
      paramString = localSimpleDateFormat.parse(paramString);
      return paramString;
    }
    catch (Exception paramString) {}
    return new Date();
  }
  
  public static boolean a(String paramString, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (paramString != null)
    {
      bool = paramBoolean;
      if (paramString.length() <= 0) {}
    }
    try
    {
      int i = Integer.valueOf(paramString).intValue();
      if (i == 1)
      {
        bool = true;
        return bool;
      }
      return false;
    }
    catch (Exception paramString) {}
    return paramBoolean;
  }
  
  public static String b(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      try
      {
        paramString = new String(URLDecoder.decode(paramString, "UTF-8"));
        return paramString;
      }
      catch (Exception paramString) {}
    }
    return null;
  }
  
  public int a()
  {
    return 100;
  }
  
  public void a()
  {
    this.a.b();
  }
  
  public void a(String paramString)
  {
    this.a.a(paramString.getBytes());
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.a.a(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.utils.parser.Response
 * JD-Core Version:    0.7.0.1
 */