package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.o;
import java.util.HashMap;

public final class a
{
  private HashMap<String, o> kAU;
  
  public a()
  {
    AppMethodBeat.i(199898);
    this.kAU = new HashMap(5);
    AppMethodBeat.o(199898);
  }
  
  public final o MJ(String paramString)
  {
    AppMethodBeat.i(199900);
    paramString = (o)this.kAU.get(paramString);
    AppMethodBeat.o(199900);
    return paramString;
  }
  
  public final void a(String paramString, o paramo)
  {
    AppMethodBeat.i(199899);
    this.kAU.put(paramString, paramo);
    AppMethodBeat.o(199899);
  }
  
  public final void remove(String paramString)
  {
    AppMethodBeat.i(199901);
    this.kAU.remove(paramString);
    AppMethodBeat.o(199901);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.a
 * JD-Core Version:    0.7.0.1
 */