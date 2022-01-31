package com.tencent.mm.plugin.hp.b;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

public final class h
  implements bx.a
{
  public final void a(e.a parama)
  {
    parama = parama.dBs;
    if (parama.kSW == 10002)
    {
      parama = aa.a(parama.svH);
      if (!bk.bl(parama)) {
        break label38;
      }
      y.w("MicroMsg.Tinker.TinkerBootsSysCmdMsgListener", "msg content is null");
    }
    label38:
    do
    {
      do
      {
        return;
        parama = bn.s(parama, "sysmsg");
      } while ((parama == null) || (parama.size() <= 0));
      localObject = (String)parama.get(".sysmsg.$type");
    } while ((bk.bl((String)localObject)) || (!((String)localObject).equalsIgnoreCase("checktinkerupdate")));
    int i = bk.ZR((String)parama.get(".sysmsg.tinkerboots.ignorenetwork"));
    parama = bk.aM((String)parama.get(".sysmsg.tinkerboots.xmlkey"), "");
    y.i("MicroMsg.Tinker.TinkerBootsSysCmdMsgListener", "ignore:%s md5 %s start checkout tinker update. try to do update.", new Object[] { Integer.valueOf(i), parama });
    long l = com.tencent.mm.kernel.a.De();
    Object localObject = com.tinkerboots.sdk.a.cTY().gV("uin", String.valueOf(l & 0xFFFFFFFF));
    if ((aq.isWifi(ae.getContext())) || (i == 1)) {}
    for (i = 3;; i = 2)
    {
      ((com.tinkerboots.sdk.a)localObject).gV("network", String.valueOf(i));
      if (!bk.bl(parama)) {
        com.tinkerboots.sdk.a.cTY().gV("xmlkey", parama);
      }
      com.tinkerboots.sdk.a.cTY().oy(true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.h
 * JD-Core Version:    0.7.0.1
 */