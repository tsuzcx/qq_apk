package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.g.a.id;
import com.tencent.mm.g.a.na;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.u;
import com.tencent.mm.modelmulti.p;
import com.tencent.mm.modelsimple.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.protobuf.au;
import com.tencent.mm.protocal.protobuf.bth;
import com.tencent.mm.protocal.protobuf.dfm;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;

public final class a
  implements com.tencent.mm.plugin.auth.a.a
{
  public final void a(j.h paramh, j.i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(22330);
    if ((parami.Cqo.EwO & 0x2) != 0)
    {
      paramh = parami.Cqo.EwQ;
      if (!paramBoolean)
      {
        az.arV();
        com.tencent.mm.model.c.clearPluginData(paramh.CuI);
      }
      parami = com.tencent.mm.ak.c.vN(u.aqG());
      ay.gNa.ua(parami);
      if (paramh.CuF != 0)
      {
        az.arV();
        com.tencent.mm.model.c.apU().dQ(paramh.CuF + "@qqim", 3);
      }
      com.tencent.mm.ak.c.e(paramh.CuF, 3);
    }
    for (;;)
    {
      com.tencent.mm.modelstat.o.run(1);
      if (!paramBoolean) {
        break;
      }
      paramh = new id();
      paramh.dlU.dlV = false;
      com.tencent.mm.sdk.b.a.ESL.l(paramh);
      AppMethodBeat.o(22330);
      return;
      ad.w("MicroMsg.BigBallAuthHandle", "summerauth updateProfile acctsect not set!");
    }
    az.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22328);
        bk.un("ver" + d.CpK);
        ap.cZS().addAll(com.tencent.mm.plugin.s.a.cZQ().evJ());
        com.tencent.mm.sdk.b.a locala = com.tencent.mm.sdk.b.a.ESL;
        if (locala == null)
        {
          ad.e("MicroMsg.BigBallAuthHandle", "EventPool is null.");
          AppMethodBeat.o(22328);
          return;
        }
        id localid = new id();
        localid.dlU.dlV = true;
        locala.l(localid);
        locala.l(new dr());
        locala.l(new na());
        e.eu(true);
        com.tencent.mm.modelmulti.o.azv().ov(3);
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
    paramString1 = com.tencent.mm.ak.c.vN(u.aqG());
    ay.gNa.ua(paramString1);
    com.tencent.mm.ak.c.e(paramInt1, 3);
    az.arV();
    com.tencent.mm.model.c.apU().dQ(paramb.Crb.DQD, 2);
    if (paramInt1 != 0)
    {
      az.arV();
      com.tencent.mm.model.c.apU().dQ(paramInt1 + "@qqim", 3);
    }
    AppMethodBeat.o(22331);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.a
 * JD-Core Version:    0.7.0.1
 */