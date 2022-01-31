package com.tencent.magicbrush;

import com.tencent.magicbrush.a.d.f;
import java.io.File;
import java.lang.reflect.Method;

public class a
{
  private static String bkg = "";
  private static String bkh = null;
  
  public static boolean bl(String paramString)
  {
    return (paramString == null) || ("".equals(paramString));
  }
  
  public static void loadLibrary(String paramString)
  {
    String str = null;
    if (bkh != null) {
      str = bkh + "/lib" + paramString + ".so";
    }
    if ((str != null) && (new File(str).exists()))
    {
      d.f.d("MagicBrush.Utils", "System.load(%s)", new Object[] { str });
      try
      {
        paramString = a.class.getClassLoader();
        Runtime localRuntime = Runtime.getRuntime();
        Method localMethod = localRuntime.getClass().getDeclaredMethod("load", new Class[] { String.class, ClassLoader.class });
        localMethod.setAccessible(true);
        localMethod.invoke(localRuntime, new Object[] { str, paramString });
        return;
      }
      catch (Exception paramString)
      {
        d.f.e("MagicBrush.Utils", "loadLibrary Exception", new Object[] { paramString });
        return;
      }
    }
    d.f.d("MagicBrush.Utils", "System.loadLibrary(%s)", new Object[] { paramString });
    System.loadLibrary(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.a
 * JD-Core Version:    0.7.0.1
 */