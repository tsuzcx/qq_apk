package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static boolean rPg = false;
  private static a rPh;
  
  public static void a(a parama)
  {
    rPh = parama;
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(144653);
    if (rPh != null)
    {
      String.format(paramString2, paramVarArgs);
      rPh.e(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(144653);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(144655);
    if (rPh != null)
    {
      String.format(paramString2, paramVarArgs);
      rPh.i(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(144655);
  }
  
  public static void jj(boolean paramBoolean)
  {
    rPg = paramBoolean;
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(144654);
    if (rPh != null)
    {
      String.format(paramString2, paramVarArgs);
      rPh.w(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(144654);
  }
  
  public static abstract interface a
  {
    public abstract void e(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void i(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void w(String paramString1, String paramString2, Object... paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a
 * JD-Core Version:    0.7.0.1
 */