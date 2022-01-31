package android.support.v4.d;

import android.os.Build.VERSION;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public final class a
{
  private static Method Ei;
  private static Method Ej;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (;;)
    {
      try
      {
        Ej = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", new Class[] { Locale.class });
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
          Ei = localClass.getMethod("getScript", new Class[] { String.class });
          Ej = localClass.getMethod("addLikelySubtags", new Class[] { String.class });
          return;
        }
      }
      catch (Exception localException2)
      {
        Ei = null;
        Ej = null;
      }
    }
  }
  
  public static String a(Locale paramLocale)
  {
    String str1 = null;
    if (Build.VERSION.SDK_INT >= 21) {}
    try
    {
      str1 = ((Locale)Ej.invoke(null, new Object[] { paramLocale })).getScript();
      paramLocale = str1;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      String str2;
      do
      {
        return paramLocale.getScript();
        str2 = b(paramLocale);
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
  
  private static String b(Locale paramLocale)
  {
    paramLocale = paramLocale.toString();
    try
    {
      if (Ej != null)
      {
        String str = (String)Ej.invoke(null, new Object[] { paramLocale });
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
      if (Ei != null)
      {
        paramString = (String)Ei.invoke(null, new Object[] { paramString });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v4.d.a
 * JD-Core Version:    0.7.0.1
 */