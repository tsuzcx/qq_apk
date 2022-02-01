package com.tencent.mm.plugin.appbrand.jsapi.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.o;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  public final ConcurrentHashMap<String, o> oGh;
  
  public a()
  {
    AppMethodBeat.i(210520);
    this.oGh = new ConcurrentHashMap(5);
    AppMethodBeat.o(210520);
  }
  
  public final o ahn(String paramString)
  {
    AppMethodBeat.i(210524);
    paramString = (o)this.oGh.get(paramString);
    AppMethodBeat.o(210524);
    return paramString;
  }
  
  public final void b(String paramString, o paramo)
  {
    AppMethodBeat.i(210522);
    this.oGh.put(paramString, paramo);
    AppMethodBeat.o(210522);
  }
  
  public final void remove(String paramString)
  {
    AppMethodBeat.i(210526);
    this.oGh.remove(paramString);
    AppMethodBeat.o(210526);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.a
 * JD-Core Version:    0.7.0.1
 */