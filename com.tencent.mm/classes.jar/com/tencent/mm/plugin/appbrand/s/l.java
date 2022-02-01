package com.tencent.mm.plugin.appbrand.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.d;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class l
{
  private static AtomicInteger qiG;
  public HashMap<String, d> qiH;
  
  static
  {
    AppMethodBeat.i(144424);
    qiG = new AtomicInteger(1);
    AppMethodBeat.o(144424);
  }
  
  private l()
  {
    AppMethodBeat.i(144420);
    this.qiH = new HashMap();
    AppMethodBeat.o(144420);
  }
  
  public static int cbN()
  {
    AppMethodBeat.i(144423);
    int i = qiG.incrementAndGet();
    AppMethodBeat.o(144423);
    return i;
  }
  
  public static l cbW()
  {
    AppMethodBeat.i(144421);
    l locall = a.cbX();
    AppMethodBeat.o(144421);
    return locall;
  }
  
  public final d ala(String paramString)
  {
    AppMethodBeat.i(144422);
    if (this.qiH.containsKey(paramString))
    {
      paramString = (d)this.qiH.get(paramString);
      AppMethodBeat.o(144422);
      return paramString;
    }
    AppMethodBeat.o(144422);
    return null;
  }
  
  static final class a
  {
    private static l qjA;
    
    static
    {
      AppMethodBeat.i(144419);
      qjA = new l((byte)0);
      AppMethodBeat.o(144419);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.l
 * JD-Core Version:    0.7.0.1
 */