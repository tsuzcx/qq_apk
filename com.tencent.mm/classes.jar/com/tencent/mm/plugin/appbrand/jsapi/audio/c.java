package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import java.util.HashMap;
import java.util.Map;

public enum c
{
  private Map<String, a> kzp;
  
  static
  {
    AppMethodBeat.i(210893);
    kzo = new c("INSTANCE");
    kzq = new c[] { kzo };
    AppMethodBeat.o(210893);
  }
  
  private c()
  {
    AppMethodBeat.i(210891);
    this.kzp = new HashMap(2);
    AppMethodBeat.o(210891);
  }
  
  public final a PS(String paramString)
  {
    AppMethodBeat.i(210892);
    if (!this.kzp.containsKey(paramString)) {
      this.kzp.put(paramString, new a());
    }
    paramString = (a)this.kzp.get(paramString);
    AppMethodBeat.o(210892);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.c
 * JD-Core Version:    0.7.0.1
 */