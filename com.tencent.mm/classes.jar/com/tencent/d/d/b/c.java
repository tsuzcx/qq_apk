package com.tencent.d.d.b;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public final class c
{
  private static Object JTc;
  private static Method JTd;
  private static boolean JTe;
  
  static
  {
    AppMethodBeat.i(138362);
    JTc = null;
    JTd = null;
    if (Build.VERSION.SDK_INT >= 14) {
      try
      {
        JTc = e.mm("libcore.io.Libcore", "os");
        JTd = e.a("libcore.io.Os", "stat", new Class[] { String.class });
        JTe = true;
        AppMethodBeat.o(138362);
        return;
      }
      catch (Throwable localThrowable) {}
    }
    JTe = false;
    AppMethodBeat.o(138362);
  }
  
  public static int aTk(String paramString)
  {
    AppMethodBeat.i(138361);
    if (!JTe)
    {
      AppMethodBeat.o(138361);
      return 0;
    }
    paramString = JTd.invoke(JTc, new Object[] { paramString });
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
    return JTe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.d.b.c
 * JD-Core Version:    0.7.0.1
 */