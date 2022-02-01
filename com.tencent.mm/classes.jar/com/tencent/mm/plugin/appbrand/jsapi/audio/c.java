package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import java.util.HashMap;
import java.util.Map;

public enum c
{
  private Map<String, a> kwa;
  
  static
  {
    AppMethodBeat.i(198671);
    kvZ = new c("INSTANCE");
    kwb = new c[] { kvZ };
    AppMethodBeat.o(198671);
  }
  
  private c()
  {
    AppMethodBeat.i(198669);
    this.kwa = new HashMap(2);
    AppMethodBeat.o(198669);
  }
  
  public final a Pk(String paramString)
  {
    AppMethodBeat.i(198670);
    if (!this.kwa.containsKey(paramString)) {
      this.kwa.put(paramString, new a());
    }
    paramString = (a)this.kwa.get(paramString);
    AppMethodBeat.o(198670);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.c
 * JD-Core Version:    0.7.0.1
 */