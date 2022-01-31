package com.tencent.luggage.bridge.impl;

import com.tencent.luggage.bridge.a.a.a;
import com.tencent.luggage.bridge.a.a.b;
import com.tencent.luggage.bridge.a.a.c;
import com.tencent.luggage.bridge.impl.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.vfs.FileSystemManager;

public class a
  implements a.b
{
  final com.tencent.mm.plugin.appbrand.e.a byB;
  
  public a()
  {
    AppMethodBeat.i(90759);
    this.byB = new b();
    AppMethodBeat.o(90759);
  }
  
  public void a(a.a parama)
  {
    AppMethodBeat.i(90761);
    parama.a(com.tencent.mm.plugin.appbrand.e.a.class, this.byB);
    AppMethodBeat.o(90761);
  }
  
  public void a(a.c paramc)
  {
    AppMethodBeat.i(90760);
    FileSystemManager.setContext(ah.getContext());
    paramc.a(com.tencent.mm.plugin.appbrand.e.a.class, this.byB);
    AppMethodBeat.o(90760);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.bridge.impl.a
 * JD-Core Version:    0.7.0.1
 */