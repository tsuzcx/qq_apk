package com.tencent.mm.compatible.deviceinfo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.reflect.Method;

public final class af
{
  private static Class<?> aLD;
  private static Method fFJ;
  private static Method fFK;
  
  static
  {
    AppMethodBeat.i(155827);
    aLD = null;
    fFJ = null;
    fFK = null;
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      aLD = localClass;
      fFJ = localClass.getDeclaredMethod("get", new Class[] { String.class });
      fFK = aLD.getDeclaredMethod("getInt", new Class[] { String.class, Integer.TYPE });
      fFJ.setAccessible(true);
      fFK.setAccessible(true);
      AppMethodBeat.o(155827);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.SystemProperties", localException, "", new Object[0]);
      AppMethodBeat.o(155827);
    }
  }
  
  public static String get(String paramString)
  {
    AppMethodBeat.i(155826);
    try
    {
      paramString = (String)fFJ.invoke(null, new Object[] { paramString });
      AppMethodBeat.o(155826);
      return paramString;
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("MicroMsg.SystemProperties", paramString, "", new Object[0]);
      AppMethodBeat.o(155826);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.af
 * JD-Core Version:    0.7.0.1
 */