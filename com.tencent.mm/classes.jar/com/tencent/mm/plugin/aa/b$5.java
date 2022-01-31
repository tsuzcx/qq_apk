package com.tencent.mm.plugin.aa;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.y.a;
import com.tencent.mm.y.c;
import java.util.Map;

final class b$5
  implements o
{
  b$5(b paramb) {}
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, e.a parama)
  {
    int i = bk.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), 0);
    y.d("MicroMsg.SubCoreAA", "paymsgtype: %d, current version: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(d.spa) });
    int i1;
    int n;
    int m;
    int k;
    int j;
    if (i == 32)
    {
      i = bk.getInt((String)paramMap.get(".sysmsg.paymsg.receiveorpayreddot"), -1);
      i1 = bk.getInt((String)paramMap.get(".sysmsg.paymsg.grouppayreddot"), -1);
      n = bk.getInt((String)paramMap.get(".sysmsg.paymsg.facingreceivereddot"), -1);
      m = bk.getInt((String)paramMap.get(".sysmsg.paymsg.f2fhongbaoreddot"), -1);
      k = bk.getInt((String)paramMap.get(".sysmsg.paymsg.rewardcodereddot"), -1);
      j = bk.getInt((String)paramMap.get(".sysmsg.paymsg.android_minclientversion"), -1);
      paramString = bk.aM((String)paramMap.get(".sysmsg.paymsg.facingreceivereddotwording"), "");
      g.DQ();
      g.DP().Dz().c(ac.a.uxH, paramString);
      y.i("MicroMsg.SubCoreAA", "recvOrPay: %s, aa: %s, collect： %s, f2fhb: %s, qrreward: %s, version： %s", new Object[] { Integer.valueOf(i), Integer.valueOf(i1), Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(j) });
      if (d.spa >= j)
      {
        j = 0;
        if (i != 1) {
          break label427;
        }
        y.i("MicroMsg.SubCoreAA", "mark recv or pay red dot");
        c.BS().w(262159, true);
        if (i1 != 1) {
          break label444;
        }
        y.i("MicroMsg.SubCoreAA", "mark group pay red dot");
        c.BS().b(ac.a.uyq, true);
        i = 1;
        label307:
        if (n != 1) {
          break label470;
        }
        y.i("MicroMsg.SubCoreAA", "mark f2f recv red dot");
        c.BS().b(ac.a.uyr, true);
        j = 1;
        label333:
        if (m != 1) {
          break label496;
        }
        y.i("MicroMsg.SubCoreAA", "mark f2f hb red dot");
        c.BS().b(ac.a.uys, true);
        i = 1;
        label359:
        if (k != 1) {
          break label522;
        }
        y.i("MicroMsg.SubCoreAA", "mark qr reward red dot");
        c.BS().b(ac.a.uyt, true);
        j = 1;
      }
    }
    for (;;)
    {
      if (j != 0) {
        g.DP().Dz().c(ac.a.uyv, Boolean.valueOf(false));
      }
      h.nFQ.f(14396, new Object[] { Integer.valueOf(1) });
      return;
      label427:
      if (i != 0) {
        break;
      }
      c.BS().w(262159, false);
      break;
      label444:
      i = j;
      if (i1 != 0) {
        break label307;
      }
      c.BS().b(ac.a.uyq, false);
      i = j;
      break label307;
      label470:
      j = i;
      if (n != 0) {
        break label333;
      }
      c.BS().b(ac.a.uyr, false);
      j = i;
      break label333;
      label496:
      i = j;
      if (m != 0) {
        break label359;
      }
      c.BS().b(ac.a.uys, false);
      i = j;
      break label359;
      label522:
      j = i;
      if (k == 0)
      {
        c.BS().b(ac.a.uyt, false);
        j = i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.b.5
 * JD-Core Version:    0.7.0.1
 */