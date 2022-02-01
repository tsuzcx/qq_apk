package com.tencent.mapsdk.rastercore;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class LogHelper
{
  private static Boolean DEBUG = Boolean.FALSE;
  private static final String DEFAULT_TAG = "tencentSdk";
  
  public static void d(String paramString)
  {
    AppMethodBeat.i(212526);
    log(null, paramString, 'd');
    AppMethodBeat.o(212526);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(212521);
    log(paramString1, paramString2, 'd');
    AppMethodBeat.o(212521);
  }
  
  public static void e(String paramString)
  {
    AppMethodBeat.i(212523);
    log(null, paramString, 'e');
    AppMethodBeat.o(212523);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(212518);
    log(paramString1, paramString2, 'e');
    AppMethodBeat.o(212518);
  }
  
  public static void i(String paramString)
  {
    AppMethodBeat.i(212525);
    log(null, paramString, 'i');
    AppMethodBeat.o(212525);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(212520);
    log(paramString1, paramString2, 'i');
    AppMethodBeat.o(212520);
  }
  
  public static void log(String paramString)
  {
    AppMethodBeat.i(212528);
    log(null, paramString, 'v');
    AppMethodBeat.o(212528);
  }
  
  private static void log(String paramString1, String paramString2, char paramChar)
  {
    AppMethodBeat.i(212529);
    if (!DEBUG.booleanValue())
    {
      AppMethodBeat.o(212529);
      return;
    }
    TextUtils.isEmpty(paramString1);
    AppMethodBeat.o(212529);
  }
  
  public static void setDebugMode(boolean paramBoolean)
  {
    AppMethodBeat.i(212517);
    DEBUG = Boolean.valueOf(paramBoolean);
    AppMethodBeat.o(212517);
  }
  
  public static void v(String paramString)
  {
    AppMethodBeat.i(212527);
    log(null, paramString, 'v');
    AppMethodBeat.o(212527);
  }
  
  public static void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(212522);
    log(paramString1, paramString2, 'v');
    AppMethodBeat.o(212522);
  }
  
  public static void w(String paramString)
  {
    AppMethodBeat.i(212524);
    log(null, paramString, 'w');
    AppMethodBeat.o(212524);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(212519);
    log(paramString1, paramString2, 'w');
    AppMethodBeat.o(212519);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.LogHelper
 * JD-Core Version:    0.7.0.1
 */