package com.tencent.mm.plugin.honey_pay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bj;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import java.net.URLDecoder;
import java.util.Map;

final class a$4
  implements q
{
  a$4(a parama) {}
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(64605);
    if (bt.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), 0) == 35)
    {
      ad.i("MicroMsg.SubCoreHoneyPay", "receive honey pay newxml");
      String str2 = (String)paramMap.get(".sysmsg.paymsg.appmsgcontent");
      parama = (String)paramMap.get(".sysmsg.paymsg.fromusername");
      paramString = (String)paramMap.get(".sysmsg.paymsg.tousername");
      String str1 = (String)paramMap.get(".sysmsg.paymsg.paymsgid");
      paramMap = (String)paramMap.get(".sysmsg.paymsg.systip");
      if (!bt.isNullOrNil(str2))
      {
        str2 = URLDecoder.decode(str2);
        ad.d("MicroMsg.SubCoreHoneyPay", "appmsg: %s", new Object[] { str2 });
        c.o(str1, str2, paramString, parama);
      }
      if (!bt.isNullOrNil(paramMap))
      {
        paramMap = URLDecoder.decode(paramMap);
        ad.d("MicroMsg.SubCoreHoneyPay", "systip: %s", new Object[] { paramMap });
        ad.i("MicroMsg.HoneyPayUtil", "insert sys msg: %s, %s", new Object[] { paramString, Boolean.valueOf(bt.isNullOrNil(paramMap)) });
        if ((!bt.isNullOrNil(paramMap)) && (!bt.isNullOrNil(paramString)))
        {
          paramMap = c.U(c.U(paramMap, paramString, -1), parama, -1);
          parama = new bu();
          parama.kr(0);
          parama.tN(paramString);
          parama.setStatus(3);
          parama.setContent(paramMap);
          parama.qA(bj.B(paramString, System.currentTimeMillis() / 1000L));
          parama.setType(10000);
          parama.setFlag(parama.field_flag | 0x8);
          long l = ((l)g.ab(l.class)).dlK().as(parama);
          ad.i("MicroMsg.HoneyPayUtil", "insert msgId: %s", new Object[] { Long.valueOf(l) });
          if (l <= 0L) {
            ad.w("MicroMsg.HoneyPayUtil", "insert sys msg fail!");
          }
        }
      }
    }
    AppMethodBeat.o(64605);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.4
 * JD-Core Version:    0.7.0.1
 */