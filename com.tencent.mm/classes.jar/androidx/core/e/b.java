package androidx.core.e;

import android.icu.util.ULocale;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public final class b
{
  private static Method bsf;
  private static Method bsg;
  
  static
  {
    AppMethodBeat.i(195479);
    if (Build.VERSION.SDK_INT < 21) {
      try
      {
        Class localClass = Class.forName("libcore.icu.ICU");
        if (localClass != null)
        {
          bsf = localClass.getMethod("getScript", new Class[] { String.class });
          bsg = localClass.getMethod("addLikelySubtags", new Class[] { String.class });
        }
        AppMethodBeat.o(195479);
        return;
      }
      catch (Exception localException1)
      {
        bsf = null;
        bsg = null;
        AppMethodBeat.o(195479);
        return;
      }
    }
    if (Build.VERSION.SDK_INT < 24) {
      try
      {
        bsg = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", new Class[] { Locale.class });
        AppMethodBeat.o(195479);
        return;
      }
      catch (Exception localException2)
      {
        IllegalStateException localIllegalStateException = new IllegalStateException(localException2);
        AppMethodBeat.o(195479);
        throw localIllegalStateException;
      }
    }
    AppMethodBeat.o(195479);
  }
  
  private static String ay(String paramString)
  {
    AppMethodBeat.i(195458);
    try
    {
      if (bsf != null)
      {
        paramString = (String)bsf.invoke(null, new Object[] { paramString });
        AppMethodBeat.o(195458);
        return paramString;
      }
    }
    catch (InvocationTargetException paramString)
    {
      AppMethodBeat.o(195458);
      return null;
    }
    catch (IllegalAccessException paramString)
    {
      label38:
      break label38;
    }
  }
  
  public static String b(Locale paramLocale)
  {
    AppMethodBeat.i(195449);
    if (Build.VERSION.SDK_INT >= 24)
    {
      paramLocale = ULocale.addLikelySubtags(ULocale.forLocale(paramLocale)).getScript();
      AppMethodBeat.o(195449);
      return paramLocale;
    }
    if (Build.VERSION.SDK_INT >= 21) {}
    try
    {
      String str = ((Locale)bsg.invoke(null, new Object[] { paramLocale })).getScript();
      AppMethodBeat.o(195449);
      return str;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      paramLocale = paramLocale.getScript();
      AppMethodBeat.o(195449);
      return paramLocale;
      paramLocale = c(paramLocale);
      if (paramLocale != null)
      {
        paramLocale = ay(paramLocale);
        AppMethodBeat.o(195449);
        return paramLocale;
      }
      AppMethodBeat.o(195449);
      return null;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      label69:
      break label69;
    }
  }
  
  private static String c(Locale paramLocale)
  {
    AppMethodBeat.i(195465);
    paramLocale = paramLocale.toString();
    try
    {
      if (bsg != null)
      {
        String str = (String)bsg.invoke(null, new Object[] { paramLocale });
        AppMethodBeat.o(195465);
        return str;
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      AppMethodBeat.o(195465);
      return paramLocale;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      label43:
      break label43;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.core.e.b
 * JD-Core Version:    0.7.0.1
 */