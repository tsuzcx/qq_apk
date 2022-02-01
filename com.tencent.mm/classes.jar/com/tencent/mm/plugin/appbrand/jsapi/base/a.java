package com.tencent.mm.plugin.appbrand.jsapi.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.o;
import java.util.HashMap;

public final class a
{
  private HashMap<String, o> lJS;
  
  public a()
  {
    AppMethodBeat.i(221222);
    this.lJS = new HashMap(5);
    AppMethodBeat.o(221222);
  }
  
  public final o Zz(String paramString)
  {
    AppMethodBeat.i(221224);
    paramString = (o)this.lJS.get(paramString);
    AppMethodBeat.o(221224);
    return paramString;
  }
  
  public final void a(String paramString, o paramo)
  {
    AppMethodBeat.i(221223);
    this.lJS.put(paramString, paramo);
    AppMethodBeat.o(221223);
  }
  
  public final void remove(String paramString)
  {
    AppMethodBeat.i(221225);
    this.lJS.remove(paramString);
    AppMethodBeat.o(221225);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.a
 * JD-Core Version:    0.7.0.1
 */