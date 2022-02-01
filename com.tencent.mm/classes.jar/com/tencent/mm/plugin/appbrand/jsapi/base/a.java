package com.tencent.mm.plugin.appbrand.jsapi.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.n.o;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  public final ConcurrentHashMap<String, o> rJg;
  
  public a()
  {
    AppMethodBeat.i(325831);
    this.rJg = new ConcurrentHashMap(5);
    AppMethodBeat.o(325831);
  }
  
  public final o aak(String paramString)
  {
    AppMethodBeat.i(325838);
    paramString = (o)this.rJg.get(paramString);
    AppMethodBeat.o(325838);
    return paramString;
  }
  
  public final void b(String paramString, o paramo)
  {
    AppMethodBeat.i(325835);
    this.rJg.put(paramString, paramo);
    AppMethodBeat.o(325835);
  }
  
  public final void remove(String paramString)
  {
    AppMethodBeat.i(325841);
    this.rJg.remove(paramString);
    AppMethodBeat.o(325841);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.a
 * JD-Core Version:    0.7.0.1
 */