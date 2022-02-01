package com.tencent.mm.opensdk.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class Log
{
  private static ILog logImpl;
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(3751);
    ILog localILog = logImpl;
    if (localILog != null) {
      localILog.d(paramString1, paramString2);
    }
    AppMethodBeat.o(3751);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(3754);
    ILog localILog = logImpl;
    if (localILog != null) {
      localILog.e(paramString1, paramString2);
    }
    AppMethodBeat.o(3754);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(3752);
    ILog localILog = logImpl;
    if (localILog != null) {
      localILog.i(paramString1, paramString2);
    }
    AppMethodBeat.o(3752);
  }
  
  public static void setLogImpl(ILog paramILog)
  {
    logImpl = paramILog;
  }
  
  public static void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(3750);
    ILog localILog = logImpl;
    if (localILog != null) {
      localILog.v(paramString1, paramString2);
    }
    AppMethodBeat.o(3750);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(3753);
    ILog localILog = logImpl;
    if (localILog != null) {
      localILog.w(paramString1, paramString2);
    }
    AppMethodBeat.o(3753);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.opensdk.utils.Log
 * JD-Core Version:    0.7.0.1
 */