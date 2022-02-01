package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.eg;
import com.tencent.mm.f.a.jy;
import com.tencent.mm.f.a.ph;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.p;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.modelsimple.f;
import com.tencent.mm.plugin.auth.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.protobuf.ay;
import com.tencent.mm.protocal.protobuf.dco;
import com.tencent.mm.protocal.protobuf.evr;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class a
  implements b
{
  public final void a(j.h paramh, j.i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(22330);
    if ((parami.RBm.Uxh & 0x2) != 0)
    {
      paramh = parami.RBm.Uxj;
      if (!paramBoolean)
      {
        bh.beI();
        c.clearPluginData(paramh.RFu);
      }
      parami = com.tencent.mm.am.d.Tz(z.bcZ());
      bg.ltv.RF(parami);
      if (paramh.RFr != 0)
      {
        bh.beI();
        c.bbU().fk(paramh.RFr + "@qqim", 3);
      }
      com.tencent.mm.am.d.f(paramh.RFr, 3);
    }
    while (paramBoolean)
    {
      paramh = new jy();
      paramh.fHm.fHn = false;
      EventCenter.instance.publish(paramh);
      AppMethodBeat.o(22330);
      return;
      Log.w("MicroMsg.BigBallAuthHandle", "summerauth updateProfile acctsect not set!");
    }
    bh.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22328);
        bs.RT("ver" + com.tencent.mm.protocal.d.RAD);
        ao.fmB().addAll(com.tencent.mm.plugin.ab.a.fmz().hhx());
        EventCenter localEventCenter = EventCenter.instance;
        if (localEventCenter == null)
        {
          Log.e("MicroMsg.BigBallAuthHandle", "EventPool is null.");
          AppMethodBeat.o(22328);
          return;
        }
        jy localjy = new jy();
        localjy.fHm.fHn = true;
        localEventCenter.publish(localjy);
        localEventCenter.publish(new eg());
        localEventCenter.publish(new ph());
        f.gv(true);
        p.bnn().wE(3);
        Log.i("MicroMsg.BigBallAuthHandle", "summerbadcr triggerSync bgfg after manual auth");
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
    paramString1 = com.tencent.mm.am.d.Tz(z.bcZ());
    bg.ltv.RF(paramString1);
    com.tencent.mm.am.d.f(paramInt1, 3);
    bh.beI();
    c.bbU().fk(paramb.RBZ.TKl, 2);
    if (paramInt1 != 0)
    {
      bh.beI();
      c.bbU().fk(paramInt1 + "@qqim", 3);
    }
    AppMethodBeat.o(22331);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.a
 * JD-Core Version:    0.7.0.1
 */