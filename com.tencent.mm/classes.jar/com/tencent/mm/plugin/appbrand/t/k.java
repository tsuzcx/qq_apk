package com.tencent.mm.plugin.appbrand.t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.d;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class k
{
  private static AtomicInteger tns;
  public HashMap<String, d> tnt;
  
  static
  {
    AppMethodBeat.i(144424);
    tns = new AtomicInteger(1);
    AppMethodBeat.o(144424);
  }
  
  private k()
  {
    AppMethodBeat.i(144420);
    this.tnt = new HashMap();
    AppMethodBeat.o(144420);
  }
  
  public static int cCg()
  {
    AppMethodBeat.i(144423);
    int i = tns.incrementAndGet();
    AppMethodBeat.o(144423);
    return i;
  }
  
  public static k cCp()
  {
    AppMethodBeat.i(144421);
    k localk = a.cCq();
    AppMethodBeat.o(144421);
    return localk;
  }
  
  public final d aeh(String paramString)
  {
    AppMethodBeat.i(144422);
    if (this.tnt.containsKey(paramString))
    {
      paramString = (d)this.tnt.get(paramString);
      AppMethodBeat.o(144422);
      return paramString;
    }
    AppMethodBeat.o(144422);
    return null;
  }
  
  static final class a
  {
    private static k toq;
    
    static
    {
      AppMethodBeat.i(144419);
      toq = new k((byte)0);
      AppMethodBeat.o(144419);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.k
 * JD-Core Version:    0.7.0.1
 */