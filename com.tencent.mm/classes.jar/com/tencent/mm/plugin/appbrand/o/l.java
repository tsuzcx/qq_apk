package com.tencent.mm.plugin.appbrand.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.d;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class l
{
  private static AtomicInteger maj;
  public HashMap<String, d> mak;
  
  static
  {
    AppMethodBeat.i(144424);
    maj = new AtomicInteger(1);
    AppMethodBeat.o(144424);
  }
  
  private l()
  {
    AppMethodBeat.i(144420);
    this.mak = new HashMap();
    AppMethodBeat.o(144420);
  }
  
  public static int btP()
  {
    AppMethodBeat.i(144423);
    int i = maj.incrementAndGet();
    AppMethodBeat.o(144423);
    return i;
  }
  
  public static l btY()
  {
    AppMethodBeat.i(144421);
    l locall = a.btZ();
    AppMethodBeat.o(144421);
    return locall;
  }
  
  public final d TC(String paramString)
  {
    AppMethodBeat.i(144422);
    if (this.mak.containsKey(paramString))
    {
      paramString = (d)this.mak.get(paramString);
      AppMethodBeat.o(144422);
      return paramString;
    }
    AppMethodBeat.o(144422);
    return null;
  }
  
  static final class a
  {
    private static l mbe;
    
    static
    {
      AppMethodBeat.i(144419);
      mbe = new l((byte)0);
      AppMethodBeat.o(144419);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.l
 * JD-Core Version:    0.7.0.1
 */