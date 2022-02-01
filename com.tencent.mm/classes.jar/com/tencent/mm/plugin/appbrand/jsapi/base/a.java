package com.tencent.mm.plugin.appbrand.jsapi.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.o;
import java.util.HashMap;

public final class a
{
  private HashMap<String, o> kFr;
  
  public a()
  {
    AppMethodBeat.i(201180);
    this.kFr = new HashMap(5);
    AppMethodBeat.o(201180);
  }
  
  public final o PY(String paramString)
  {
    AppMethodBeat.i(201182);
    paramString = (o)this.kFr.get(paramString);
    AppMethodBeat.o(201182);
    return paramString;
  }
  
  public final void a(String paramString, o paramo)
  {
    AppMethodBeat.i(201181);
    this.kFr.put(paramString, paramo);
    AppMethodBeat.o(201181);
  }
  
  public final void remove(String paramString)
  {
    AppMethodBeat.i(201183);
    this.kFr.remove(paramString);
    AppMethodBeat.o(201183);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.a
 * JD-Core Version:    0.7.0.1
 */