package com.tencent.mm.plugin.aa;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.a;
import com.tencent.mm.aa.c;
import com.tencent.mm.an.h.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Map;

final class b$5
  implements t
{
  b$5(b paramb) {}
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, h.a parama)
  {
    AppMethodBeat.i(63310);
    int i = Util.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), 0);
    Log.d("MicroMsg.SubCoreAA", "paymsgtype: %d, current version: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(d.RAD) });
    int i1;
    int n;
    int m;
    int k;
    int j;
    if (i == 32)
    {
      i = Util.getInt((String)paramMap.get(".sysmsg.paymsg.receiveorpayreddot"), -1);
      i1 = Util.getInt((String)paramMap.get(".sysmsg.paymsg.grouppayreddot"), -1);
      n = Util.getInt((String)paramMap.get(".sysmsg.paymsg.facingreceivereddot"), -1);
      m = Util.getInt((String)paramMap.get(".sysmsg.paymsg.f2fhongbaoreddot"), -1);
      k = Util.getInt((String)paramMap.get(".sysmsg.paymsg.rewardcodereddot"), -1);
      j = Util.getInt((String)paramMap.get(".sysmsg.paymsg.android_minclientversion"), -1);
      paramString = Util.nullAs((String)paramMap.get(".sysmsg.paymsg.facingreceivereddotwording"), "");
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vsa, paramString);
      Log.i("MicroMsg.SubCoreAA", "recvOrPay: %s, aa: %s, collect： %s, f2fhb: %s, qrreward: %s, version： %s", new Object[] { Integer.valueOf(i), Integer.valueOf(i1), Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(j) });
      if (d.RAD >= j)
      {
        j = 0;
        if (i != 1) {
          break label436;
        }
        Log.i("MicroMsg.SubCoreAA", "mark recv or pay red dot");
        c.aFn().D(262159, true);
        if (i1 != 1) {
          break label453;
        }
        Log.i("MicroMsg.SubCoreAA", "mark group pay red dot");
        c.aFn().b(ar.a.VsK, true);
        i = 1;
        label312:
        if (n != 1) {
          break label479;
        }
        Log.i("MicroMsg.SubCoreAA", "mark f2f recv red dot");
        c.aFn().b(ar.a.VsL, true);
        j = 1;
        label338:
        if (m != 1) {
          break label505;
        }
        Log.i("MicroMsg.SubCoreAA", "mark f2f hb red dot");
        c.aFn().b(ar.a.VsM, true);
        i = 1;
        label364:
        if (k != 1) {
          break label531;
        }
        Log.i("MicroMsg.SubCoreAA", "mark qr reward red dot");
        c.aFn().b(ar.a.VsN, true);
        j = 1;
      }
    }
    for (;;)
    {
      if (j != 0) {
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VsP, Boolean.FALSE);
      }
      com.tencent.mm.plugin.report.service.h.IzE.a(14396, new Object[] { Integer.valueOf(1) });
      AppMethodBeat.o(63310);
      return;
      label436:
      if (i != 0) {
        break;
      }
      c.aFn().D(262159, false);
      break;
      label453:
      i = j;
      if (i1 != 0) {
        break label312;
      }
      c.aFn().b(ar.a.VsK, false);
      i = j;
      break label312;
      label479:
      j = i;
      if (n != 0) {
        break label338;
      }
      c.aFn().b(ar.a.VsL, false);
      j = i;
      break label338;
      label505:
      i = j;
      if (m != 0) {
        break label364;
      }
      c.aFn().b(ar.a.VsM, false);
      i = j;
      break label364;
      label531:
      j = i;
      if (k == 0)
      {
        c.aFn().b(ar.a.VsN, false);
        j = i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.b.5
 * JD-Core Version:    0.7.0.1
 */