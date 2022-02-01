package com.tencent.mm.plugin.appbrand.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.d;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class l
{
  private static AtomicInteger lVF;
  public HashMap<String, d> lVG;
  
  static
  {
    AppMethodBeat.i(144424);
    lVF = new AtomicInteger(1);
    AppMethodBeat.o(144424);
  }
  
  private l()
  {
    AppMethodBeat.i(144420);
    this.lVG = new HashMap();
    AppMethodBeat.o(144420);
  }
  
  public static int bte()
  {
    AppMethodBeat.i(144423);
    int i = lVF.incrementAndGet();
    AppMethodBeat.o(144423);
    return i;
  }
  
  public static l btn()
  {
    AppMethodBeat.i(144421);
    l locall = a.bto();
    AppMethodBeat.o(144421);
    return locall;
  }
  
  public final d ST(String paramString)
  {
    AppMethodBeat.i(144422);
    if (this.lVG.containsKey(paramString))
    {
      paramString = (d)this.lVG.get(paramString);
      AppMethodBeat.o(144422);
      return paramString;
    }
    AppMethodBeat.o(144422);
    return null;
  }
  
  static final class a
  {
    private static l lWy;
    
    static
    {
      AppMethodBeat.i(144419);
      lWy = new l((byte)0);
      AppMethodBeat.o(144419);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.l
 * JD-Core Version:    0.7.0.1
 */