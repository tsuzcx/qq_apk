package com.tencent.liteav.basic.module;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TXCStatus
{
  public static long a(String paramString, int paramInt)
  {
    AppMethodBeat.i(146471);
    long l = a(paramString, paramInt, 0);
    AppMethodBeat.o(146471);
    return l;
  }
  
  public static long a(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(146475);
    long l = nativeStatusGetIntValue(paramString, paramInt1, paramInt2);
    AppMethodBeat.o(146475);
    return l;
  }
  
  public static void a(String paramString)
  {
    AppMethodBeat.i(66068);
    nativeStatusStartRecord(paramString);
    AppMethodBeat.o(66068);
  }
  
  public static boolean a(String paramString, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(146470);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(146470);
      return false;
    }
    if (paramObject == null)
    {
      AppMethodBeat.o(146470);
      return false;
    }
    if ((paramObject instanceof Double))
    {
      bool = nativeStatusSetDoubleValue(paramString, paramInt1, paramInt2, ((Double)paramObject).doubleValue());
      AppMethodBeat.o(146470);
      return bool;
    }
    if ((paramObject instanceof String))
    {
      bool = nativeStatusSetStrValue(paramString, paramInt1, paramInt2, (String)paramObject);
      AppMethodBeat.o(146470);
      return bool;
    }
    if ((paramObject instanceof Long))
    {
      bool = nativeStatusSetIntValue(paramString, paramInt1, paramInt2, ((Long)paramObject).longValue());
      AppMethodBeat.o(146470);
      return bool;
    }
    boolean bool = nativeStatusSetIntValue(paramString, paramInt1, paramInt2, ((Integer)paramObject).intValue());
    AppMethodBeat.o(146470);
    return bool;
  }
  
  public static boolean a(String paramString, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(66070);
    boolean bool = a(paramString, paramInt, 0, paramObject);
    AppMethodBeat.o(66070);
    return bool;
  }
  
  public static String b(String paramString, int paramInt)
  {
    AppMethodBeat.i(146472);
    paramString = b(paramString, paramInt, 0);
    AppMethodBeat.o(146472);
    return paramString;
  }
  
  public static String b(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(146476);
    paramString = nativeStatusGetStrValue(paramString, paramInt1, paramInt2);
    AppMethodBeat.o(146476);
    return paramString;
  }
  
  public static void b(String paramString)
  {
    AppMethodBeat.i(66069);
    nativeStatusStopRecord(paramString);
    AppMethodBeat.o(66069);
  }
  
  public static int c(String paramString, int paramInt)
  {
    AppMethodBeat.i(146473);
    paramInt = c(paramString, paramInt, 0);
    AppMethodBeat.o(146473);
    return paramInt;
  }
  
  public static int c(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(146477);
    paramInt1 = (int)nativeStatusGetIntValue(paramString, paramInt1, paramInt2);
    AppMethodBeat.o(146477);
    return paramInt1;
  }
  
  public static double d(String paramString, int paramInt)
  {
    AppMethodBeat.i(146474);
    double d = d(paramString, paramInt, 0);
    AppMethodBeat.o(146474);
    return d;
  }
  
  public static double d(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(146478);
    double d = nativeStatusGetDoubleValue(paramString, paramInt1, paramInt2);
    AppMethodBeat.o(146478);
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