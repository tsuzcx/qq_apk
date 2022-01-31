package com.tencent.mm.plugin.bbom;

import com.tencent.mm.h.a.di;
import com.tencent.mm.h.a.hf;
import com.tencent.mm.h.a.lb;
import com.tencent.mm.h.a.rp;
import com.tencent.mm.model.bf;
import com.tencent.mm.modelmulti.n;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelsimple.c;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.y;

final class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  public final void run()
  {
    bf.iO("ver" + d.spa);
    ap.brp().addAll(com.tencent.mm.plugin.z.a.brn().ckS());
    com.tencent.mm.sdk.b.a locala = com.tencent.mm.sdk.b.a.udP;
    if (locala == null)
    {
      y.e("MicroMsg.BigBallAuthHandle", "EventPool is null.");
      return;
    }
    Object localObject = new hf();
    ((hf)localObject).bPc.bPd = true;
    locala.m((b)localObject);
    localObject = new rp();
    ((rp)localObject).cbe.cbf = true;
    locala.m((b)localObject);
    locala.m(new di());
    locala.m(new lb());
    c.bZ(true);
    n.Pm().iT(3);
    y.i("MicroMsg.BigBallAuthHandle", "summerbadcr triggerSync bgfg after manual auth");
  }
  
  public final String toString()
  {
    return super.toString() + "|onGYNetEnd2";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.a.1
 * JD-Core Version:    0.7.0.1
 */