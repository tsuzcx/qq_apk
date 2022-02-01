package com.tencent.d.d.b;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public final class d
{
  private static Object ZoZ;
  private static Method Zpa;
  private static boolean Zpb;
  
  static
  {
    AppMethodBeat.i(138362);
    ZoZ = null;
    Zpa = null;
    if (Build.VERSION.SDK_INT >= 14) {
      try
      {
        ZoZ = f.oD("libcore.io.Libcore", "os");
        Zpa = f.a("libcore.io.Os", "stat", new Class[] { String.class });
        Zpb = true;
        AppMethodBeat.o(138362);
        return;
      }
      catch (Throwable localThrowable) {}
    }
    Zpb = false;
    AppMethodBeat.o(138362);
  }
  
  public static int bCT(String paramString)
  {
    AppMethodBeat.i(138361);
    if (!Zpb)
    {
      AppMethodBeat.o(138361);
      return 0;
    }
    paramString = Zpa.invoke(ZoZ, new Object[] { paramString });
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
    return Zpb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.d.b.d
 * JD-Core Version:    0.7.0.1
 */