package com.tencent.mapsdk.rastercore;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class LogHelper
{
  private static Boolean DEBUG = Boolean.FALSE;
  private static final String DEFAULT_TAG = "tencentSdk";
  
  public static void d(String paramString)
  {
    AppMethodBeat.i(217185);
    log(null, paramString, 'd');
    AppMethodBeat.o(217185);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(217180);
    log(paramString1, paramString2, 'd');
    AppMethodBeat.o(217180);
  }
  
  public static void e(String paramString)
  {
    AppMethodBeat.i(217182);
    log(null, paramString, 'e');
    AppMethodBeat.o(217182);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(217177);
    log(paramString1, paramString2, 'e');
    AppMethodBeat.o(217177);
  }
  
  public static void i(String paramString)
  {
    AppMethodBeat.i(217184);
    log(null, paramString, 'i');
    AppMethodBeat.o(217184);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(217179);
    log(paramString1, paramString2, 'i');
    AppMethodBeat.o(217179);
  }
  
  public static void log(String paramString)
  {
    AppMethodBeat.i(217187);
    log(null, paramString, 'v');
    AppMethodBeat.o(217187);
  }
  
  private static void log(String paramString1, String paramString2, char paramChar)
  {
    AppMethodBeat.i(217188);
    if (!DEBUG.booleanValue())
    {
      AppMethodBeat.o(217188);
      return;
    }
    TextUtils.isEmpty(paramString1);
    AppMethodBeat.o(217188);
  }
  
  public static void setDebugMode(boolean paramBoolean)
  {
    AppMethodBeat.i(217176);
    DEBUG = Boolean.valueOf(paramBoolean);
    AppMethodBeat.o(217176);
  }
  
  public static void v(String paramString)
  {
    AppMethodBeat.i(217186);
    log(null, paramString, 'v');
    AppMethodBeat.o(217186);
  }
  
  public static void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(217181);
    log(paramString1, paramString2, 'v');
    AppMethodBeat.o(217181);
  }
  
  public static void w(String paramString)
  {
    AppMethodBeat.i(217183);
    log(null, paramString, 'w');
    AppMethodBeat.o(217183);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(217178);
    log(paramString1, paramString2, 'w');
    AppMethodBeat.o(217178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.LogHelper
 * JD-Core Version:    0.7.0.1
 */