package com.tencent.mm.plugin.appbrand.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.d;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class l
{
  private static AtomicInteger nhX;
  public HashMap<String, d> nhY;
  
  static
  {
    AppMethodBeat.i(144424);
    nhX = new AtomicInteger(1);
    AppMethodBeat.o(144424);
  }
  
  private l()
  {
    AppMethodBeat.i(144420);
    this.nhY = new HashMap();
    AppMethodBeat.o(144420);
  }
  
  public static l bPF()
  {
    AppMethodBeat.i(144421);
    l locall = a.bPG();
    AppMethodBeat.o(144421);
    return locall;
  }
  
  public static int bPw()
  {
    AppMethodBeat.i(144423);
    int i = nhX.incrementAndGet();
    AppMethodBeat.o(144423);
    return i;
  }
  
  public final d adh(String paramString)
  {
    AppMethodBeat.i(144422);
    if (this.nhY.containsKey(paramString))
    {
      paramString = (d)this.nhY.get(paramString);
      AppMethodBeat.o(144422);
      return paramString;
    }
    AppMethodBeat.o(144422);
    return null;
  }
  
  static final class a
  {
    private static l niP;
    
    static
    {
      AppMethodBeat.i(144419);
      niP = new l((byte)0);
      AppMethodBeat.o(144419);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.l
 * JD-Core Version:    0.7.0.1
 */