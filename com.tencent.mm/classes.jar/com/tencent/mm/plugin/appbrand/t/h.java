package com.tencent.mm.plugin.appbrand.t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class h
{
  private static AtomicInteger tns;
  public HashMap<String, g> tnt;
  
  static
  {
    AppMethodBeat.i(144363);
    tns = new AtomicInteger(1);
    AppMethodBeat.o(144363);
  }
  
  private h()
  {
    AppMethodBeat.i(144359);
    this.tnt = new HashMap();
    AppMethodBeat.o(144359);
  }
  
  public static int cCg()
  {
    AppMethodBeat.i(144360);
    int i = tns.incrementAndGet();
    AppMethodBeat.o(144360);
    return i;
  }
  
  public static h cCm()
  {
    AppMethodBeat.i(144361);
    h localh = a.cCn();
    AppMethodBeat.o(144361);
    return localh;
  }
  
  public final g aec(String paramString)
  {
    AppMethodBeat.i(144362);
    if (this.tnt.containsKey(paramString))
    {
      paramString = (g)this.tnt.get(paramString);
      AppMethodBeat.o(144362);
      return paramString;
    }
    AppMethodBeat.o(144362);
    return null;
  }
  
  static final class a
  {
    private static h toj;
    
    static
    {
      AppMethodBeat.i(144358);
      toj = new h((byte)0);
      AppMethodBeat.o(144358);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.h
 * JD-Core Version:    0.7.0.1
 */