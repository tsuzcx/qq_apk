package com.tencent.mm.plugin.hp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.c;
import com.tencent.mm.model.cd.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.Map;

public final class h
  implements cd.a
{
  public final void a(e.a parama)
  {
    AppMethodBeat.i(117441);
    parama = parama.gqE;
    Object localObject;
    if (parama.ugm == 10002)
    {
      parama = z.a(parama.Fvk);
      if (bt.isNullOrNil(parama))
      {
        ad.w("MicroMsg.Tinker.TinkerBootsSysCmdMsgListener", "msg content is null");
        AppMethodBeat.o(117441);
        return;
      }
      ad.i("MicroMsg.Tinker.TinkerBootsSysCmdMsgListener", "onReciveMsg :%s", new Object[] { parama });
      parama = bw.M(parama, "sysmsg");
      if ((parama != null) && (parama.size() > 0))
      {
        localObject = (String)parama.get(".sysmsg.$type");
        if ((!bt.isNullOrNil((String)localObject)) && (((String)localObject).equalsIgnoreCase("prconfignotify")))
        {
          i = bt.aRe((String)parama.get(".sysmsg.boots.ignorenetwork"));
          parama = bt.bI((String)parama.get(".sysmsg.boots.xmlkey"), "");
          ad.i("MicroMsg.Tinker.TinkerBootsSysCmdMsgListener", "ignore:%s md5 %s start checkout tinker update. try to do update.", new Object[] { Integer.valueOf(i), parama });
          long l = com.tencent.mm.kernel.a.aiN();
          localObject = com.tinkerboots.sdk.a.gdU().nm("uin", String.valueOf(l & 0xFFFFFFFF));
          if ((!ay.isWifi(aj.getContext())) && (i != 1)) {
            break label250;
          }
        }
      }
    }
    label250:
    for (int i = 3;; i = 2)
    {
      ((com.tinkerboots.sdk.a)localObject).nm("network", String.valueOf(i));
      if (!bt.isNullOrNil(parama)) {
        com.tinkerboots.sdk.a.gdU().nm("xmlkey", parama);
      }
      com.tinkerboots.sdk.a.gdU().zV(true);
      AppMethodBeat.o(117441);
      return;
    }
  }
  
  public final void a(e.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.h
 * JD-Core Version:    0.7.0.1
 */