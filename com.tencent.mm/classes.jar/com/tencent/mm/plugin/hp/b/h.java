package com.tencent.mm.plugin.hp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import java.util.Map;

public final class h
  implements cf.a
{
  public final void a(e.a parama)
  {
    AppMethodBeat.i(117441);
    parama = parama.gte;
    Object localObject;
    if (parama.urJ == 10002)
    {
      parama = z.a(parama.FNI);
      if (bu.isNullOrNil(parama))
      {
        ae.w("MicroMsg.Tinker.TinkerBootsSysCmdMsgListener", "msg content is null");
        AppMethodBeat.o(117441);
        return;
      }
      ae.i("MicroMsg.Tinker.TinkerBootsSysCmdMsgListener", "onReciveMsg :%s", new Object[] { parama });
      parama = bx.M(parama, "sysmsg");
      if ((parama != null) && (parama.size() > 0))
      {
        localObject = (String)parama.get(".sysmsg.$type");
        if ((!bu.isNullOrNil((String)localObject)) && (((String)localObject).equalsIgnoreCase("prconfignotify")))
        {
          i = bu.aSB((String)parama.get(".sysmsg.boots.ignorenetwork"));
          parama = bu.bI((String)parama.get(".sysmsg.boots.xmlkey"), "");
          ae.i("MicroMsg.Tinker.TinkerBootsSysCmdMsgListener", "ignore:%s md5 %s start checkout tinker update. try to do update.", new Object[] { Integer.valueOf(i), parama });
          long l = com.tencent.mm.kernel.a.ajc();
          localObject = com.tinkerboots.sdk.a.gix().ns("uin", String.valueOf(l & 0xFFFFFFFF));
          if ((!az.isWifi(ak.getContext())) && (i != 1)) {
            break label250;
          }
        }
      }
    }
    label250:
    for (int i = 3;; i = 2)
    {
      ((com.tinkerboots.sdk.a)localObject).ns("network", String.valueOf(i));
      if (!bu.isNullOrNil(parama)) {
        com.tinkerboots.sdk.a.gix().ns("xmlkey", parama);
      }
      com.tinkerboots.sdk.a.gix().Ai(true);
      AppMethodBeat.o(117441);
      return;
    }
  }
  
  public final void a(e.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.h
 * JD-Core Version:    0.7.0.1
 */