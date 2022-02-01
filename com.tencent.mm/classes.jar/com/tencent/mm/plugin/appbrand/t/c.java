package com.tencent.mm.plugin.appbrand.t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class c
{
  private static AtomicInteger tns;
  public HashMap<String, b> tnt;
  
  static
  {
    AppMethodBeat.i(144315);
    tns = new AtomicInteger(1);
    AppMethodBeat.o(144315);
  }
  
  private c()
  {
    AppMethodBeat.i(144311);
    this.tnt = new HashMap();
    AppMethodBeat.o(144311);
  }
  
  public static int cCg()
  {
    AppMethodBeat.i(144312);
    int i = tns.incrementAndGet();
    AppMethodBeat.o(144312);
    return i;
  }
  
  public static c cCh()
  {
    AppMethodBeat.i(144313);
    c localc = a.cCi();
    AppMethodBeat.o(144313);
    return localc;
  }
  
  public final b adW(String paramString)
  {
    AppMethodBeat.i(144314);
    if (this.tnt.containsKey(paramString))
    {
      paramString = (b)this.tnt.get(paramString);
      AppMethodBeat.o(144314);
      return paramString;
    }
    AppMethodBeat.o(144314);
    return null;
  }
  
  static final class a
  {
    private static c tnu;
    
    static
    {
      AppMethodBeat.i(144310);
      tnu = new c((byte)0);
      AppMethodBeat.o(144310);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.c
 * JD-Core Version:    0.7.0.1
 */