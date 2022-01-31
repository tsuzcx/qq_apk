package com.tencent.mm.modelsfs;

import com.tencent.mm.sdk.platformtools.bk;

public final class f
{
  public static boolean mT(String paramString)
  {
    return paramString.lastIndexOf(";?enc=") > 0;
  }
  
  public static String mU(String paramString)
  {
    int i = paramString.lastIndexOf(";?enc=");
    String str = paramString;
    if (i > 0) {
      str = paramString.substring(0, i);
    }
    return str;
  }
  
  public static long mV(String paramString)
  {
    int i = paramString.lastIndexOf(";?enc=");
    if (i > 0) {
      return bk.ZS(paramString.substring(i + 6));
    }
    return 0L;
  }
  
  public static String mW(String paramString)
  {
    int i = paramString.lastIndexOf(";?enc=");
    if (i > 0) {
      return paramString.substring(i + 6).trim();
    }
    return "";
  }
  
  public static String q(String paramString, long paramLong)
  {
    if (paramLong == 0L) {
      return String.format(paramString + ";?enc=%d", new Object[] { Long.valueOf(314159265L) });
    }
    return String.format(paramString + ";?enc=%d", new Object[] { Long.valueOf(paramLong) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsfs.f
 * JD-Core Version:    0.7.0.1
 */