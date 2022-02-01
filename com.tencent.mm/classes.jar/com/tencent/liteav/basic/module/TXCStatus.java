package com.tencent.liteav.basic.module;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TXCStatus
{
  public static long a(String paramString, int paramInt)
  {
    AppMethodBeat.i(14440);
    long l = a(paramString, paramInt, 0);
    AppMethodBeat.o(14440);
    return l;
  }
  
  public static long a(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(14444);
    long l = nativeStatusGetIntValue(paramString, paramInt1, paramInt2);
    AppMethodBeat.o(14444);
    return l;
  }
  
  public static void a(String paramString)
  {
    AppMethodBeat.i(14436);
    nativeStatusStartRecord(paramString);
    AppMethodBeat.o(14436);
  }
  
  public static boolean a(String paramString, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(14439);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(14439);
      return false;
    }
    if (paramObject == null)
    {
      AppMethodBeat.o(14439);
      return false;
    }
    if ((paramObject instanceof Double))
    {
      bool = nativeStatusSetDoubleValue(paramString, paramInt1, paramInt2, ((Double)paramObject).doubleValue());
      AppMethodBeat.o(14439);
      return bool;
    }
    if ((paramObject instanceof String))
    {
      bool = nativeStatusSetStrValue(paramString, paramInt1, paramInt2, (String)paramObject);
      AppMethodBeat.o(14439);
      return bool;
    }
    if ((paramObject instanceof Long))
    {
      bool = nativeStatusSetIntValue(paramString, paramInt1, paramInt2, ((Long)paramObject).longValue());
      AppMethodBeat.o(14439);
      return bool;
    }
    boolean bool = nativeStatusSetIntValue(paramString, paramInt1, paramInt2, ((Integer)paramObject).intValue());
    AppMethodBeat.o(14439);
    return bool;
  }
  
  public static boolean a(String paramString, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(14438);
    boolean bool = a(paramString, paramInt, 0, paramObject);
    AppMethodBeat.o(14438);
    return bool;
  }
  
  public static String b(String paramString, int paramInt)
  {
    AppMethodBeat.i(14441);
    paramString = b(paramString, paramInt, 0);
    AppMethodBeat.o(14441);
    return paramString;
  }
  
  public static String b(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(14445);
    paramString = nativeStatusGetStrValue(paramString, paramInt1, paramInt2);
    AppMethodBeat.o(14445);
    return paramString;
  }
  
  public static void b(String paramString)
  {
    AppMethodBeat.i(14437);
    nativeStatusStopRecord(paramString);
    AppMethodBeat.o(14437);
  }
  
  public static int c(String paramString, int paramInt)
  {
    AppMethodBeat.i(14442);
    paramInt = c(paramString, paramInt, 0);
    AppMethodBeat.o(14442);
    return paramInt;
  }
  
  public static int c(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(14446);
    paramInt1 = (int)nativeStatusGetIntValue(paramString, paramInt1, paramInt2);
    AppMethodBeat.o(14446);
    return paramInt1;
  }
  
  public static double d(String paramString, int paramInt)
  {
    AppMethodBeat.i(14443);
    double d = d(paramString, paramInt, 0);
    AppMethodBeat.o(14443);
    return d;
  }
  
  public static double d(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(14447);
    double d = nativeStatusGetDoubleValue(paramString, paramInt1, paramInt2);
    AppMethodBeat.o(14447);
    return d;
  }
  
  private static native double nativeStatusGetDoubleValue(String paramString, int paramInt1, int paramInt2);
  
  private static native long nativeStatusGetIntValue(String paramString, int paramInt1, int paramInt2);
  
  private static native String nativeStatusGetStrValue(String paramString, int paramInt1, int paramInt2);
  
  private static native boolean nativeStatusSetDoubleValue(String paramString, int paramInt1, int paramInt2, double paramDouble);
  
  private static native boolean nativeStatusSetIntValue(String paramString, int paramInt1, int paramInt2, long paramLong);
  
  private static native boolean nativeStatusSetStrValue(String paramString1, int paramInt1, int paramInt2, String paramString2);
  
  private static native void nativeStatusStartRecord(String paramString);
  
  private static native void nativeStatusStopRecord(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.basic.module.TXCStatus
 * JD-Core Version:    0.7.0.1
 */