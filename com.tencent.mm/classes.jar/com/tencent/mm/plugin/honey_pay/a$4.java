package com.tencent.mm.plugin.honey_pay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.net.URLDecoder;
import java.util.Map;

final class a$4
  implements o
{
  a$4(a parama) {}
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(41710);
    if (bo.getInt((String)paramMap.get(".sysmsg.paymsg.PayMsgType"), 0) == 35)
    {
      ab.i("MicroMsg.SubCoreHoneyPay", "receive honey pay newxml");
      String str2 = (String)paramMap.get(".sysmsg.paymsg.appmsgcontent");
      paramString = (String)paramMap.get(".sysmsg.paymsg.fromusername");
      parama = (String)paramMap.get(".sysmsg.paymsg.tousername");
      String str1 = (String)paramMap.get(".sysmsg.paymsg.paymsgid");
      paramMap = (String)paramMap.get(".sysmsg.paymsg.systip");
      if (!bo.isNullOrNil(str2))
      {
        str2 = URLDecoder.decode(str2);
        ab.d("MicroMsg.SubCoreHoneyPay", "appmsg: %s", new Object[] { str2 });
        c.o(str1, str2, parama, paramString);
      }
      if (!bo.isNullOrNil(paramMap))
      {
        paramMap = URLDecoder.decode(paramMap);
        ab.d("MicroMsg.SubCoreHoneyPay", "systip: %s", new Object[] { paramMap });
        c.X(parama, paramMap, paramString);
      }
    }
    AppMethodBeat.o(41710);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.4
 * JD-Core Version:    0.7.0.1
 */