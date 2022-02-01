package com.tencent.mm.compatible.deviceinfo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.reflect.Method;

public final class af
{
  private static Class<?> aWK;
  private static Method gcR;
  private static Method gcS;
  
  static
  {
    AppMethodBeat.i(155827);
    aWK = null;
    gcR = null;
    gcS = null;
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      aWK = localClass;
      gcR = localClass.getDeclaredMethod("get", new Class[] { String.class });
      gcS = aWK.getDeclaredMethod("getInt", new Class[] { String.class, Integer.TYPE });
      gcR.setAccessible(true);
      gcS.setAccessible(true);
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
      paramString = (String)gcR.invoke(null, new Object[] { paramString });
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