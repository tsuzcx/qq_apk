package androidx.k;

import android.os.Build.VERSION;
import android.os.Trace;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class a
{
  private static long brr;
  private static Method brs;
  
  public static void DS()
  {
    AppMethodBeat.i(192408);
    if (Build.VERSION.SDK_INT >= 18) {
      Trace.endSection();
    }
    AppMethodBeat.o(192408);
  }
  
  private static boolean LH()
  {
    AppMethodBeat.i(192416);
    if (Build.VERSION.SDK_INT >= 18) {
      try
      {
        if (brs == null)
        {
          brr = Trace.class.getField("TRACE_TAG_APP").getLong(null);
          brs = Trace.class.getMethod("isTagEnabled", new Class[] { Long.TYPE });
        }
        boolean bool = ((Boolean)brs.invoke(null, new Object[] { Long.valueOf(brr) })).booleanValue();
        AppMethodBeat.o(192416);
        return bool;
      }
      catch (Exception localException)
      {
        if ((localException instanceof InvocationTargetException))
        {
          Object localObject = localException.getCause();
          if ((localObject instanceof RuntimeException))
          {
            localObject = (RuntimeException)localObject;
            AppMethodBeat.o(192416);
            throw ((Throwable)localObject);
          }
          localObject = new RuntimeException((Throwable)localObject);
          AppMethodBeat.o(192416);
          throw ((Throwable)localObject);
        }
        new StringBuilder("Unable to call ").append("isTagEnabled").append(" via reflection");
      }
    }
    AppMethodBeat.o(192416);
    return false;
  }
  
  public static void ax(String paramString)
  {
    AppMethodBeat.i(192402);
    if (Build.VERSION.SDK_INT >= 18) {
      Trace.beginSection(paramString);
    }
    AppMethodBeat.o(192402);
  }
  
  public static boolean isEnabled()
  {
    AppMethodBeat.i(192393);
    try
    {
      if (brs == null)
      {
        bool = Trace.isEnabled();
        AppMethodBeat.o(192393);
        return bool;
      }
    }
    catch (NoClassDefFoundError localNoClassDefFoundError)
    {
      boolean bool = LH();
      AppMethodBeat.o(192393);
      return bool;
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      label23:
      break label23;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.k.a
 * JD-Core Version:    0.7.0.1
 */