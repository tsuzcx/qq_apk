package com.tencent.d.d.b;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public final class c
{
  private static Object LMT;
  private static Method LMU;
  private static boolean LMV;
  
  static
  {
    AppMethodBeat.i(138362);
    LMT = null;
    LMU = null;
    if (Build.VERSION.SDK_INT >= 14) {
      try
      {
        LMT = e.mK("libcore.io.Libcore", "os");
        LMU = e.a("libcore.io.Os", "stat", new Class[] { String.class });
        LMV = true;
        AppMethodBeat.o(138362);
        return;
      }
      catch (Throwable localThrowable) {}
    }
    LMV = false;
    AppMethodBeat.o(138362);
  }
  
  public static int aZk(String paramString)
  {
    AppMethodBeat.i(138361);
    if (!LMV)
    {
      AppMethodBeat.o(138361);
      return 0;
    }
    paramString = LMU.invoke(LMT, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(138361);
      return 0;
    }
    int i = ((Integer)e.b(paramString.getClass(), "st_mode", paramString)).intValue();
    AppMethodBeat.o(138361);
    return i;
  }
  
  public static boolean isAvailable()
  {
    return LMV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.d.b.c
 * JD-Core Version:    0.7.0.1
 */