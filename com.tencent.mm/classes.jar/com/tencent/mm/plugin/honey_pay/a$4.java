package com.tencent.mm.plugin.honey_pay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.net.URLDecoder;
import java.util.Map;

final class a$4
  implements q
{
  a$4(a parama) {}
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, h.a parama)
  {
    AppMethodBeat.i(64605);
    if (Util.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), 0) == 35)
    {
      Log.i("MicroMsg.SubCoreHoneyPay", "receive honey pay newxml");
      String str2 = (String)paramMap.get(".sysmsg.paymsg.appmsgcontent");
      parama = (String)paramMap.get(".sysmsg.paymsg.fromusername");
      paramString = (String)paramMap.get(".sysmsg.paymsg.tousername");
      String str1 = (String)paramMap.get(".sysmsg.paymsg.paymsgid");
      paramMap = (String)paramMap.get(".sysmsg.paymsg.systip");
      if (!Util.isNullOrNil(str2))
      {
        str2 = URLDecoder.decode(str2);
        Log.d("MicroMsg.SubCoreHoneyPay", "appmsg: %s", new Object[] { str2 });
        c.s(str1, str2, paramString, parama);
      }
      if (!Util.isNullOrNil(paramMap))
      {
        paramMap = URLDecoder.decode(paramMap);
        Log.d("MicroMsg.SubCoreHoneyPay", "systip: %s", new Object[] { paramMap });
        Log.i("MicroMsg.HoneyPayUtil", "insert sys msg: %s, %s", new Object[] { paramString, Boolean.valueOf(Util.isNullOrNil(paramMap)) });
        if ((!Util.isNullOrNil(paramMap)) && (!Util.isNullOrNil(paramString)))
        {
          paramMap = c.W(c.W(paramMap, paramString, -1), parama, -1);
          parama = new ca();
          parama.nv(0);
          parama.Cy(paramString);
          parama.setStatus(3);
          parama.setContent(paramMap);
          parama.setCreateTime(bp.C(paramString, System.currentTimeMillis() / 1000L));
          parama.setType(10000);
          parama.setFlag(parama.field_flag | 0x8);
          long l = ((l)g.af(l.class)).eiy().aC(parama);
          Log.i("MicroMsg.HoneyPayUtil", "insert msgId: %s", new Object[] { Long.valueOf(l) });
          if (l <= 0L) {
            Log.w("MicroMsg.HoneyPayUtil", "insert sys msg fail!");
          }
        }
      }
    }
    AppMethodBeat.o(64605);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.4
 * JD-Core Version:    0.7.0.1
 */