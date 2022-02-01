package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.o;
import java.util.HashMap;

public final class a
{
  private HashMap<String, o> kah;
  
  public a()
  {
    AppMethodBeat.i(190819);
    this.kah = new HashMap(5);
    AppMethodBeat.o(190819);
  }
  
  public final o II(String paramString)
  {
    AppMethodBeat.i(190821);
    paramString = (o)this.kah.get(paramString);
    AppMethodBeat.o(190821);
    return paramString;
  }
  
  public final void a(String paramString, o paramo)
  {
    AppMethodBeat.i(190820);
    this.kah.put(paramString, paramo);
    AppMethodBeat.o(190820);
  }
  
  public final void remove(String paramString)
  {
    AppMethodBeat.i(190822);
    this.kah.remove(paramString);
    AppMethodBeat.o(190822);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.a
 * JD-Core Version:    0.7.0.1
 */