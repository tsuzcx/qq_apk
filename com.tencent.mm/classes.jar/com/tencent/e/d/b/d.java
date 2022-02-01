package com.tencent.e.d.b;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public final class d
{
  private static Object RMt;
  private static Method RMu;
  private static boolean RMv;
  
  static
  {
    AppMethodBeat.i(138362);
    RMt = null;
    RMu = null;
    if (Build.VERSION.SDK_INT >= 14) {
      try
      {
        RMt = f.nH("libcore.io.Libcore", "os");
        RMu = f.a("libcore.io.Os", "stat", new Class[] { String.class });
        RMv = true;
        AppMethodBeat.o(138362);
        return;
      }
      catch (Throwable localThrowable) {}
    }
    RMv = false;
    AppMethodBeat.o(138362);
  }
  
  public static int bqb(String paramString)
  {
    AppMethodBeat.i(138361);
    if (!RMv)
    {
      AppMethodBeat.o(138361);
      return 0;
    }
    paramString = RMu.invoke(RMt, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(138361);
      return 0;
    }
    int i = ((Integer)f.c(paramString.getClass(), "st_mode", paramString)).intValue();
    AppMethodBeat.o(138361);
    return i;
  }
  
  public static boolean isAvailable()
  {
    return RMv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.e.d.b.d
 * JD-Core Version:    0.7.0.1
 */