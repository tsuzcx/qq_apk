package com.tencent.mm.dynamicbackground.a;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  private static a fIE;
  private static a fIF;
  
  static
  {
    AppMethodBeat.i(102977);
    c.1 local1 = new c.1();
    fIE = local1;
    fIF = local1;
    AppMethodBeat.o(102977);
  }
  
  public static void a(a parama)
  {
    fIF = parama;
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(102972);
    if (fIF != null)
    {
      paramVarArgs = String.format(paramString2, paramVarArgs);
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      fIF.d(paramString1, paramString2);
    }
    AppMethodBeat.o(102972);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(102975);
    if (fIF != null)
    {
      paramVarArgs = String.format(paramString2, paramVarArgs);
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      fIF.e(paramString1, paramString2);
    }
    AppMethodBeat.o(102975);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(102973);
    if (fIF != null)
    {
      paramVarArgs = String.format(paramString2, paramVarArgs);
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      fIF.i(paramString1, paramString2);
    }
    AppMethodBeat.o(102973);
  }
  
  public static void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(102976);
    if (fIF != null)
    {
      paramVarArgs = String.format(paramString2, paramVarArgs);
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      paramThrowable = paramString2 + "  " + Log.getStackTraceString(paramThrowable);
      fIF.e(paramString1, paramThrowable);
    }
    AppMethodBeat.o(102976);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(102971);
    if (fIF != null)
    {
      paramVarArgs = String.format(paramString2, paramVarArgs);
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      fIF.v(paramString1, paramString2);
    }
    AppMethodBeat.o(102971);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(102974);
    if (fIF != null)
    {
      paramVarArgs = String.format(paramString2, paramVarArgs);
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      fIF.w(paramString1, paramString2);
    }
    AppMethodBeat.o(102974);
  }
  
  public static abstract interface a
  {
    public abstract void d(String paramString1, String paramString2);
    
    public abstract void e(String paramString1, String paramString2);
    
    public abstract void i(String paramString1, String paramString2);
    
    public abstract void v(String paramString1, String paramString2);
    
    public abstract void w(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.dynamicbackground.a.c
 * JD-Core Version:    0.7.0.1
 */