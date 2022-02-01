package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.dw;
import com.tencent.mm.g.a.it;
import com.tencent.mm.g.a.ns;
import com.tencent.mm.model.bb;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.v;
import com.tencent.mm.modelmulti.p;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.modelsimple.f;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.protobuf.aw;
import com.tencent.mm.protocal.protobuf.cdj;
import com.tencent.mm.protocal.protobuf.drp;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;

public final class a
  implements com.tencent.mm.plugin.auth.a.a
{
  public final void a(j.h paramh, j.i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(22330);
    if ((parami.FGl.HYr & 0x2) != 0)
    {
      paramh = parami.FGl.HYt;
      if (!paramBoolean)
      {
        bc.aCg();
        com.tencent.mm.model.c.clearPluginData(paramh.FKG);
      }
      parami = com.tencent.mm.aj.c.Du(v.aAC());
      bb.hIK.BG(parami);
      if (paramh.FKD != 0)
      {
        bc.aCg();
        com.tencent.mm.model.c.azO().ev(paramh.FKD + "@qqim", 3);
      }
      com.tencent.mm.aj.c.e(paramh.FKD, 3);
    }
    for (;;)
    {
      o.run(1);
      if (!paramBoolean) {
        break;
      }
      paramh = new it();
      paramh.dwu.dwv = false;
      com.tencent.mm.sdk.b.a.IvT.l(paramh);
      AppMethodBeat.o(22330);
      return;
      ae.w("MicroMsg.BigBallAuthHandle", "summerauth updateProfile acctsect not set!");
    }
    bc.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22328);
        bn.BU("ver" + d.FFH);
        ao.dBi().addAll(com.tencent.mm.plugin.s.a.dBg().fdL());
        com.tencent.mm.sdk.b.a locala = com.tencent.mm.sdk.b.a.IvT;
        if (locala == null)
        {
          ae.e("MicroMsg.BigBallAuthHandle", "EventPool is null.");
          AppMethodBeat.o(22328);
          return;
        }
        it localit = new it();
        localit.dwu.dwv = true;
        locala.l(localit);
        locala.l(new dw());
        locala.l(new ns());
        f.eT(true);
        p.aJQ().pP(3);
        ae.i("MicroMsg.BigBallAuthHandle", "summerbadcr triggerSync bgfg after manual auth");
        AppMethodBeat.o(22328);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(22329);
        String str = super.toString() + "|onGYNetEnd2";
        AppMethodBeat.o(22329);
        return str;
      }
    });
    AppMethodBeat.o(22330);
  }
  
  public final void a(x.b paramb, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(22331);
    paramString1 = com.tencent.mm.aj.c.Du(v.aAC());
    bb.hIK.BG(paramString1);
    com.tencent.mm.aj.c.e(paramInt1, 3);
    bc.aCg();
    com.tencent.mm.model.c.azO().ev(paramb.FGY.Hqe, 2);
    if (paramInt1 != 0)
    {
      bc.aCg();
      com.tencent.mm.model.c.azO().ev(paramInt1 + "@qqim", 3);
    }
    AppMethodBeat.o(22331);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.a
 * JD-Core Version:    0.7.0.1
 */