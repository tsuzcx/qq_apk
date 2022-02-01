package com.tencent.mm.plugin.honey_pay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import java.net.URLDecoder;
import java.util.Map;

final class a$4
  implements p
{
  a$4(a parama) {}
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, f.a parama)
  {
    AppMethodBeat.i(64605);
    if (bs.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), 0) == 35)
    {
      ac.i("MicroMsg.SubCoreHoneyPay", "receive honey pay newxml");
      String str2 = (String)paramMap.get(".sysmsg.paymsg.appmsgcontent");
      parama = (String)paramMap.get(".sysmsg.paymsg.fromusername");
      paramString = (String)paramMap.get(".sysmsg.paymsg.tousername");
      String str1 = (String)paramMap.get(".sysmsg.paymsg.paymsgid");
      paramMap = (String)paramMap.get(".sysmsg.paymsg.systip");
      if (!bs.isNullOrNil(str2))
      {
        str2 = URLDecoder.decode(str2);
        ac.d("MicroMsg.SubCoreHoneyPay", "appmsg: %s", new Object[] { str2 });
        c.p(str1, str2, paramString, parama);
      }
      if (!bs.isNullOrNil(paramMap))
      {
        paramMap = URLDecoder.decode(paramMap);
        ac.d("MicroMsg.SubCoreHoneyPay", "systip: %s", new Object[] { paramMap });
        ac.i("MicroMsg.HoneyPayUtil", "insert sys msg: %s, %s", new Object[] { paramString, Boolean.valueOf(bs.isNullOrNil(paramMap)) });
        if ((!bs.isNullOrNil(paramMap)) && (!bs.isNullOrNil(paramString)))
        {
          paramMap = c.R(c.R(paramMap, paramString, -1), parama, -1);
          parama = new bo();
          parama.jT(0);
          parama.re(paramString);
          parama.setStatus(3);
          parama.setContent(paramMap);
          parama.oA(bi.z(paramString, System.currentTimeMillis() / 1000L));
          parama.setType(10000);
          parama.setFlag(parama.field_flag | 0x8);
          long l = ((k)g.ab(k.class)).dcr().ap(parama);
          ac.i("MicroMsg.HoneyPayUtil", "insert msgId: %s", new Object[] { Long.valueOf(l) });
          if (l <= 0L) {
            ac.w("MicroMsg.HoneyPayUtil", "insert sys msg fail!");
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