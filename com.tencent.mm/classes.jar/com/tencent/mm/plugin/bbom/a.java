package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.dv;
import com.tencent.mm.g.a.is;
import com.tencent.mm.g.a.nr;
import com.tencent.mm.model.az;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.u;
import com.tencent.mm.modelmulti.p;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.modelsimple.e;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.protobuf.aw;
import com.tencent.mm.protocal.protobuf.ccp;
import com.tencent.mm.protocal.protobuf.dqs;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;

public final class a
  implements com.tencent.mm.plugin.auth.a.a
{
  public final void a(j.h paramh, j.i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(22330);
    if ((parami.FnN.HEE & 0x2) != 0)
    {
      paramh = parami.FnN.HEG;
      if (!paramBoolean)
      {
        ba.aBQ();
        com.tencent.mm.model.c.clearPluginData(paramh.Fsi);
      }
      parami = com.tencent.mm.ak.c.CS(u.aAm());
      az.hFS.Be(parami);
      if (paramh.Fsf != 0)
      {
        ba.aBQ();
        com.tencent.mm.model.c.azy().eo(paramh.Fsf + "@qqim", 3);
      }
      com.tencent.mm.ak.c.e(paramh.Fsf, 3);
    }
    for (;;)
    {
      o.run(1);
      if (!paramBoolean) {
        break;
      }
      paramh = new is();
      paramh.dvp.dvq = false;
      com.tencent.mm.sdk.b.a.IbL.l(paramh);
      AppMethodBeat.o(22330);
      return;
      ad.w("MicroMsg.BigBallAuthHandle", "summerauth updateProfile acctsect not set!");
    }
    ba.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22328);
        bl.Bs("ver" + d.Fnj);
        ao.dxS().addAll(com.tencent.mm.plugin.s.a.dxQ().eZX());
        com.tencent.mm.sdk.b.a locala = com.tencent.mm.sdk.b.a.IbL;
        if (locala == null)
        {
          ad.e("MicroMsg.BigBallAuthHandle", "EventPool is null.");
          AppMethodBeat.o(22328);
          return;
        }
        is localis = new is();
        localis.dvp.dvq = true;
        locala.l(localis);
        locala.l(new dv());
        locala.l(new nr());
        e.eQ(true);
        p.aJx().pM(3);
        ad.i("MicroMsg.BigBallAuthHandle", "summerbadcr triggerSync bgfg after manual auth");
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
    paramString1 = com.tencent.mm.ak.c.CS(u.aAm());
    az.hFS.Be(paramString1);
    com.tencent.mm.ak.c.e(paramInt1, 3);
    ba.aBQ();
    com.tencent.mm.model.c.azy().eo(paramb.FoA.GWE, 2);
    if (paramInt1 != 0)
    {
      ba.aBQ();
      com.tencent.mm.model.c.azy().eo(paramInt1 + "@qqim", 3);
    }
    AppMethodBeat.o(22331);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.a
 * JD-Core Version:    0.7.0.1
 */