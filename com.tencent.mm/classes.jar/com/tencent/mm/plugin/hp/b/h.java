package com.tencent.mm.plugin.hp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.Map;

public final class h
  implements cc.a
{
  public final void a(f.a parama)
  {
    AppMethodBeat.i(117441);
    parama = parama.fXi;
    Object localObject;
    if (parama.tit == 10002)
    {
      parama = z.a(parama.DPV);
      if (bs.isNullOrNil(parama))
      {
        ac.w("MicroMsg.Tinker.TinkerBootsSysCmdMsgListener", "msg content is null");
        AppMethodBeat.o(117441);
        return;
      }
      ac.i("MicroMsg.Tinker.TinkerBootsSysCmdMsgListener", "onReciveMsg :%s", new Object[] { parama });
      parama = bv.L(parama, "sysmsg");
      if ((parama != null) && (parama.size() > 0))
      {
        localObject = (String)parama.get(".sysmsg.$type");
        if ((!bs.isNullOrNil((String)localObject)) && (((String)localObject).equalsIgnoreCase("prconfignotify")))
        {
          i = bs.aLy((String)parama.get(".sysmsg.boots.ignorenetwork"));
          parama = bs.bG((String)parama.get(".sysmsg.boots.xmlkey"), "");
          ac.i("MicroMsg.Tinker.TinkerBootsSysCmdMsgListener", "ignore:%s md5 %s start checkout tinker update. try to do update.", new Object[] { Integer.valueOf(i), parama });
          long l = com.tencent.mm.kernel.a.agb();
          localObject = com.tinkerboots.sdk.a.fMx().mO("uin", String.valueOf(l & 0xFFFFFFFF));
          if ((!ax.isWifi(ai.getContext())) && (i != 1)) {
            break label250;
          }
        }
      }
    }
    label250:
    for (int i = 3;; i = 2)
    {
      ((com.tinkerboots.sdk.a)localObject).mO("network", String.valueOf(i));
      if (!bs.isNullOrNil(parama)) {
        com.tinkerboots.sdk.a.fMx().mO("xmlkey", parama);
      }
      com.tinkerboots.sdk.a.fMx().zh(true);
      AppMethodBeat.o(117441);
      return;
    }
  }
  
  public final void a(f.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.h
 * JD-Core Version:    0.7.0.1
 */