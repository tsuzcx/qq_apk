package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ds;
import com.tencent.mm.g.a.ik;
import com.tencent.mm.g.a.nj;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.u;
import com.tencent.mm.modelmulti.p;
import com.tencent.mm.modelsimple.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.protobuf.aw;
import com.tencent.mm.protocal.protobuf.bxy;
import com.tencent.mm.protocal.protobuf.dlb;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
  implements com.tencent.mm.plugin.auth.a.a
{
  public final void a(j.h paramh, j.i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(22330);
    if ((parami.DIG.FTQ & 0x2) != 0)
    {
      paramh = parami.DIG.FTS;
      if (!paramBoolean)
      {
        az.ayM();
        com.tencent.mm.model.c.clearPluginData(paramh.DNd);
      }
      parami = com.tencent.mm.aj.c.zT(u.axw());
      ay.hnA.yg(parami);
      if (paramh.DNa != 0)
      {
        az.ayM();
        com.tencent.mm.model.c.awJ().dX(paramh.DNa + "@qqim", 3);
      }
      com.tencent.mm.aj.c.e(paramh.DNa, 3);
    }
    for (;;)
    {
      com.tencent.mm.modelstat.o.run(1);
      if (!paramBoolean) {
        break;
      }
      paramh = new ik();
      paramh.djC.djD = false;
      com.tencent.mm.sdk.b.a.GpY.l(paramh);
      AppMethodBeat.o(22330);
      return;
      ac.w("MicroMsg.BigBallAuthHandle", "summerauth updateProfile acctsect not set!");
    }
    az.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22328);
        bk.yt("ver" + d.DIc);
        com.tencent.mm.pluginsdk.model.app.ap.dnA().addAll(com.tencent.mm.plugin.s.a.dny().eLd());
        com.tencent.mm.sdk.b.a locala = com.tencent.mm.sdk.b.a.GpY;
        if (locala == null)
        {
          ac.e("MicroMsg.BigBallAuthHandle", "EventPool is null.");
          AppMethodBeat.o(22328);
          return;
        }
        ik localik = new ik();
        localik.djC.djD = true;
        locala.l(localik);
        locala.l(new ds());
        locala.l(new nj());
        e.eO(true);
        com.tencent.mm.modelmulti.o.aGm().pj(3);
        ac.i("MicroMsg.BigBallAuthHandle", "summerbadcr triggerSync bgfg after manual auth");
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
    paramString1 = com.tencent.mm.aj.c.zT(u.axw());
    ay.hnA.yg(paramString1);
    com.tencent.mm.aj.c.e(paramInt1, 3);
    az.ayM();
    com.tencent.mm.model.c.awJ().dX(paramb.DJt.FmV, 2);
    if (paramInt1 != 0)
    {
      az.ayM();
      com.tencent.mm.model.c.awJ().dX(paramInt1 + "@qqim", 3);
    }
    AppMethodBeat.o(22331);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.a
 * JD-Core Version:    0.7.0.1
 */