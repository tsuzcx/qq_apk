package com.tencent.mm.plugin.appbrand.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import java.util.Map;

public enum b
  implements n
{
  static
  {
    AppMethodBeat.i(132273);
    irz = new b("INSTANCE");
    irA = new b[] { irz };
    AppMethodBeat.o(132273);
  }
  
  private b() {}
  
  public final e.b a(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(132272);
    if ((paramString == null) || (!paramString.equals("subscribesysmsg")))
    {
      ab.e("MicroMsg.WxaSubscribeSysmsgHandler", "subType is err, return");
      AppMethodBeat.o(132272);
      return null;
    }
    paramMap = (String)paramMap.get(".sysmsg.subscribesysmsg.content_template.link_list.link.share_key");
    if (bo.isNullOrNil(paramMap))
    {
      ab.e("MicroMsg.WxaSubscribeSysmsgHandler", "shareKey is null, return");
      AppMethodBeat.o(132272);
      return null;
    }
    ab.i("MicroMsg.WxaSubscribeSysmsgHandler", "consumeNewXml subType:%s", new Object[] { paramString });
    paramString = ((k)g.E(k.class)).qj(paramMap);
    if (paramString == null)
    {
      ab.e("MicroMsg.WxaSubscribeSysmsgHandler", "shareKey:%s wxaUpdateableMsg is null, ingore", new Object[] { paramMap });
      AppMethodBeat.o(132272);
      return null;
    }
    if ((paramString.field_btnState != 2) || (paramString.field_msgState != 0))
    {
      ab.e("MicroMsg.WxaSubscribeSysmsgHandler", "shareKey:%s btnState:%d msgState:%d ingore", new Object[] { paramMap, Integer.valueOf(paramString.field_btnState), Integer.valueOf(paramString.field_msgState) });
      AppMethodBeat.o(132272);
      return null;
    }
    if ((parama == null) || (parama.eyJ == null))
    {
      ab.e("MicroMsg.WxaSubscribeSysmsgHandler", "addMsgInfo or addMsgInfo.addMsg is null! should not happen");
      AppMethodBeat.o(132272);
      return null;
    }
    paramMap = parama.eyJ;
    String str1 = aa.a(paramMap.woR);
    String str2 = aa.a(paramMap.woP);
    String str3 = aa.a(paramMap.woQ);
    paramString = ((j)g.E(j.class)).bPQ().ag(str2, paramMap.pIG);
    int i = 0;
    if (paramString.field_msgId > 0L) {
      i = 1;
    }
    paramString.fP(paramMap.pIG);
    if ((!parama.fte) || (!parama.ftg)) {
      paramString.fQ(bf.x(str2, paramMap.CreateTime));
    }
    paramString.setType(603979825);
    paramString.setContent(str1);
    paramString.hL(0);
    paramString.setStatus(3);
    if (str2.equals(r.Zn()))
    {
      paramString.kj(str3);
      paramString.jl(paramMap.woU);
      bf.a(paramString, parama);
      if (i != 0) {
        break label474;
      }
      bf.l(paramString);
      label373:
      paramMap = ((j)g.E(j.class)).YF().arH(paramString.field_talker);
      if (paramMap == null) {
        break label500;
      }
      paramMap.jg(33554432);
      i = ((j)g.E(j.class)).YF().a(paramMap, paramString.field_talker);
      ab.d("MicroMsg.WxaSubscribeSysmsgHandler", "username:%s ok:%b", new Object[] { paramString.field_talker, Integer.valueOf(i) });
    }
    for (;;)
    {
      AppMethodBeat.o(132272);
      return null;
      paramString.kj(str2);
      break;
      label474:
      ((j)g.E(j.class)).bPQ().b(paramMap.pIG, paramString);
      break label373;
      label500:
      ab.d("MicroMsg.WxaSubscribeSysmsgHandler", "conv is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.b
 * JD-Core Version:    0.7.0.1
 */