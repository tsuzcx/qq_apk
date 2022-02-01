package com.tencent.luggage.bridge.impl;

import com.tencent.luggage.bridge.a.a.a;
import com.tencent.luggage.bridge.a.a.b;
import com.tencent.luggage.bridge.a.a.c;
import com.tencent.luggage.bridge.impl.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.k;

public class a
  implements a.b
{
  final com.tencent.mm.plugin.appbrand.f.a eiV;
  
  public a()
  {
    AppMethodBeat.i(140359);
    this.eiV = new b();
    AppMethodBeat.o(140359);
  }
  
  public void a(a.a parama)
  {
    AppMethodBeat.i(140361);
    parama.a(com.tencent.mm.plugin.appbrand.f.a.class, this.eiV);
    AppMethodBeat.o(140361);
  }
  
  public void a(a.c paramc)
  {
    AppMethodBeat.i(140360);
    k.setContext(MMApplicationContext.getContext());
    paramc.a(com.tencent.mm.plugin.appbrand.f.a.class, this.eiV);
    AppMethodBeat.o(140360);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.bridge.impl.a
 * JD-Core Version:    0.7.0.1
 */