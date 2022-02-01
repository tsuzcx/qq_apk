package com.tencent.mm.compatible.deviceinfo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Method;

public final class ag
{
  private static Class<?> aFS;
  private static Method juU;
  private static Method juV;
  
  static
  {
    AppMethodBeat.i(155827);
    aFS = null;
    juU = null;
    juV = null;
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      aFS = localClass;
      juU = localClass.getDeclaredMethod("get", new Class[] { String.class });
      juV = aFS.getDeclaredMethod("getInt", new Class[] { String.class, Integer.TYPE });
      juU.setAccessible(true);
      juV.setAccessible(true);
      AppMethodBeat.o(155827);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SystemProperties", localException, "", new Object[0]);
      AppMethodBeat.o(155827);
    }
  }
  
  public static int df(String paramString)
  {
    AppMethodBeat.i(209969);
    try
    {
      int i = ((Integer)juV.invoke(null, new Object[] { paramString, Integer.valueOf(0) })).intValue();
      AppMethodBeat.o(209969);
      return i;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.SystemProperties", paramString, "", new Object[0]);
      AppMethodBeat.o(209969);
    }
    return 0;
  }
  
  public static String get(String paramString)
  {
    AppMethodBeat.i(155826);
    try
    {
      paramString = (String)juU.invoke(null, new Object[] { paramString });
      AppMethodBeat.o(155826);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.SystemProperties", paramString, "", new Object[0]);
      AppMethodBeat.o(155826);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.ag
 * JD-Core Version:    0.7.0.1
 */