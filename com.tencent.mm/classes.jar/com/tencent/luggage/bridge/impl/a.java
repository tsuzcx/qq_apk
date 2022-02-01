package com.tencent.luggage.bridge.impl;

import com.tencent.luggage.bridge.a.a.a;
import com.tencent.luggage.bridge.a.a.b;
import com.tencent.luggage.bridge.a.a.c;
import com.tencent.luggage.bridge.impl.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;

public class a
  implements a.b
{
  final com.tencent.mm.plugin.appbrand.f.a chd;
  
  public a()
  {
    AppMethodBeat.i(140359);
    this.chd = new b();
    AppMethodBeat.o(140359);
  }
  
  public void a(a.a parama)
  {
    AppMethodBeat.i(140361);
    parama.a(com.tencent.mm.plugin.appbrand.f.a.class, this.chd);
    AppMethodBeat.o(140361);
  }
  
  public void a(a.c paramc)
  {
    AppMethodBeat.i(140360);
    com.tencent.mm.vfs.a.setContext(aj.getContext());
    paramc.a(com.tencent.mm.plugin.appbrand.f.a.class, this.chd);
    AppMethodBeat.o(140360);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.bridge.impl.a
 * JD-Core Version:    0.7.0.1
 */