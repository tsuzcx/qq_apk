package com.tencent.mapsdk.rastercore;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class LogHelper
{
  private static Boolean DEBUG = Boolean.FALSE;
  private static final String DEFAULT_TAG = "tencentSdk";
  
  public static void d(String paramString)
  {
    AppMethodBeat.i(205775);
    log(null, paramString, 'd');
    AppMethodBeat.o(205775);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(205770);
    log(paramString1, paramString2, 'd');
    AppMethodBeat.o(205770);
  }
  
  public static void e(String paramString)
  {
    AppMethodBeat.i(205772);
    log(null, paramString, 'e');
    AppMethodBeat.o(205772);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(205767);
    log(paramString1, paramString2, 'e');
    AppMethodBeat.o(205767);
  }
  
  public static void i(String paramString)
  {
    AppMethodBeat.i(205774);
    log(null, paramString, 'i');
    AppMethodBeat.o(205774);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(205769);
    log(paramString1, paramString2, 'i');
    AppMethodBeat.o(205769);
  }
  
  public static void log(String paramString)
  {
    AppMethodBeat.i(205777);
    log(null, paramString, 'v');
    AppMethodBeat.o(205777);
  }
  
  private static void log(String paramString1, String paramString2, char paramChar)
  {
    AppMethodBeat.i(205778);
    if (!DEBUG.booleanValue())
    {
      AppMethodBeat.o(205778);
      return;
    }
    TextUtils.isEmpty(paramString1);
    AppMethodBeat.o(205778);
  }
  
  public static void setDebugMode(boolean paramBoolean)
  {
    AppMethodBeat.i(205766);
    DEBUG = Boolean.valueOf(paramBoolean);
    AppMethodBeat.o(205766);
  }
  
  public static void v(String paramString)
  {
    AppMethodBeat.i(205776);
    log(null, paramString, 'v');
    AppMethodBeat.o(205776);
  }
  
  public static void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(205771);
    log(paramString1, paramString2, 'v');
    AppMethodBeat.o(205771);
  }
  
  public static void w(String paramString)
  {
    AppMethodBeat.i(205773);
    log(null, paramString, 'w');
    AppMethodBeat.o(205773);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(205768);
    log(paramString1, paramString2, 'w');
    AppMethodBeat.o(205768);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.LogHelper
 * JD-Core Version:    0.7.0.1
 */