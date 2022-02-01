package com.tencent.d.d.b;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public final class c
{
  private static Object Irs;
  private static Method Irt;
  private static boolean Iru;
  
  static
  {
    AppMethodBeat.i(138362);
    Irs = null;
    Irt = null;
    if (Build.VERSION.SDK_INT >= 14) {
      try
      {
        Irs = e.lP("libcore.io.Libcore", "os");
        Irt = e.a("libcore.io.Os", "stat", new Class[] { String.class });
        Iru = true;
        AppMethodBeat.o(138362);
        return;
      }
      catch (Throwable localThrowable) {}
    }
    Iru = false;
    AppMethodBeat.o(138362);
  }
  
  public static int aNH(String paramString)
  {
    AppMethodBeat.i(138361);
    if (!Iru)
    {
      AppMethodBeat.o(138361);
      return 0;
    }
    paramString = Irt.invoke(Irs, new Object[] { paramString });
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
    return Iru;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.d.d.b.c
 * JD-Core Version:    0.7.0.1
 */