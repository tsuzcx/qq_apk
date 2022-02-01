package com.tencent.mapsdk.rastercore;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class LogHelper
{
  private static Boolean DEBUG = Boolean.FALSE;
  private static final String DEFAULT_TAG = "tencentSdk";
  
  public static void d(String paramString)
  {
    AppMethodBeat.i(187159);
    log(null, paramString, 'd');
    AppMethodBeat.o(187159);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(187140);
    log(paramString1, paramString2, 'd');
    AppMethodBeat.o(187140);
  }
  
  public static void e(String paramString)
  {
    AppMethodBeat.i(187150);
    log(null, paramString, 'e');
    AppMethodBeat.o(187150);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(187131);
    log(paramString1, paramString2, 'e');
    AppMethodBeat.o(187131);
  }
  
  public static void i(String paramString)
  {
    AppMethodBeat.i(187155);
    log(null, paramString, 'i');
    AppMethodBeat.o(187155);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(187133);
    log(paramString1, paramString2, 'i');
    AppMethodBeat.o(187133);
  }
  
  public static void log(String paramString)
  {
    AppMethodBeat.i(187165);
    log(null, paramString, 'v');
    AppMethodBeat.o(187165);
  }
  
  private static void log(String paramString1, String paramString2, char paramChar)
  {
    AppMethodBeat.i(187169);
    if (!DEBUG.booleanValue())
    {
      AppMethodBeat.o(187169);
      return;
    }
    TextUtils.isEmpty(paramString1);
    AppMethodBeat.o(187169);
  }
  
  public static void setDebugMode(boolean paramBoolean)
  {
    AppMethodBeat.i(187126);
    DEBUG = Boolean.valueOf(paramBoolean);
    AppMethodBeat.o(187126);
  }
  
  public static void v(String paramString)
  {
    AppMethodBeat.i(187163);
    log(null, paramString, 'v');
    AppMethodBeat.o(187163);
  }
  
  public static void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(187141);
    log(paramString1, paramString2, 'v');
    AppMethodBeat.o(187141);
  }
  
  public static void w(String paramString)
  {
    AppMethodBeat.i(187153);
    log(null, paramString, 'w');
    AppMethodBeat.o(187153);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(187132);
    log(paramString1, paramString2, 'w');
    AppMethodBeat.o(187132);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.LogHelper
 * JD-Core Version:    0.7.0.1
 */