package com.tencent.mm.compatible.e;

import java.lang.reflect.Method;

public final class y
{
  private static Class<?> aov = null;
  private static Method dyR = null;
  private static Method dyS = null;
  
  static
  {
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      aov = localClass;
      dyR = localClass.getDeclaredMethod("get", new Class[] { String.class });
      dyS = aov.getDeclaredMethod("getInt", new Class[] { String.class, Integer.TYPE });
      dyR.setAccessible(true);
      dyS.setAccessible(true);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.SystemProperties", localException, "", new Object[0]);
    }
  }
  
  public static String get(String paramString)
  {
    try
    {
      paramString = (String)dyR.invoke(null, new Object[] { paramString });
      return paramString;
    }
    catch (Exception paramString)
    {
      com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.SystemProperties", paramString, "", new Object[0]);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.e.y
 * JD-Core Version:    0.7.0.1
 */