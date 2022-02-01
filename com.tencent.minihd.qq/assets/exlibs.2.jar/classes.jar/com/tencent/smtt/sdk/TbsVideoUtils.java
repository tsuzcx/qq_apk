package com.tencent.smtt.sdk;

import android.content.Context;

public class TbsVideoUtils
{
  private static t a = null;
  
  private static void a(Context paramContext)
  {
    try
    {
      if (a == null)
      {
        g.a(true).a(paramContext, false, false);
        v localv = g.a(true).a();
        paramContext = null;
        if (localv != null) {
          paramContext = localv.b();
        }
        if (paramContext != null) {
          a = new t(paramContext);
        }
      }
      return;
    }
    finally {}
  }
  
  public static void deleteVideoCache(Context paramContext, String paramString)
  {
    a(paramContext);
    if (a != null) {
      a.a(paramContext, paramString);
    }
  }
  
  public static String getCurWDPDecodeType(Context paramContext)
  {
    a(paramContext);
    if (a != null) {
      return a.a(paramContext);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsVideoUtils
 * JD-Core Version:    0.7.0.1
 */