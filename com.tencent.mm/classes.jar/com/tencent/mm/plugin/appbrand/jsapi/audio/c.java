package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import java.util.HashMap;
import java.util.Map;

public enum c
{
  private Map<String, a> rDc;
  
  static
  {
    AppMethodBeat.i(327779);
    rDb = new c("INSTANCE");
    rDd = new c[] { rDb };
    AppMethodBeat.o(327779);
  }
  
  private c()
  {
    AppMethodBeat.i(327778);
    this.rDc = new HashMap(2);
    AppMethodBeat.o(327778);
  }
  
  public final a ZX(String paramString)
  {
    AppMethodBeat.i(327781);
    if (!this.rDc.containsKey(paramString)) {
      this.rDc.put(paramString, new a());
    }
    paramString = (a)this.rDc.get(paramString);
    AppMethodBeat.o(327781);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.c
 * JD-Core Version:    0.7.0.1
 */