package com.tencent.mm.plugin.hp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.c;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.Map;

public final class h
  implements cc.a
{
  public final void a(f.a parama)
  {
    AppMethodBeat.i(117441);
    parama = parama.fTo;
    Object localObject;
    if (parama.saz == 10002)
    {
      parama = z.a(parama.Cxz);
      if (bt.isNullOrNil(parama))
      {
        ad.w("MicroMsg.Tinker.TinkerBootsSysCmdMsgListener", "msg content is null");
        AppMethodBeat.o(117441);
        return;
      }
      ad.i("MicroMsg.Tinker.TinkerBootsSysCmdMsgListener", "onReciveMsg :%s", new Object[] { parama });
      parama = bw.K(parama, "sysmsg");
      if ((parama != null) && (parama.size() > 0))
      {
        localObject = (String)parama.get(".sysmsg.$type");
        if ((!bt.isNullOrNil((String)localObject)) && (((String)localObject).equalsIgnoreCase("prconfignotify")))
        {
          i = bt.aGh((String)parama.get(".sysmsg.boots.ignorenetwork"));
          parama = bt.by((String)parama.get(".sysmsg.boots.xmlkey"), "");
          ad.i("MicroMsg.Tinker.TinkerBootsSysCmdMsgListener", "ignore:%s md5 %s start checkout tinker update. try to do update.", new Object[] { Integer.valueOf(i), parama });
          long l = com.tencent.mm.kernel.a.aeL();
          localObject = com.tinkerboots.sdk.a.ftM().mn("uin", String.valueOf(l & 0xFFFFFFFF));
          if ((!ay.isWifi(aj.getContext())) && (i != 1)) {
            break label250;
          }
        }
      }
    }
    label250:
    for (int i = 3;; i = 2)
    {
      ((com.tinkerboots.sdk.a)localObject).mn("network", String.valueOf(i));
      if (!bt.isNullOrNil(parama)) {
        com.tinkerboots.sdk.a.ftM().mn("xmlkey", parama);
      }
      com.tinkerboots.sdk.a.ftM().xP(true);
      AppMethodBeat.o(117441);
      return;
    }
  }
  
  public final void a(f.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.h
 * JD-Core Version:    0.7.0.1
 */