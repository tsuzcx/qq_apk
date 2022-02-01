package androidx.core.c;

import android.os.Build.VERSION;
import android.os.Trace;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Deprecated
public final class g
{
  private static long brr;
  private static Method brs;
  private static Method brt;
  private static Method bru;
  private static Method brv;
  
  static
  {
    AppMethodBeat.i(195446);
    if ((Build.VERSION.SDK_INT >= 18) && (Build.VERSION.SDK_INT < 29)) {
      try
      {
        brr = Trace.class.getField("TRACE_TAG_APP").getLong(null);
        brs = Trace.class.getMethod("isTagEnabled", new Class[] { Long.TYPE });
        brt = Trace.class.getMethod("asyncTraceBegin", new Class[] { Long.TYPE, String.class, Integer.TYPE });
        bru = Trace.class.getMethod("asyncTraceEnd", new Class[] { Long.TYPE, String.class, Integer.TYPE });
        brv = Trace.class.getMethod("traceCounter", new Class[] { Long.TYPE, String.class, Integer.TYPE });
        AppMethodBeat.o(195446);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(195446);
  }
  
  public static void DS()
  {
    AppMethodBeat.i(195436);
    if (Build.VERSION.SDK_INT >= 18) {
      Trace.endSection();
    }
    AppMethodBeat.o(195436);
  }
  
  public static void ax(String paramString)
  {
    AppMethodBeat.i(195429);
    if (Build.VERSION.SDK_INT >= 18) {
      Trace.beginSection(paramString);
    }
    AppMethodBeat.o(195429);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.core.c.g
 * JD-Core Version:    0.7.0.1
 */