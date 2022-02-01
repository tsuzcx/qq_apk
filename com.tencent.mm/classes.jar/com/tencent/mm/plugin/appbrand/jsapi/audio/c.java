package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import java.util.HashMap;
import java.util.Map;

public enum c
{
  private Map<String, a> lDI;
  
  static
  {
    AppMethodBeat.i(256422);
    lDH = new c("INSTANCE");
    lDJ = new c[] { lDH };
    AppMethodBeat.o(256422);
  }
  
  private c()
  {
    AppMethodBeat.i(256420);
    this.lDI = new HashMap(2);
    AppMethodBeat.o(256420);
  }
  
  public final a Zm(String paramString)
  {
    AppMethodBeat.i(256421);
    if (!this.lDI.containsKey(paramString)) {
      this.lDI.put(paramString, new a());
    }
    paramString = (a)this.lDI.get(paramString);
    AppMethodBeat.o(256421);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.c
 * JD-Core Version:    0.7.0.1
 */