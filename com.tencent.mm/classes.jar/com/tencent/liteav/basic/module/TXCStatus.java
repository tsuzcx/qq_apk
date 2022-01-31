package com.tencent.liteav.basic.module;

public class TXCStatus
{
  public static Object a(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    switch (paramInt)
    {
    default: 
      return null;
    case 1001: 
    case 3003: 
    case 4001: 
    case 5001: 
    case 6002: 
      return Double.valueOf(nativeStatusGetDoubleValue(paramString, paramInt));
    case 2001: 
    case 2002: 
    case 2003: 
    case 2004: 
    case 2005: 
    case 2006: 
    case 2007: 
    case 2008: 
    case 2010: 
    case 2011: 
    case 2012: 
    case 2013: 
    case 2014: 
    case 2015: 
    case 3002: 
    case 4002: 
    case 4003: 
    case 4004: 
    case 5002: 
    case 6001: 
    case 6003: 
    case 6004: 
    case 6005: 
    case 6006: 
    case 6007: 
    case 6008: 
    case 6009: 
    case 7112: 
      return Long.valueOf(nativeStatusGetIntValue(paramString, paramInt));
    case 7001: 
    case 7002: 
    case 7003: 
    case 7004: 
    case 7005: 
    case 7006: 
    case 7007: 
    case 7008: 
    case 7009: 
    case 7010: 
    case 7011: 
    case 7013: 
    case 7016: 
    case 7017: 
    case 7018: 
    case 7020: 
    case 7101: 
    case 7102: 
    case 7103: 
    case 7104: 
    case 7105: 
    case 7107: 
    case 7108: 
    case 7109: 
    case 7111: 
    case 7116: 
    case 7117: 
    case 7118: 
      return Long.valueOf(nativeStatusGetIntValue(paramString, paramInt));
    }
    return nativeStatusGetStrValue(paramString, paramInt);
  }
  
  public static void a(String paramString)
  {
    nativeStatusStartRecord(paramString);
  }
  
  public static boolean a(String paramString, int paramInt, Object paramObject)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
            } while (paramObject == null);
            switch (paramInt)
            {
            default: 
              return false;
            }
          } while (!(paramObject instanceof Double));
          return nativeStatusSetDoubleValue(paramString, paramInt, ((Double)paramObject).doubleValue());
        } while (!(paramObject instanceof Long));
        return nativeStatusSetIntValue(paramString, paramInt, ((Long)paramObject).longValue());
      } while (!(paramObject instanceof Long));
      return nativeStatusSetIntValue(paramString, paramInt, ((Long)paramObject).longValue());
    } while (!(paramObject instanceof String));
    return nativeStatusSetStrValue(paramString, paramInt, (String)paramObject);
  }
  
  public static long b(String paramString, int paramInt)
  {
    paramString = a(paramString, paramInt);
    if ((paramString != null) && ((paramString instanceof Long))) {
      return ((Long)paramString).longValue();
    }
    return 0L;
  }
  
  public static void b(String paramString)
  {
    nativeStatusStopRecord(paramString);
  }
  
  public static String c(String paramString, int paramInt)
  {
    paramString = a(paramString, paramInt);
    if ((paramString != null) && ((paramString instanceof String))) {
      return (String)paramString;
    }
    return "";
  }
  
  public static int d(String paramString, int paramInt)
  {
    paramString = a(paramString, paramInt);
    if ((paramString != null) && ((paramString instanceof Long))) {
      return ((Long)paramString).intValue();
    }
    return 0;
  }
  
  public static double e(String paramString, int paramInt)
  {
    paramString = a(paramString, paramInt);
    if ((paramString != null) && ((paramString instanceof Double))) {
      return ((Double)paramString).doubleValue();
    }
    return 0.0D;
  }
  
  private static native double nativeStatusGetDoubleValue(String paramString, int paramInt);
  
  private static native long nativeStatusGetIntValue(String paramString, int paramInt);
  
  private static native String nativeStatusGetStrValue(String paramString, int paramInt);
  
  private static native boolean nativeStatusSetDoubleValue(String paramString, int paramInt, double paramDouble);
  
  private static native boolean nativeStatusSetIntValue(String paramString, int paramInt, long paramLong);
  
  private static native boolean nativeStatusSetStrValue(String paramString1, int paramInt, String paramString2);
  
  private static native void nativeStatusStartRecord(String paramString);
  
  private static native void nativeStatusStopRecord(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.basic.module.TXCStatus
 * JD-Core Version:    0.7.0.1
 */