package com.tencent.mm.plugin.appbrand.l;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.ah.e.b;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.q;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import java.util.Map;

public enum b
  implements n
{
  private b() {}
  
  public final e.b a(String paramString, Map<String, String> paramMap, e.a parama)
  {
    if ((paramString == null) || (!paramString.equals("subscribesysmsg")))
    {
      y.e("MicroMsg.WxaSubscribeSysmsgHandler", "subType is err, return");
      return null;
    }
    paramMap = (String)paramMap.get(".sysmsg.subscribesysmsg.content_template.link_list.link.share_key");
    if (bk.bl(paramMap))
    {
      y.e("MicroMsg.WxaSubscribeSysmsgHandler", "shareKey is null, return");
      return null;
    }
    y.i("MicroMsg.WxaSubscribeSysmsgHandler", "consumeNewXml subType:%s", new Object[] { paramString });
    paramString = ((k)com.tencent.mm.kernel.g.r(k.class)).jv(paramMap);
    if (paramString == null)
    {
      y.e("MicroMsg.WxaSubscribeSysmsgHandler", "shareKey:%s wxaUpdateableMsg is null, ingore", new Object[] { paramMap });
      return null;
    }
    if ((paramString.field_btnState != 2) || (paramString.field_msgState != 0))
    {
      y.e("MicroMsg.WxaSubscribeSysmsgHandler", "shareKey:%s btnState:%d msgState:%d ingore", new Object[] { paramMap, Integer.valueOf(paramString.field_btnState), Integer.valueOf(paramString.field_msgState) });
      return null;
    }
    if ((parama == null) || (parama.dBs == null))
    {
      y.e("MicroMsg.WxaSubscribeSysmsgHandler", "addMsgInfo or addMsgInfo.addMsg is null! should not happen");
      return null;
    }
    paramMap = parama.dBs;
    String str1 = aa.a(paramMap.svH);
    String str2 = aa.a(paramMap.svF);
    String str3 = aa.a(paramMap.svG);
    paramString = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().O(str2, paramMap.ndp);
    int i = 0;
    if (paramString.field_msgId > 0L) {
      i = 1;
    }
    paramString.bf(paramMap.ndp);
    if ((!parama.ecS) || (!parama.ecU)) {
      paramString.bg(bd.o(str2, paramMap.mPL));
    }
    paramString.setType(603979825);
    paramString.setContent(str1);
    paramString.fA(0);
    paramString.setStatus(3);
    if (str2.equals(q.Gj()))
    {
      paramString.ec(str3);
      paramString.cY(paramMap.svK);
      bd.a(paramString, parama);
      if (i != 0) {
        break label438;
      }
      bd.h(paramString);
      label343:
      paramMap = ((j)com.tencent.mm.kernel.g.r(j.class)).FB().abv(paramString.field_talker);
      if (paramMap == null) {
        break label464;
      }
      paramMap.gT(33554432);
      i = ((j)com.tencent.mm.kernel.g.r(j.class)).FB().a(paramMap, paramString.field_talker);
      y.d("MicroMsg.WxaSubscribeSysmsgHandler", "username:%s ok:%b", new Object[] { paramString.field_talker, Integer.valueOf(i) });
    }
    for (;;)
    {
      return null;
      paramString.ec(str2);
      break;
      label438:
      ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().b(paramMap.ndp, paramString);
      break label343;
      label464:
      y.d("MicroMsg.WxaSubscribeSysmsgHandler", "conv is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.l.b
 * JD-Core Version:    0.7.0.1
 */