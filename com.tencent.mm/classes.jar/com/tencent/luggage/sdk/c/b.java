package com.tencent.luggage.sdk.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.n.c;
import com.tencent.mm.plugin.appbrand.n.i;
import com.tencent.mm.plugin.appbrand.n.x;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/jsruntime/JsRuntimeHelper;", "", "()V", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b.a ets;
  
  static
  {
    AppMethodBeat.i(220202);
    ets = new b.a((byte)0);
    AppMethodBeat.o(220202);
  }
  
  public static final String e(i parami)
  {
    AppMethodBeat.i(220201);
    if ((parami instanceof c))
    {
      parami = a.etm;
      parami = a.arU();
      AppMethodBeat.o(220201);
      return parami;
    }
    if ((parami instanceof x))
    {
      parami = a.etm;
      parami = a.arV();
      AppMethodBeat.o(220201);
      return parami;
    }
    parami = a.etm;
    parami = a.arW();
    AppMethodBeat.o(220201);
    return parami;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.sdk.c.b
 * JD-Core Version:    0.7.0.1
 */