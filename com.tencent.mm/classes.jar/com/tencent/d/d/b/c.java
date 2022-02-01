package com.tencent.d.d.b;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public final class c
{
  private static Object MjS;
  private static Method MjT;
  private static boolean MjU;
  
  static
  {
    AppMethodBeat.i(138362);
    MjS = null;
    MjT = null;
    if (Build.VERSION.SDK_INT >= 14) {
      try
      {
        MjS = e.mQ("libcore.io.Libcore", "os");
        MjT = e.a("libcore.io.Os", "stat", new Class[] { String.class });
        MjU = true;
        AppMethodBeat.o(138362);
        return;
      }
      catch (Throwable localThrowable) {}
    }
    MjU = false;
    AppMethodBeat.o(138362);
  }
  
  public static int baN(String paramString)
  {
    AppMethodBeat.i(138361);
    if (!MjU)
    {
      AppMethodBeat.o(138361);
      return 0;
    }
    paramString = MjT.invoke(MjS, new Object[] { paramString });
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
    return MjU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.d.b.c
 * JD-Core Version:    0.7.0.1
 */