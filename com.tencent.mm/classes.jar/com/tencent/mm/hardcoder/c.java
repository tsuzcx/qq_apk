package com.tencent.mm.hardcoder;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  private static a eCo = null;
  
  public static void a(a parama)
  {
    eCo = parama;
  }
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(93920);
    if ((HardCoderJNI.isHcDebug()) && (eCo != null)) {
      eCo.d(paramString1, paramString2);
    }
    AppMethodBeat.o(93920);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(93921);
    if (eCo != null) {
      eCo.e(paramString1, paramString2);
    }
    AppMethodBeat.o(93921);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(93919);
    if (eCo != null) {
      eCo.i(paramString1, paramString2);
    }
    AppMethodBeat.o(93919);
  }
  
  public static void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(93922);
    if (eCo != null) {
      eCo.printErrStackTrace(paramString1, paramThrowable, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(93922);
  }
  
  public static abstract interface a
  {
    public abstract void d(String paramString1, String paramString2);
    
    public abstract void e(String paramString1, String paramString2);
    
    public abstract void i(String paramString1, String paramString2);
    
    public abstract void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.hardcoder.c
 * JD-Core Version:    0.7.0.1
 */