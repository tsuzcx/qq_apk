package com.tencent.e.d.b;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public final class d
{
  private static Object ahtH;
  private static Method ahtI;
  private static boolean ahtJ;
  
  static
  {
    AppMethodBeat.i(138362);
    ahtH = null;
    ahtI = null;
    if (Build.VERSION.SDK_INT >= 14) {
      try
      {
        ahtH = f.qB("libcore.io.Libcore", "os");
        ahtI = f.a("libcore.io.Os", "stat", new Class[] { String.class });
        ahtJ = true;
        AppMethodBeat.o(138362);
        return;
      }
      finally {}
    }
    ahtJ = false;
    AppMethodBeat.o(138362);
  }
  
  public static int bFy(String paramString)
  {
    AppMethodBeat.i(138361);
    if (!ahtJ)
    {
      AppMethodBeat.o(138361);
      return 0;
    }
    paramString = ahtI.invoke(ahtH, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(138361);
      return 0;
    }
    int i = ((Integer)f.b(paramString.getClass(), "st_mode", paramString)).intValue();
    AppMethodBeat.o(138361);
    return i;
  }
  
  public static boolean isAvailable()
  {
    return ahtJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.d.b.d
 * JD-Core Version:    0.7.0.1
 */