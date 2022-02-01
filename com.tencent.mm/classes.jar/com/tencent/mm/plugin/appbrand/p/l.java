package com.tencent.mm.plugin.appbrand.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.d;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class l
{
  private static AtomicInteger lws;
  public HashMap<String, d> lwt;
  
  static
  {
    AppMethodBeat.i(144424);
    lws = new AtomicInteger(1);
    AppMethodBeat.o(144424);
  }
  
  private l()
  {
    AppMethodBeat.i(144420);
    this.lwt = new HashMap();
    AppMethodBeat.o(144420);
  }
  
  public static int bpf()
  {
    AppMethodBeat.i(144423);
    int i = lws.incrementAndGet();
    AppMethodBeat.o(144423);
    return i;
  }
  
  public static l bpo()
  {
    AppMethodBeat.i(144421);
    l locall = a.bpp();
    AppMethodBeat.o(144421);
    return locall;
  }
  
  public final d Pq(String paramString)
  {
    AppMethodBeat.i(144422);
    if (this.lwt.containsKey(paramString))
    {
      paramString = (d)this.lwt.get(paramString);
      AppMethodBeat.o(144422);
      return paramString;
    }
    AppMethodBeat.o(144422);
    return null;
  }
  
  static final class a
  {
    private static l lxl;
    
    static
    {
      AppMethodBeat.i(144419);
      lxl = new l((byte)0);
      AppMethodBeat.o(144419);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p.l
 * JD-Core Version:    0.7.0.1
 */