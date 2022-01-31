package com.tencent.mm.plugin.collect.a;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.h.a.bv;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.model.bz;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.collect.b.d;
import com.tencent.mm.plugin.collect.b.t;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class a$1
  implements bx.a
{
  a$1(a parama) {}
  
  public final void a(e.a parama)
  {
    a.aEp();
    if (a.aEq() != null)
    {
      Object localObject2 = aa.a(parama.dBs.svH);
      a.aEp();
      Object localObject1 = a.aEq();
      long l = parama.dBs.mPL;
      y.v("MicroMsg.CollectPayerMsgMgr", "func[onResvMsg] content:" + (String)localObject2);
      if (bk.bl((String)localObject2)) {
        y.d("MicroMsg.CollectPayerMsgMgr", "func[onResvMsg] Msg content empty");
      }
      do
      {
        return;
        localObject2 = bn.s((String)localObject2, "sysmsg");
        int i = bk.getInt((String)((Map)localObject2).get(".sysmsg.paymsg.PayMsgType"), 0);
        if ((i != 9) && (i != 26))
        {
          y.i("MicroMsg.CollectPayerMsgMgr", "Not ftf collect msg type, ignore; type=" + i);
          return;
        }
        parama = new t();
        parama.username = bk.pm((String)((Map)localObject2).get(".sysmsg.paymsg.username"));
        parama.iHP = (bk.getDouble((String)((Map)localObject2).get(".sysmsg.paymsg.fee"), 0.0D) / 100.0D);
        parama.bHY = bk.pm((String)((Map)localObject2).get(".sysmsg.paymsg.feetype"));
        parama.timestamp = bk.getInt((String)((Map)localObject2).get(".sysmsg.paymsgtimestamp"), (int)bk.UX());
        parama.bMY = bk.pm((String)((Map)localObject2).get(".sysmsg.paymsg.transid"));
        parama.dtK = bk.pm((String)((Map)localObject2).get(".sysmsg.paymsg.displayname"));
        parama.scene = bk.getInt((String)((Map)localObject2).get(".sysmsg.paymsg.scene"), 1);
        parama.status = bk.getInt((String)((Map)localObject2).get(".sysmsg.paymsg.status"), 0);
        parama.msgType = i;
        parama.iHQ = bk.pm((String)((Map)localObject2).get(".sysmsg.paymsg.outtradeno"));
        parama.type = bk.pm((String)((Map)localObject2).get(".sysmsg.paymsg.type"));
        ((d)localObject1).a(parama);
      } while (parama.status != 1);
      localObject1 = new bv();
      ((bv)localObject1).bHX.fee = ((int)Math.round(parama.iHP * 100.0D));
      ((bv)localObject1).bHX.bHY = parama.bHY;
      ((bv)localObject1).bHX.bIa = parama.type;
      ((bv)localObject1).bHX.bHZ = parama.iHQ;
      ((bv)localObject1).bHX.brn = (bz.Is() - l * 1000L);
      ((bv)localObject1).bHX.source = 1;
      com.tencent.mm.sdk.b.a.udP.m((b)localObject1);
      return;
    }
    y.w("MicroMsg.SubCoreCollect", "func[onRecieveMsg] payerMsgMgr null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.a.a.1
 * JD-Core Version:    0.7.0.1
 */