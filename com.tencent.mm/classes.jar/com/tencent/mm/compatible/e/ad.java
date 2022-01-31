package com.tencent.mm.compatible.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.Method;

public final class ad
{
  private static Class<?> aqP;
  private static Method erH;
  private static Method erI;
  
  static
  {
    AppMethodBeat.i(93021);
    aqP = null;
    erH = null;
    erI = null;
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      aqP = localClass;
      erH = localClass.getDeclaredMethod("get", new Class[] { String.class });
      erI = aqP.getDeclaredMethod("getInt", new Class[] { String.class, Integer.TYPE });
      erH.setAccessible(true);
      erI.setAccessible(true);
      AppMethodBeat.o(93021);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.SystemProperties", localException, "", new Object[0]);
      AppMethodBeat.o(93021);
    }
  }
  
  public static String get(String paramString)
  {
    AppMethodBeat.i(93020);
    try
    {
      paramString = (String)erH.invoke(null, new Object[] { paramString });
      AppMethodBeat.o(93020);
      return paramString;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("MicroMsg.SystemProperties", paramString, "", new Object[0]);
      AppMethodBeat.o(93020);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.e.ad
 * JD-Core Version:    0.7.0.1
 */