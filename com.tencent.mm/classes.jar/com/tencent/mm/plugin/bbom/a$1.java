package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.dl;
import com.tencent.mm.g.a.hj;
import com.tencent.mm.g.a.lp;
import com.tencent.mm.g.a.tg;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelmulti.n;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelsimple.e;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;

final class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(18227);
    bh.pC("ver" + d.whH);
    al.cae().addAll(com.tencent.mm.plugin.s.a.cac().dlC());
    com.tencent.mm.sdk.b.a locala = com.tencent.mm.sdk.b.a.ymk;
    if (locala == null)
    {
      ab.e("MicroMsg.BigBallAuthHandle", "EventPool is null.");
      AppMethodBeat.o(18227);
      return;
    }
    Object localObject = new hj();
    ((hj)localObject).cwv.cww = true;
    locala.l((b)localObject);
    localObject = new tg();
    ((tg)localObject).cJH.cJI = true;
    locala.l((b)localObject);
    locala.l(new dl());
    locala.l(new lp());
    e.dc(true);
    n.aio().lL(3);
    ab.i("MicroMsg.BigBallAuthHandle", "summerbadcr triggerSync bgfg after manual auth");
    AppMethodBeat.o(18227);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(18228);
    String str = super.toString() + "|onGYNetEnd2";
    AppMethodBeat.o(18228);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.a.1
 * JD-Core Version:    0.7.0.1
 */