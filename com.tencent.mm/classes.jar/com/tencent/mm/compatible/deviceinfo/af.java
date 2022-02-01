package com.tencent.mm.compatible.deviceinfo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.reflect.Method;

public final class af
{
  private static Class<?> aWK;
  private static Method geZ;
  private static Method gfa;
  
  static
  {
    AppMethodBeat.i(155827);
    aWK = null;
    geZ = null;
    gfa = null;
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      aWK = localClass;
      geZ = localClass.getDeclaredMethod("get", new Class[] { String.class });
      gfa = aWK.getDeclaredMethod("getInt", new Class[] { String.class, Integer.TYPE });
      geZ.setAccessible(true);
      gfa.setAccessible(true);
      AppMethodBeat.o(155827);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.SystemProperties", localException, "", new Object[0]);
      AppMethodBeat.o(155827);
    }
  }
  
  public static String get(String paramString)
  {
    AppMethodBeat.i(155826);
    try
    {
      paramString = (String)geZ.invoke(null, new Object[] { paramString });
      AppMethodBeat.o(155826);
      return paramString;
    }
    catch (Exception paramString)
    {
      ae.printErrStackTrace("MicroMsg.SystemProperties", paramString, "", new Object[0]);
      AppMethodBeat.o(155826);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.af
 * JD-Core Version:    0.7.0.1
 */