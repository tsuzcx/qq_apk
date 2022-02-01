package com.tencent.mm.compatible.deviceinfo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.reflect.Method;

public final class af
{
  private static Class<?> aMt;
  private static Method fJq;
  private static Method fJr;
  
  static
  {
    AppMethodBeat.i(155827);
    aMt = null;
    fJq = null;
    fJr = null;
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      aMt = localClass;
      fJq = localClass.getDeclaredMethod("get", new Class[] { String.class });
      fJr = aMt.getDeclaredMethod("getInt", new Class[] { String.class, Integer.TYPE });
      fJq.setAccessible(true);
      fJr.setAccessible(true);
      AppMethodBeat.o(155827);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.SystemProperties", localException, "", new Object[0]);
      AppMethodBeat.o(155827);
    }
  }
  
  public static String get(String paramString)
  {
    AppMethodBeat.i(155826);
    try
    {
      paramString = (String)fJq.invoke(null, new Object[] { paramString });
      AppMethodBeat.o(155826);
      return paramString;
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("MicroMsg.SystemProperties", paramString, "", new Object[0]);
      AppMethodBeat.o(155826);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.af
 * JD-Core Version:    0.7.0.1
 */