package com.tencent.mm.plugin.appbrand.j;

import com.tencent.luggage.bridge.a.a.a;
import com.tencent.luggage.bridge.a.a.c;
import com.tencent.mm.plugin.appbrand.canvas.e;
import com.tencent.mm.plugin.appbrand.j.b.l;
import com.tencent.mm.plugin.appbrand.j.b.m;
import com.tencent.mm.plugin.appbrand.jsapi.base.f;
import com.tencent.mm.plugin.appbrand.o.n;

public final class a
  extends com.tencent.luggage.bridge.impl.a
{
  private static e fUH = new com.tencent.mm.plugin.appbrand.j.a.c();
  private static final com.tencent.mm.plugin.appbrand.d.a gMK = new l();
  private static final com.tencent.mm.plugin.appbrand.d.b gML = new m();
  private final f bjf = new com.tencent.mm.plugin.appbrand.j.b.b();
  
  public final void a(a.a parama)
  {
    super.a(parama);
    parama.a(com.tencent.mm.plugin.appbrand.d.a.class, gMK);
    parama.a(f.class, this.bjf);
  }
  
  public final void a(a.c paramc)
  {
    super.a(paramc);
    paramc.a(com.tencent.mm.plugin.appbrand.d.a.class, gMK);
    paramc.a(f.class, this.bjf);
    paramc.a(com.tencent.mm.plugin.appbrand.d.b.class, gML);
    paramc.a(e.class, fUH);
    paramc.a(n.class, new com.tencent.mm.plugin.appbrand.j.c.c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.a
 * JD-Core Version:    0.7.0.1
 */