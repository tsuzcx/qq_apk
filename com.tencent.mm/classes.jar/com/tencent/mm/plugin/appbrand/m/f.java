package com.tencent.mm.plugin.appbrand.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class f
{
  private static AtomicInteger isF;
  public HashMap<String, d> hIm;
  
  static
  {
    AppMethodBeat.i(108166);
    isF = new AtomicInteger(1);
    AppMethodBeat.o(108166);
  }
  
  private f()
  {
    AppMethodBeat.i(108162);
    this.hIm = new HashMap();
    AppMethodBeat.o(108162);
  }
  
  public static int aIg()
  {
    AppMethodBeat.i(108163);
    int i = isF.incrementAndGet();
    AppMethodBeat.o(108163);
    return i;
  }
  
  public static f aIk()
  {
    AppMethodBeat.i(108164);
    f localf = a.aIl();
    AppMethodBeat.o(108164);
    return localf;
  }
  
  public final d DS(String paramString)
  {
    AppMethodBeat.i(108165);
    if (this.hIm.containsKey(paramString))
    {
      paramString = (d)this.hIm.get(paramString);
      AppMethodBeat.o(108165);
      return paramString;
    }
    AppMethodBeat.o(108165);
    return null;
  }
  
  static final class a
  {
    private static f isZ;
    
    static
    {
      AppMethodBeat.i(108161);
      isZ = new f((byte)0);
      AppMethodBeat.o(108161);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.f
 * JD-Core Version:    0.7.0.1
 */