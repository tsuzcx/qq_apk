package com.tencent.mm.hardcoder;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  private static a mxc = null;
  
  public static void a(a parama)
  {
    mxc = parama;
  }
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(62475);
    if ((HardCoderJNI.isHcDebug()) && (mxc != null)) {
      mxc.d(paramString1, paramString2);
    }
    AppMethodBeat.o(62475);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(62476);
    if (mxc != null) {
      mxc.e(paramString1, paramString2);
    }
    AppMethodBeat.o(62476);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(62474);
    if (mxc != null) {
      mxc.i(paramString1, paramString2);
    }
    AppMethodBeat.o(62474);
  }
  
  public static void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(62477);
    if (mxc != null) {
      mxc.printErrStackTrace(paramString1, paramThrowable, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(62477);
  }
  
  public static abstract interface a
  {
    public abstract void d(String paramString1, String paramString2);
    
    public abstract void e(String paramString1, String paramString2);
    
    public abstract void i(String paramString1, String paramString2);
    
    public abstract void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.hardcoder.d
 * JD-Core Version:    0.7.0.1
 */