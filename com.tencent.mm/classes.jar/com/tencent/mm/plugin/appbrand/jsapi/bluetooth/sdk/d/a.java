package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static a oLn;
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(144653);
    if (oLn != null)
    {
      String.format(paramString2, paramVarArgs);
      oLn.e(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(144653);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(144655);
    if (oLn != null)
    {
      String.format(paramString2, paramVarArgs);
      oLn.i(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(144655);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(144654);
    if (oLn != null)
    {
      String.format(paramString2, paramVarArgs);
      oLn.w(paramString1, paramString2, paramVarArgs);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a
 * JD-Core Version:    0.7.0.1
 */