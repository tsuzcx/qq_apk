package com.tencent.mm.compatible.deviceinfo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Method;

public final class ag
{
  private static Class<?> clazz;
  private static Method lYl;
  private static Method lYm;
  
  static
  {
    AppMethodBeat.i(155827);
    clazz = null;
    lYl = null;
    lYm = null;
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      clazz = localClass;
      lYl = localClass.getDeclaredMethod("get", new Class[] { String.class });
      lYm = clazz.getDeclaredMethod("getInt", new Class[] { String.class, Integer.TYPE });
      lYl.setAccessible(true);
      lYm.setAccessible(true);
      AppMethodBeat.o(155827);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SystemProperties", localException, "", new Object[0]);
      AppMethodBeat.o(155827);
    }
  }
  
  public static int ew(String paramString)
  {
    AppMethodBeat.i(240854);
    try
    {
      int i = ((Integer)lYm.invoke(null, new Object[] { paramString, Integer.valueOf(0) })).intValue();
      AppMethodBeat.o(240854);
      return i;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.SystemProperties", paramString, "", new Object[0]);
      AppMethodBeat.o(240854);
    }
    return 0;
  }
  
  public static String get(String paramString)
  {
    AppMethodBeat.i(155826);
    try
    {
      paramString = (String)lYl.invoke(null, new Object[] { paramString });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.ag
 * JD-Core Version:    0.7.0.1
 */