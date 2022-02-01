package com.tencent.luggage.sdk.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.c;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.x;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/sdk/jsruntime/JsRuntimeHelper;", "", "()V", "Companion", "luggage-wechat-full-sdk_release"})
public final class b
{
  public static final b.a cAW;
  
  static
  {
    AppMethodBeat.i(245535);
    cAW = new b.a((byte)0);
    AppMethodBeat.o(245535);
  }
  
  public static final String e(i parami)
  {
    AppMethodBeat.i(245538);
    if ((parami instanceof c))
    {
      parami = a.cAV;
      parami = a.RG();
      AppMethodBeat.o(245538);
      return parami;
    }
    if ((parami instanceof x))
    {
      parami = a.cAV;
      parami = a.RH();
      AppMethodBeat.o(245538);
      return parami;
    }
    parami = a.cAV;
    parami = a.RI();
    AppMethodBeat.o(245538);
    return parami;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.c.b
 * JD-Core Version:    0.7.0.1
 */