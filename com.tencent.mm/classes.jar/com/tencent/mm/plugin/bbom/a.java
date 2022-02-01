package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.dz;
import com.tencent.mm.g.a.ji;
import com.tencent.mm.g.a.ok;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.p;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.modelsimple.f;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.auth.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.ctp;
import com.tencent.mm.protocal.protobuf.ell;
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
    if ((parami.Kzw.Nkx & 0x2) != 0)
    {
      paramh = parami.Kzw.Nkz;
      if (!paramBoolean)
      {
        bg.aVF();
        com.tencent.mm.model.c.clearPluginData(paramh.KEc);
      }
      parami = com.tencent.mm.aj.c.Me(z.aTY());
      bf.iDu.Km(parami);
      if (paramh.KDZ != 0)
      {
        bg.aVF();
        com.tencent.mm.model.c.aSW().eJ(paramh.KDZ + "@qqim", 3);
      }
      com.tencent.mm.aj.c.e(paramh.KDZ, 3);
    }
    for (;;)
    {
      o.run(1);
      if (!paramBoolean) {
        break;
      }
      paramh = new ji();
      paramh.dOb.dOc = false;
      EventCenter.instance.publish(paramh);
      AppMethodBeat.o(22330);
      return;
      Log.w("MicroMsg.BigBallAuthHandle", "summerauth updateProfile acctsect not set!");
    }
    bg.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(22328);
        br.KA("ver" + d.KyO);
        ao.eAU().addAll(com.tencent.mm.plugin.r.a.eAS().gmW());
        EventCenter localEventCenter = EventCenter.instance;
        if (localEventCenter == null)
        {
          Log.e("MicroMsg.BigBallAuthHandle", "EventPool is null.");
          AppMethodBeat.o(22328);
          return;
        }
        ji localji = new ji();
        localji.dOb.dOc = true;
        localEventCenter.publish(localji);
        localEventCenter.publish(new dz());
        localEventCenter.publish(new ok());
        f.fJ(true);
        p.bdS().tE(3);
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
    paramString1 = com.tencent.mm.aj.c.Me(z.aTY());
    bf.iDu.Km(paramString1);
    com.tencent.mm.aj.c.e(paramInt1, 3);
    bg.aVF();
    com.tencent.mm.model.c.aSW().eJ(paramb.KAj.MyK, 2);
    if (paramInt1 != 0)
    {
      bg.aVF();
      com.tencent.mm.model.c.aSW().eJ(paramInt1 + "@qqim", 3);
    }
    AppMethodBeat.o(22331);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.a
 * JD-Core Version:    0.7.0.1
 */