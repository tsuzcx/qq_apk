package com.tencent.e.d.b;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public final class c
{
  private static Object Bkp;
  private static Method Bkq;
  private static boolean Bkr;
  
  static
  {
    AppMethodBeat.i(114521);
    Bkp = null;
    Bkq = null;
    if (Build.VERSION.SDK_INT >= 14) {
      try
      {
        Bkp = e.iR("libcore.io.Libcore", "os");
        Bkq = e.a("libcore.io.Os", "stat", new Class[] { String.class });
        Bkr = true;
        AppMethodBeat.o(114521);
        return;
      }
      catch (Throwable localThrowable) {}
    }
    Bkr = false;
    AppMethodBeat.o(114521);
  }
  
  public static int awC(String paramString)
  {
    AppMethodBeat.i(114520);
    if (!Bkr)
    {
      AppMethodBeat.o(114520);
      return 0;
    }
    paramString = Bkq.invoke(Bkp, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(114520);
      return 0;
    }
    int i = ((Integer)e.a(paramString.getClass(), "st_mode", paramString)).intValue();
    AppMethodBeat.o(114520);
    return i;
  }
  
  public static boolean isAvailable()
  {
    return Bkr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.e.d.b.c
 * JD-Core Version:    0.7.0.1
 */