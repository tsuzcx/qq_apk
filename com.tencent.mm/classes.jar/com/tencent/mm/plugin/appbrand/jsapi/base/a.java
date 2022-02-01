package com.tencent.mm.plugin.appbrand.jsapi.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.o;
import java.util.HashMap;

public final class a
{
  private HashMap<String, o> kCc;
  
  public a()
  {
    AppMethodBeat.i(187613);
    this.kCc = new HashMap(5);
    AppMethodBeat.o(187613);
  }
  
  public final o Pq(String paramString)
  {
    AppMethodBeat.i(187615);
    paramString = (o)this.kCc.get(paramString);
    AppMethodBeat.o(187615);
    return paramString;
  }
  
  public final void a(String paramString, o paramo)
  {
    AppMethodBeat.i(187614);
    this.kCc.put(paramString, paramo);
    AppMethodBeat.o(187614);
  }
  
  public final void remove(String paramString)
  {
    AppMethodBeat.i(187616);
    this.kCc.remove(paramString);
    AppMethodBeat.o(187616);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.a
 * JD-Core Version:    0.7.0.1
 */