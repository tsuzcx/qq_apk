package com.tencent.mm.plugin.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.g.a.ii;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cd.a;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.model.av;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.sdk.e.k;

public final class c
{
  static n.a appForegroundListener;
  com.tencent.mm.sdk.b.c fJT;
  cd.a qdQ;
  com.tencent.mm.sdk.b.c raJ;
  com.tencent.mm.sdk.b.c tRA;
  av tRj;
  com.tencent.mm.plugin.game.media.background.b tRk;
  com.tencent.mm.sdk.b.c tRl;
  com.tencent.mm.sdk.b.c tRm;
  com.tencent.mm.sdk.b.c tRn;
  com.tencent.mm.sdk.b.c tRo;
  com.tencent.mm.sdk.b.c tRp;
  com.tencent.mm.sdk.b.c tRq;
  com.tencent.mm.sdk.b.c tRr;
  com.tencent.mm.sdk.b.c tRs;
  com.tencent.mm.sdk.b.c tRt;
  d tRu;
  d tRv;
  com.tencent.mm.sdk.b.c tRw;
  com.tencent.mm.sdk.b.c tRx;
  com.tencent.mm.sdk.b.c tRy;
  com.tencent.mm.sdk.b.c tRz;
  
  static
  {
    AppMethodBeat.i(206793);
    appForegroundListener = new c.13();
    AppMethodBeat.o(206793);
  }
  
  public c()
  {
    AppMethodBeat.i(40840);
    this.tRj = new av();
    this.tRk = new com.tencent.mm.plugin.game.media.background.b();
    this.qdQ = new c.1(this);
    this.tRl = new c.12(this);
    this.tRm = new c.14(this);
    this.tRn = new c.15(this);
    this.tRo = new c.16(this);
    this.tRp = new c.17(this);
    this.tRq = new c.18(this);
    this.tRr = new c.19(this);
    this.tRs = new c.20(this);
    this.tRt = new c.2(this);
    this.tRu = new d()
    {
      public final com.tencent.mm.sdk.b.b alj(String paramAnonymousString)
      {
        AppMethodBeat.i(206781);
        ii localii = new ii();
        localii.duQ.dln = paramAnonymousString;
        AppMethodBeat.o(206781);
        return localii;
      }
      
      public final k cWC()
      {
        AppMethodBeat.i(206782);
        s locals = ((f)g.ab(f.class)).cWH();
        AppMethodBeat.o(206782);
        return locals;
      }
    };
    this.tRv = new c.4(this);
    this.fJT = new c.5(this);
    this.tRw = new c.6(this);
    this.tRx = new c.7(this);
    this.tRy = new c.8(this);
    this.tRz = new c.9(this);
    this.raJ = new c.10(this);
    this.tRA = new c.11(this);
    AppMethodBeat.o(40840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.c
 * JD-Core Version:    0.7.0.1
 */