package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import java.util.HashMap;
import java.util.Map;

public enum c
{
  private Map<String, a> ozk;
  
  static
  {
    AppMethodBeat.i(226021);
    ozj = new c("INSTANCE");
    ozl = new c[] { ozj };
    AppMethodBeat.o(226021);
  }
  
  private c()
  {
    AppMethodBeat.i(226016);
    this.ozk = new HashMap(2);
    AppMethodBeat.o(226016);
  }
  
  public final a agZ(String paramString)
  {
    AppMethodBeat.i(226018);
    if (!this.ozk.containsKey(paramString)) {
      this.ozk.put(paramString, new a());
    }
    paramString = (a)this.ozk.get(paramString);
    AppMethodBeat.o(226018);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.c
 * JD-Core Version:    0.7.0.1
 */