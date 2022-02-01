package com.tencent.mm.dynamicbackground.a;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  private static a fMk;
  private static a fMl;
  
  static
  {
    AppMethodBeat.i(102977);
    a local1 = new a()
    {
      public final void d(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void i(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void v(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void w(String paramAnonymousString1, String paramAnonymousString2) {}
    };
    fMk = local1;
    fMl = local1;
    AppMethodBeat.o(102977);
  }
  
  public static void a(a parama)
  {
    fMl = parama;
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(102972);
    if (fMl != null)
    {
      paramVarArgs = String.format(paramString2, paramVarArgs);
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      fMl.d(paramString1, paramString2);
    }
    AppMethodBeat.o(102972);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(102975);
    if (fMl != null)
    {
      paramVarArgs = String.format(paramString2, paramVarArgs);
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      fMl.e(paramString1, paramString2);
    }
    AppMethodBeat.o(102975);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(102973);
    if (fMl != null)
    {
      paramVarArgs = String.format(paramString2, paramVarArgs);
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      fMl.i(paramString1, paramString2);
    }
    AppMethodBeat.o(102973);
  }
  
  public static void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(102976);
    if (fMl != null)
    {
      paramVarArgs = String.format(paramString2, paramVarArgs);
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      paramThrowable = paramString2 + "  " + Log.getStackTraceString(paramThrowable);
      fMl.e(paramString1, paramThrowable);
    }
    AppMethodBeat.o(102976);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(102971);
    if (fMl != null)
    {
      paramVarArgs = String.format(paramString2, paramVarArgs);
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      fMl.v(paramString1, paramString2);
    }
    AppMethodBeat.o(102971);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(102974);
    if (fMl != null)
    {
      paramVarArgs = String.format(paramString2, paramVarArgs);
      paramString2 = paramVarArgs;
      if (paramVarArgs == null) {
        paramString2 = "";
      }
      fMl.w(paramString1, paramString2);
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