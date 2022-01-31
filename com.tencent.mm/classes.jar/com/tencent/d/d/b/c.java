package com.tencent.d.d.b;

import android.os.Build.VERSION;
import java.lang.reflect.Method;

public final class c
{
  private static Object wMQ = null;
  private static Method wMR = null;
  private static boolean wMS = false;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 14) {
      try
      {
        wMQ = e.gL("libcore.io.Libcore", "os");
        wMR = e.a("libcore.io.Os", "stat", new Class[] { String.class });
        wMS = true;
        return;
      }
      catch (Throwable localThrowable) {}
    }
  }
  
  public static int afG(String paramString)
  {
    if (!wMS) {}
    do
    {
      return 0;
      paramString = wMR.invoke(wMQ, new Object[] { paramString });
    } while (paramString == null);
    return ((Integer)e.a(paramString.getClass(), "st_mode", paramString)).intValue();
  }
  
  public static boolean isAvailable()
  {
    return wMS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.d.d.b.c
 * JD-Core Version:    0.7.0.1
 */