package com.google.android.gms.common.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class GmsVersionParser
{
  public static final int UNKNOWN = -1;
  private static Pattern zzzy = null;
  
  public static int parseBuildMajorVersion(int paramInt)
  {
    if (paramInt == -1) {
      return -1;
    }
    return paramInt / 100000;
  }
  
  public static long parseBuildNumber(String paramString)
  {
    AppMethodBeat.i(5219);
    if (paramString == null)
    {
      AppMethodBeat.o(5219);
      return -1L;
    }
    paramString = zzdc().matcher(paramString);
    if (paramString.find())
    {
      paramString = paramString.group(2);
      try
      {
        long l = Long.parseLong(paramString);
        AppMethodBeat.o(5219);
        return l;
      }
      catch (NumberFormatException paramString) {}
    }
    AppMethodBeat.o(5219);
    return -1L;
  }
  
  public static int parseBuildType(String paramString)
  {
    AppMethodBeat.i(5221);
    long l = parseVariantCode(paramString);
    if (l == -1L)
    {
      AppMethodBeat.o(5221);
      return -1;
    }
    int i = (int)(l / 10000L);
    AppMethodBeat.o(5221);
    return i;
  }
  
  public static int parseBuildVersion(int paramInt)
  {
    if (paramInt == -1) {
      return -1;
    }
    return paramInt / 1000;
  }
  
  public static int parseScreenDensity(String paramString)
  {
    AppMethodBeat.i(5223);
    long l = parseVariantCode(paramString);
    if (l == -1L)
    {
      AppMethodBeat.o(5223);
      return -1;
    }
    int i = (int)(l % 100L);
    AppMethodBeat.o(5223);
    return i;
  }
  
  public static int parseTargetArchitecture(String paramString)
  {
    AppMethodBeat.i(5222);
    long l = parseVariantCode(paramString);
    if (l == -1L)
    {
      AppMethodBeat.o(5222);
      return -1;
    }
    int i = (int)(l / 100L % 100L);
    AppMethodBeat.o(5222);
    return i;
  }
  
  public static long parseVariantCode(String paramString)
  {
    AppMethodBeat.i(5220);
    if (paramString == null)
    {
      AppMethodBeat.o(5220);
      return -1L;
    }
    paramString = zzdc().matcher(paramString);
    if (paramString.find())
    {
      paramString = paramString.group(1);
      try
      {
        long l = Long.parseLong(paramString);
        AppMethodBeat.o(5220);
        return l;
      }
      catch (NumberFormatException paramString) {}
    }
    AppMethodBeat.o(5220);
    return -1L;
  }
  
  private static Pattern zzdc()
  {
    AppMethodBeat.i(5218);
    if (zzzy == null) {
      zzzy = Pattern.compile("\\((?:eng-)?(\\d+)-(.+?)[-)$]");
    }
    Pattern localPattern = zzzy;
    AppMethodBeat.o(5218);
    return localPattern;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.util.GmsVersionParser
 * JD-Core Version:    0.7.0.1
 */