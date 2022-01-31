package com.tencent.mm.plugin.aa;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.x.a;
import com.tencent.mm.x.c;
import java.util.Map;

final class b$5
  implements o
{
  b$5(b paramb) {}
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(40584);
    int i = bo.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), 0);
    ab.d("MicroMsg.SubCoreAA", "paymsgtype: %d, current version: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(d.whH) });
    int i1;
    int n;
    int m;
    int k;
    int j;
    if (i == 32)
    {
      i = bo.getInt((String)paramMap.get(".sysmsg.paymsg.receiveorpayreddot"), -1);
      i1 = bo.getInt((String)paramMap.get(".sysmsg.paymsg.grouppayreddot"), -1);
      n = bo.getInt((String)paramMap.get(".sysmsg.paymsg.facingreceivereddot"), -1);
      m = bo.getInt((String)paramMap.get(".sysmsg.paymsg.f2fhongbaoreddot"), -1);
      k = bo.getInt((String)paramMap.get(".sysmsg.paymsg.rewardcodereddot"), -1);
      j = bo.getInt((String)paramMap.get(".sysmsg.paymsg.android_minclientversion"), -1);
      paramString = bo.bf((String)paramMap.get(".sysmsg.paymsg.facingreceivereddotwording"), "");
      g.RM();
      g.RL().Ru().set(ac.a.yHR, paramString);
      ab.i("MicroMsg.SubCoreAA", "recvOrPay: %s, aa: %s, collect： %s, f2fhb: %s, qrreward: %s, version： %s", new Object[] { Integer.valueOf(i), Integer.valueOf(i1), Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(j) });
      if (d.whH >= j)
      {
        j = 0;
        if (i != 1) {
          break label436;
        }
        ab.i("MicroMsg.SubCoreAA", "mark recv or pay red dot");
        c.PJ().y(262159, true);
        if (i1 != 1) {
          break label453;
        }
        ab.i("MicroMsg.SubCoreAA", "mark group pay red dot");
        c.PJ().b(ac.a.yIA, true);
        i = 1;
        label312:
        if (n != 1) {
          break label479;
        }
        ab.i("MicroMsg.SubCoreAA", "mark f2f recv red dot");
        c.PJ().b(ac.a.yIB, true);
        j = 1;
        label338:
        if (m != 1) {
          break label505;
        }
        ab.i("MicroMsg.SubCoreAA", "mark f2f hb red dot");
        c.PJ().b(ac.a.yIC, true);
        i = 1;
        label364:
        if (k != 1) {
          break label531;
        }
        ab.i("MicroMsg.SubCoreAA", "mark qr reward red dot");
        c.PJ().b(ac.a.yID, true);
        j = 1;
      }
    }
    for (;;)
    {
      if (j != 0) {
        g.RL().Ru().set(ac.a.yIF, Boolean.FALSE);
      }
      h.qsU.e(14396, new Object[] { Integer.valueOf(1) });
      AppMethodBeat.o(40584);
      return;
      label436:
      if (i != 0) {
        break;
      }
      c.PJ().y(262159, false);
      break;
      label453:
      i = j;
      if (i1 != 0) {
        break label312;
      }
      c.PJ().b(ac.a.yIA, false);
      i = j;
      break label312;
      label479:
      j = i;
      if (n != 0) {
        break label338;
      }
      c.PJ().b(ac.a.yIB, false);
      j = i;
      break label338;
      label505:
      i = j;
      if (m != 0) {
        break label364;
      }
      c.PJ().b(ac.a.yIC, false);
      i = j;
      break label364;
      label531:
      j = i;
      if (k == 0)
      {
        c.PJ().b(ac.a.yID, false);
        j = i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.b.5
 * JD-Core Version:    0.7.0.1
 */