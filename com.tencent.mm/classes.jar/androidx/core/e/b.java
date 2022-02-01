package androidx.core.e;

import android.icu.util.ULocale;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public final class b
{
  private static Method LZ;
  private static Method Ma;
  
  static
  {
    AppMethodBeat.i(251221);
    if (Build.VERSION.SDK_INT < 21) {
      try
      {
        Class localClass = Class.forName("libcore.icu.ICU");
        if (localClass != null)
        {
          LZ = localClass.getMethod("getScript", new Class[] { String.class });
          Ma = localClass.getMethod("addLikelySubtags", new Class[] { String.class });
        }
        AppMethodBeat.o(251221);
        return;
      }
      catch (Exception localException1)
      {
        LZ = null;
        Ma = null;
        AppMethodBeat.o(251221);
        return;
      }
    }
    if (Build.VERSION.SDK_INT < 24) {
      try
      {
        Ma = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", new Class[] { Locale.class });
        AppMethodBeat.o(251221);
        return;
      }
      catch (Exception localException2)
      {
        IllegalStateException localIllegalStateException = new IllegalStateException(localException2);
        AppMethodBeat.o(251221);
        throw localIllegalStateException;
      }
    }
    AppMethodBeat.o(251221);
  }
  
  private static String E(String paramString)
  {
    AppMethodBeat.i(251219);
    try
    {
      if (LZ != null)
      {
        paramString = (String)LZ.invoke(null, new Object[] { paramString });
        AppMethodBeat.o(251219);
        return paramString;
      }
    }
    catch (InvocationTargetException paramString)
    {
      AppMethodBeat.o(251219);
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
    AppMethodBeat.i(251218);
    if (Build.VERSION.SDK_INT >= 24)
    {
      paramLocale = ULocale.addLikelySubtags(ULocale.forLocale(paramLocale)).getScript();
      AppMethodBeat.o(251218);
      return paramLocale;
    }
    if (Build.VERSION.SDK_INT >= 21) {}
    try
    {
      String str = ((Locale)Ma.invoke(null, new Object[] { paramLocale })).getScript();
      AppMethodBeat.o(251218);
      return str;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      paramLocale = paramLocale.getScript();
      AppMethodBeat.o(251218);
      return paramLocale;
      paramLocale = c(paramLocale);
      if (paramLocale != null)
      {
        paramLocale = E(paramLocale);
        AppMethodBeat.o(251218);
        return paramLocale;
      }
      AppMethodBeat.o(251218);
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
    AppMethodBeat.i(251220);
    paramLocale = paramLocale.toString();
    try
    {
      if (Ma != null)
      {
        String str = (String)Ma.invoke(null, new Object[] { paramLocale });
        AppMethodBeat.o(251220);
        return str;
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      AppMethodBeat.o(251220);
      return paramLocale;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      label43:
      break label43;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.core.e.b
 * JD-Core Version:    0.7.0.1
 */