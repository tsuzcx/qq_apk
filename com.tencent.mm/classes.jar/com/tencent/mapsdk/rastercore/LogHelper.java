package com.tencent.mapsdk.rastercore;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class LogHelper
{
  private static Boolean DEBUG = Boolean.FALSE;
  private static final String DEFAULT_TAG = "tencentSdk";
  
  public static void d(String paramString)
  {
    AppMethodBeat.i(199837);
    log(null, paramString, 'd');
    AppMethodBeat.o(199837);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(199832);
    log(paramString1, paramString2, 'd');
    AppMethodBeat.o(199832);
  }
  
  public static void e(String paramString)
  {
    AppMethodBeat.i(199834);
    log(null, paramString, 'e');
    AppMethodBeat.o(199834);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(199829);
    log(paramString1, paramString2, 'e');
    AppMethodBeat.o(199829);
  }
  
  public static void i(String paramString)
  {
    AppMethodBeat.i(199836);
    log(null, paramString, 'i');
    AppMethodBeat.o(199836);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(199831);
    log(paramString1, paramString2, 'i');
    AppMethodBeat.o(199831);
  }
  
  public static void log(String paramString)
  {
    AppMethodBeat.i(199839);
    log(null, paramString, 'v');
    AppMethodBeat.o(199839);
  }
  
  private static void log(String paramString1, String paramString2, char paramChar)
  {
    AppMethodBeat.i(199840);
    if (!DEBUG.booleanValue())
    {
      AppMethodBeat.o(199840);
      return;
    }
    TextUtils.isEmpty(paramString1);
    AppMethodBeat.o(199840);
  }
  
  public static void setDebugMode(boolean paramBoolean)
  {
    AppMethodBeat.i(199828);
    DEBUG = Boolean.valueOf(paramBoolean);
    AppMethodBeat.o(199828);
  }
  
  public static void v(String paramString)
  {
    AppMethodBeat.i(199838);
    log(null, paramString, 'v');
    AppMethodBeat.o(199838);
  }
  
  public static void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(199833);
    log(paramString1, paramString2, 'v');
    AppMethodBeat.o(199833);
  }
  
  public static void w(String paramString)
  {
    AppMethodBeat.i(199835);
    log(null, paramString, 'w');
    AppMethodBeat.o(199835);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(199830);
    log(paramString1, paramString2, 'w');
    AppMethodBeat.o(199830);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.LogHelper
 * JD-Core Version:    0.7.0.1
 */