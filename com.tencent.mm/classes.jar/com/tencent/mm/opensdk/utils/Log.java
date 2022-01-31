package com.tencent.mm.opensdk.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class Log
{
  private static ILog logImpl;
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(128066);
    if (logImpl == null)
    {
      AppMethodBeat.o(128066);
      return;
    }
    logImpl.d(paramString1, paramString2);
    AppMethodBeat.o(128066);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(128069);
    if (logImpl == null)
    {
      AppMethodBeat.o(128069);
      return;
    }
    logImpl.e(paramString1, paramString2);
    AppMethodBeat.o(128069);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(128067);
    if (logImpl == null)
    {
      AppMethodBeat.o(128067);
      return;
    }
    logImpl.i(paramString1, paramString2);
    AppMethodBeat.o(128067);
  }
  
  public static void setLogImpl(ILog paramILog)
  {
    logImpl = paramILog;
  }
  
  public static void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(128065);
    if (logImpl == null)
    {
      AppMethodBeat.o(128065);
      return;
    }
    logImpl.v(paramString1, paramString2);
    AppMethodBeat.o(128065);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(128068);
    if (logImpl == null)
    {
      AppMethodBeat.o(128068);
      return;
    }
    logImpl.w(paramString1, paramString2);
    AppMethodBeat.o(128068);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.utils.Log
 * JD-Core Version:    0.7.0.1
 */