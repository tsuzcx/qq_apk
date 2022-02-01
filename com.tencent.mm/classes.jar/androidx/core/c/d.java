package androidx.core.c;

import android.os.Build.VERSION;
import android.os.Trace;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class d
{
  private static long Lg;
  private static Method Lh;
  private static Method Li;
  private static Method Lj;
  private static Method Lk;
  
  static
  {
    AppMethodBeat.i(251052);
    if ((Build.VERSION.SDK_INT >= 18) && (Build.VERSION.SDK_INT < 29)) {
      try
      {
        Lg = Trace.class.getField("TRACE_TAG_APP").getLong(null);
        Lh = Trace.class.getMethod("isTagEnabled", new Class[] { Long.TYPE });
        Li = Trace.class.getMethod("asyncTraceBegin", new Class[] { Long.TYPE, String.class, Integer.TYPE });
        Lj = Trace.class.getMethod("asyncTraceEnd", new Class[] { Long.TYPE, String.class, Integer.TYPE });
        Lk = Trace.class.getMethod("traceCounter", new Class[] { Long.TYPE, String.class, Integer.TYPE });
        AppMethodBeat.o(251052);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(251052);
  }
  
  public static void D(String paramString)
  {
    AppMethodBeat.i(251047);
    if (Build.VERSION.SDK_INT >= 18) {
      Trace.beginSection(paramString);
    }
    AppMethodBeat.o(251047);
  }
  
  public static void gH()
  {
    AppMethodBeat.i(251050);
    if (Build.VERSION.SDK_INT >= 18) {
      Trace.endSection();
    }
    AppMethodBeat.o(251050);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.core.c.d
 * JD-Core Version:    0.7.0.1
 */