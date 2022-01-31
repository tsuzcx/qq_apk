package com.tencent.mm.plugin.hp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;

public final class h
  implements bz.a
{
  public final void a(e.a parama)
  {
    AppMethodBeat.i(90613);
    parama = parama.eyJ;
    Object localObject;
    if (parama.nqW == 10002)
    {
      parama = aa.a(parama.woR);
      if (bo.isNullOrNil(parama))
      {
        ab.w("MicroMsg.Tinker.TinkerBootsSysCmdMsgListener", "msg content is null");
        AppMethodBeat.o(90613);
        return;
      }
      ab.i("MicroMsg.Tinker.TinkerBootsSysCmdMsgListener", "onReciveMsg :%s", new Object[] { parama });
      parama = br.F(parama, "sysmsg");
      if ((parama != null) && (parama.size() > 0))
      {
        localObject = (String)parama.get(".sysmsg.$type");
        if ((!bo.isNullOrNil((String)localObject)) && (((String)localObject).equalsIgnoreCase("prconfignotify")))
        {
          i = bo.apV((String)parama.get(".sysmsg.boots.ignorenetwork"));
          parama = bo.bf((String)parama.get(".sysmsg.boots.xmlkey"), "");
          ab.i("MicroMsg.Tinker.TinkerBootsSysCmdMsgListener", "ignore:%s md5 %s start checkout tinker update. try to do update.", new Object[] { Integer.valueOf(i), parama });
          long l = com.tencent.mm.kernel.a.QW();
          localObject = com.tinkerboots.sdk.a.eaJ().ji("uin", String.valueOf(l & 0xFFFFFFFF));
          if ((!at.isWifi(ah.getContext())) && (i != 1)) {
            break label250;
          }
        }
      }
    }
    label250:
    for (int i = 3;; i = 2)
    {
      ((com.tinkerboots.sdk.a)localObject).ji("network", String.valueOf(i));
      if (!bo.isNullOrNil(parama)) {
        com.tinkerboots.sdk.a.eaJ().ji("xmlkey", parama);
      }
      com.tinkerboots.sdk.a.eaJ().sm(true);
      AppMethodBeat.o(90613);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.h
 * JD-Core Version:    0.7.0.1
 */