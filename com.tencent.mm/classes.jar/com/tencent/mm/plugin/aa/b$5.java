package com.tencent.mm.plugin.aa;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.y.a;
import com.tencent.mm.y.c;
import java.util.Map;

final class b$5
  implements q
{
  b$5(b paramb) {}
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(63310);
    int i = bu.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), 0);
    ae.d("MicroMsg.SubCoreAA", "paymsgtype: %d, current version: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(d.FFH) });
    int i1;
    int n;
    int m;
    int k;
    int j;
    if (i == 32)
    {
      i = bu.getInt((String)paramMap.get(".sysmsg.paymsg.receiveorpayreddot"), -1);
      i1 = bu.getInt((String)paramMap.get(".sysmsg.paymsg.grouppayreddot"), -1);
      n = bu.getInt((String)paramMap.get(".sysmsg.paymsg.facingreceivereddot"), -1);
      m = bu.getInt((String)paramMap.get(".sysmsg.paymsg.f2fhongbaoreddot"), -1);
      k = bu.getInt((String)paramMap.get(".sysmsg.paymsg.rewardcodereddot"), -1);
      j = bu.getInt((String)paramMap.get(".sysmsg.paymsg.android_minclientversion"), -1);
      paramString = bu.bI((String)paramMap.get(".sysmsg.paymsg.facingreceivereddotwording"), "");
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IVx, paramString);
      ae.i("MicroMsg.SubCoreAA", "recvOrPay: %s, aa: %s, collect： %s, f2fhb: %s, qrreward: %s, version： %s", new Object[] { Integer.valueOf(i), Integer.valueOf(i1), Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(j) });
      if (d.FFH >= j)
      {
        j = 0;
        if (i != 1) {
          break label436;
        }
        ae.i("MicroMsg.SubCoreAA", "mark recv or pay red dot");
        c.ahI().x(262159, true);
        if (i1 != 1) {
          break label453;
        }
        ae.i("MicroMsg.SubCoreAA", "mark group pay red dot");
        c.ahI().b(am.a.IWh, true);
        i = 1;
        label312:
        if (n != 1) {
          break label479;
        }
        ae.i("MicroMsg.SubCoreAA", "mark f2f recv red dot");
        c.ahI().b(am.a.IWi, true);
        j = 1;
        label338:
        if (m != 1) {
          break label505;
        }
        ae.i("MicroMsg.SubCoreAA", "mark f2f hb red dot");
        c.ahI().b(am.a.IWj, true);
        i = 1;
        label364:
        if (k != 1) {
          break label531;
        }
        ae.i("MicroMsg.SubCoreAA", "mark qr reward red dot");
        c.ahI().b(am.a.IWk, true);
        j = 1;
      }
    }
    for (;;)
    {
      if (j != 0) {
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IWm, Boolean.FALSE);
      }
      com.tencent.mm.plugin.report.service.g.yxI.f(14396, new Object[] { Integer.valueOf(1) });
      AppMethodBeat.o(63310);
      return;
      label436:
      if (i != 0) {
        break;
      }
      c.ahI().x(262159, false);
      break;
      label453:
      i = j;
      if (i1 != 0) {
        break label312;
      }
      c.ahI().b(am.a.IWh, false);
      i = j;
      break label312;
      label479:
      j = i;
      if (n != 0) {
        break label338;
      }
      c.ahI().b(am.a.IWi, false);
      j = i;
      break label338;
      label505:
      i = j;
      if (m != 0) {
        break label364;
      }
      c.ahI().b(am.a.IWj, false);
      i = j;
      break label364;
      label531:
      j = i;
      if (k == 0)
      {
        c.ahI().b(am.a.IWk, false);
        j = i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.b.5
 * JD-Core Version:    0.7.0.1
 */