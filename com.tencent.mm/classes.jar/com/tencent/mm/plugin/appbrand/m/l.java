package com.tencent.mm.plugin.appbrand.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.d;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class l
{
  private static AtomicInteger isF;
  public HashMap<String, d> hIm;
  
  static
  {
    AppMethodBeat.i(108242);
    isF = new AtomicInteger(1);
    AppMethodBeat.o(108242);
  }
  
  private l()
  {
    AppMethodBeat.i(108238);
    this.hIm = new HashMap();
    AppMethodBeat.o(108238);
  }
  
  public static int aIg()
  {
    AppMethodBeat.i(108241);
    int i = isF.incrementAndGet();
    AppMethodBeat.o(108241);
    return i;
  }
  
  public static l aIp()
  {
    AppMethodBeat.i(108239);
    l locall = l.a.aIq();
    AppMethodBeat.o(108239);
    return locall;
  }
  
  public final d DZ(String paramString)
  {
    AppMethodBeat.i(108240);
    if (this.hIm.containsKey(paramString))
    {
      paramString = (d)this.hIm.get(paramString);
      AppMethodBeat.o(108240);
      return paramString;
    }
    AppMethodBeat.o(108240);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.l
 * JD-Core Version:    0.7.0.1
 */