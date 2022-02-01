package com.tencent.mm.plugin.appbrand.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.d;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class l
{
  private static AtomicInteger kUI;
  public HashMap<String, d> kUJ;
  
  static
  {
    AppMethodBeat.i(144424);
    kUI = new AtomicInteger(1);
    AppMethodBeat.o(144424);
  }
  
  private l()
  {
    AppMethodBeat.i(144420);
    this.kUJ = new HashMap();
    AppMethodBeat.o(144420);
  }
  
  public static int bil()
  {
    AppMethodBeat.i(144423);
    int i = kUI.incrementAndGet();
    AppMethodBeat.o(144423);
    return i;
  }
  
  public static l biu()
  {
    AppMethodBeat.i(144421);
    l locall = a.biv();
    AppMethodBeat.o(144421);
    return locall;
  }
  
  public final d Li(String paramString)
  {
    AppMethodBeat.i(144422);
    if (this.kUJ.containsKey(paramString))
    {
      paramString = (d)this.kUJ.get(paramString);
      AppMethodBeat.o(144422);
      return paramString;
    }
    AppMethodBeat.o(144422);
    return null;
  }
  
  static final class a
  {
    private static l kVB;
    
    static
    {
      AppMethodBeat.i(144419);
      kVB = new l((byte)0);
      AppMethodBeat.o(144419);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.l
 * JD-Core Version:    0.7.0.1
 */