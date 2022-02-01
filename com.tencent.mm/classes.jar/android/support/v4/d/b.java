package android.support.v4.d;

import android.os.Build.VERSION;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public final class b
{
  private static Method Lg;
  private static Method Lh;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (;;)
    {
      try
      {
        Lh = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", new Class[] { Locale.class });
        return;
      }
      catch (Exception localException1)
      {
        throw new IllegalStateException(localException1);
      }
      try
      {
        Class localClass = Class.forName("libcore.icu.ICU");
        if (localClass != null)
        {
          Lg = localClass.getMethod("getScript", new Class[] { String.class });
          Lh = localClass.getMethod("addLikelySubtags", new Class[] { String.class });
          return;
        }
      }
      catch (Exception localException2)
      {
        Lg = null;
        Lh = null;
      }
    }
  }
  
  public static String b(Locale paramLocale)
  {
    String str1 = null;
    if (Build.VERSION.SDK_INT >= 21) {}
    try
    {
      str1 = ((Locale)Lh.invoke(null, new Object[] { paramLocale })).getScript();
      paramLocale = str1;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      String str2;
      do
      {
        return paramLocale.getScript();
        str2 = c(paramLocale);
        paramLocale = localIllegalAccessException;
      } while (str2 == null);
      return getScript(str2);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      break label37;
    }
    return paramLocale;
  }
  
  private static String c(Locale paramLocale)
  {
    paramLocale = paramLocale.toString();
    try
    {
      if (Lh != null)
      {
        String str = (String)Lh.invoke(null, new Object[] { paramLocale });
        return str;
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      return paramLocale;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      label33:
      break label33;
    }
  }
  
  private static String getScript(String paramString)
  {
    try
    {
      if (Lg != null)
      {
        paramString = (String)Lg.invoke(null, new Object[] { paramString });
        return paramString;
      }
    }
    catch (InvocationTargetException paramString)
    {
      return null;
    }
    catch (IllegalAccessException paramString)
    {
      label28:
      break label28;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.d.b
 * JD-Core Version:    0.7.0.1
 */