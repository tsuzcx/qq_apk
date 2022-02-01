package com.tencent.mapsdk.rastercore;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class LogHelper
{
  private static Boolean DEBUG = Boolean.FALSE;
  private static final String DEFAULT_TAG = "tencentSdk";
  
  public static void d(String paramString)
  {
    AppMethodBeat.i(221419);
    log(null, paramString, 'd');
    AppMethodBeat.o(221419);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(221386);
    log(paramString1, paramString2, 'd');
    AppMethodBeat.o(221386);
  }
  
  public static void e(String paramString)
  {
    AppMethodBeat.i(221401);
    log(null, paramString, 'e');
    AppMethodBeat.o(221401);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(221366);
    log(paramString1, paramString2, 'e');
    AppMethodBeat.o(221366);
  }
  
  public static void i(String paramString)
  {
    AppMethodBeat.i(221413);
    log(null, paramString, 'i');
    AppMethodBeat.o(221413);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(221380);
    log(paramString1, paramString2, 'i');
    AppMethodBeat.o(221380);
  }
  
  public static void log(String paramString)
  {
    AppMethodBeat.i(221432);
    log(null, paramString, 'v');
    AppMethodBeat.o(221432);
  }
  
  private static void log(String paramString1, String paramString2, char paramChar)
  {
    AppMethodBeat.i(221441);
    if (!DEBUG.booleanValue())
    {
      AppMethodBeat.o(221441);
      return;
    }
    TextUtils.isEmpty(paramString1);
    AppMethodBeat.o(221441);
  }
  
  public static void setDebugMode(boolean paramBoolean)
  {
    AppMethodBeat.i(221363);
    DEBUG = Boolean.valueOf(paramBoolean);
    AppMethodBeat.o(221363);
  }
  
  public static void v(String paramString)
  {
    AppMethodBeat.i(221425);
    log(null, paramString, 'v');
    AppMethodBeat.o(221425);
  }
  
  public static void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(221393);
    log(paramString1, paramString2, 'v');
    AppMethodBeat.o(221393);
  }
  
  public static void w(String paramString)
  {
    AppMethodBeat.i(221408);
    log(null, paramString, 'w');
    AppMethodBeat.o(221408);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(221374);
    log(paramString1, paramString2, 'w');
    AppMethodBeat.o(221374);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.LogHelper
 * JD-Core Version:    0.7.0.1
 */