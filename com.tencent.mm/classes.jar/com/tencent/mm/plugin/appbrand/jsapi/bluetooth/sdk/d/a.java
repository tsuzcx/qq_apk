package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static a hIj;
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(94344);
    if (hIj != null)
    {
      String.format(paramString2, paramVarArgs);
      hIj.d(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(94344);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(94341);
    if (hIj != null)
    {
      String.format(paramString2, paramVarArgs);
      hIj.e(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(94341);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(94343);
    if (hIj != null)
    {
      String.format(paramString2, paramVarArgs);
      hIj.i(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(94343);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(94342);
    if (hIj != null)
    {
      String.format(paramString2, paramVarArgs);
      hIj.w(paramString1, paramString2, paramVarArgs);
    }
    AppMethodBeat.o(94342);
  }
  
  public static abstract interface a
  {
    public abstract void d(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void e(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void i(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void w(String paramString1, String paramString2, Object... paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a
 * JD-Core Version:    0.7.0.1
 */