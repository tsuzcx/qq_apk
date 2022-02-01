package com.tencent.mm.plugin.appbrand.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class c
{
  private static AtomicInteger lws;
  public HashMap<String, b> lwt;
  
  static
  {
    AppMethodBeat.i(144315);
    lws = new AtomicInteger(1);
    AppMethodBeat.o(144315);
  }
  
  private c()
  {
    AppMethodBeat.i(144311);
    this.lwt = new HashMap();
    AppMethodBeat.o(144311);
  }
  
  public static int bpf()
  {
    AppMethodBeat.i(144312);
    int i = lws.incrementAndGet();
    AppMethodBeat.o(144312);
    return i;
  }
  
  public static c bpg()
  {
    AppMethodBeat.i(144313);
    c localc = a.bph();
    AppMethodBeat.o(144313);
    return localc;
  }
  
  public final b Pg(String paramString)
  {
    AppMethodBeat.i(144314);
    if (this.lwt.containsKey(paramString))
    {
      paramString = (b)this.lwt.get(paramString);
      AppMethodBeat.o(144314);
      return paramString;
    }
    AppMethodBeat.o(144314);
    return null;
  }
  
  static final class a
  {
    private static c lwu;
    
    static
    {
      AppMethodBeat.i(144310);
      lwu = new c((byte)0);
      AppMethodBeat.o(144310);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p.c
 * JD-Core Version:    0.7.0.1
 */