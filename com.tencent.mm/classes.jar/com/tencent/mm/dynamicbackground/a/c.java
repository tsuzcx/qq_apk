package com.tencent.mm.dynamicbackground.a;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  private static a mbD;
  private static a mbE;
  
  static
  {
    AppMethodBeat.i(102977);
    c.1 local1 = new c.1();
    mbD = local1;
    mbE = local1;
    AppMethodBeat.o(102977);
  }
  
  public static void a(a parama)
  {
    mbE = parama;
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(102975);
    if (mbE != null)
    {
      paramVarArgs = String.format(paramString2, paramVarArgs);
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      mbE.e(paramString1, paramString2);
    }
    AppMethodBeat.o(102975);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(102973);
    if (mbE != null)
    {
      paramVarArgs = String.format(paramString2, paramVarArgs);
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      mbE.i(paramString1, paramString2);
    }
    AppMethodBeat.o(102973);
  }
  
  public static void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(102976);
    if (mbE != null)
    {
      paramVarArgs = String.format(paramString2, paramVarArgs);
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      paramThrowable = paramString2 + "  " + Log.getStackTraceString(paramThrowable);
      mbE.e(paramString1, paramThrowable);
    }
    AppMethodBeat.o(102976);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(102971);
    if (mbE != null)
    {
      paramVarArgs = String.format(paramString2, paramVarArgs);
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      mbE.v(paramString1, paramString2);
    }
    AppMethodBeat.o(102971);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(102974);
    if (mbE != null)
    {
      paramVarArgs = String.format(paramString2, paramVarArgs);
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      mbE.w(paramString1, paramString2);
    }
    AppMethodBeat.o(102974);
  }
  
  public static abstract interface a
  {
    public abstract void e(String paramString1, String paramString2);
    
    public abstract void i(String paramString1, String paramString2);
    
    public abstract void v(String paramString1, String paramString2);
    
    public abstract void w(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.dynamicbackground.a.c
 * JD-Core Version:    0.7.0.1
 */