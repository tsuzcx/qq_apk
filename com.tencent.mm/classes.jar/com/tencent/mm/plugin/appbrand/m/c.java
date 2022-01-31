package com.tencent.mm.plugin.appbrand.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class c
{
  private static AtomicInteger isF;
  public HashMap<String, b> hIm;
  
  static
  {
    AppMethodBeat.i(108147);
    isF = new AtomicInteger(1);
    AppMethodBeat.o(108147);
  }
  
  private c()
  {
    AppMethodBeat.i(108143);
    this.hIm = new HashMap();
    AppMethodBeat.o(108143);
  }
  
  public static int aIg()
  {
    AppMethodBeat.i(108144);
    int i = isF.incrementAndGet();
    AppMethodBeat.o(108144);
    return i;
  }
  
  public static c aIh()
  {
    AppMethodBeat.i(108145);
    c localc = a.aIi();
    AppMethodBeat.o(108145);
    return localc;
  }
  
  public final b DP(String paramString)
  {
    AppMethodBeat.i(108146);
    if (this.hIm.containsKey(paramString))
    {
      paramString = (b)this.hIm.get(paramString);
      AppMethodBeat.o(108146);
      return paramString;
    }
    AppMethodBeat.o(108146);
    return null;
  }
  
  static final class a
  {
    private static c isG;
    
    static
    {
      AppMethodBeat.i(108142);
      isG = new c((byte)0);
      AppMethodBeat.o(108142);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.c
 * JD-Core Version:    0.7.0.1
 */