package com.tencent.mm.plugin.appbrand.pip;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.q.b;
import com.tencent.mm.plugin.appbrand.jsapi.q.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.q.g;
import com.tencent.mm.plugin.appbrand.jsapi.q.h.a;
import com.tencent.mm.plugin.appbrand.jsapi.q.i;
import com.tencent.mm.plugin.appbrand.jsapi.q.i.a;

public final class a$a
{
  public final int id;
  public b.a mmj;
  public boolean mmk;
  public final h.a mml;
  public final com.tencent.mm.plugin.appbrand.jsapi.q.c mmm;
  public final g mmn;
  public final i mmo;
  public c mmp;
  
  public a$a(int paramInt, b paramb, g paramg, h.a parama, com.tencent.mm.plugin.appbrand.jsapi.q.c paramc, c paramc1, i.a parama1)
  {
    AppMethodBeat.i(197349);
    this.mmj = b.a.leg;
    this.mmk = false;
    this.id = paramInt;
    this.mmn = paramg;
    this.mml = parama;
    this.mmm = paramc;
    this.mmp = paramc1;
    a(paramb);
    this.mmo = paramg.bmk();
    this.mmo.a(parama1);
    AppMethodBeat.o(197349);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(197350);
    b.a locala = paramb.FI();
    if (locala != null) {
      this.mmj = locala;
    }
    paramb = paramb.FJ();
    if (paramb != null) {
      this.mmk = paramb.booleanValue();
    }
    AppMethodBeat.o(197350);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.a.a
 * JD-Core Version:    0.7.0.1
 */