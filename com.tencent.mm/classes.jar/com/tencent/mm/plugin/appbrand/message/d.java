package com.tencent.mm.plugin.appbrand.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a.c;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.u;
import com.tencent.mm.modelappbrand.m;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bu;
import java.util.Map;

public enum d
  implements p
{
  static
  {
    AppMethodBeat.i(47714);
    lUi = new d("INSTANCE");
    lUj = new d[] { lUi };
    AppMethodBeat.o(47714);
  }
  
  private d() {}
  
  public final e.b a(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(47713);
    if ((paramString == null) || (!paramString.equals("subscribesysmsg")))
    {
      ad.e("MicroMsg.WxaSubscribeSysmsgHandler", "subType is err, return");
      AppMethodBeat.o(47713);
      return null;
    }
    paramMap = (String)paramMap.get(".sysmsg.subscribesysmsg.content_template.link_list.link.share_key");
    if (bt.isNullOrNil(paramMap))
    {
      ad.e("MicroMsg.WxaSubscribeSysmsgHandler", "shareKey is null, return");
      AppMethodBeat.o(47713);
      return null;
    }
    ad.i("MicroMsg.WxaSubscribeSysmsgHandler", "consumeNewXml subType:%s", new Object[] { paramString });
    paramString = ((m)g.ab(m.class)).Cd(paramMap);
    if (paramString == null)
    {
      ad.e("MicroMsg.WxaSubscribeSysmsgHandler", "shareKey:%s wxaUpdateableMsg is null, ingore", new Object[] { paramMap });
      AppMethodBeat.o(47713);
      return null;
    }
    if ((paramString.field_btnState != 2) || (paramString.field_msgState != 0))
    {
      ad.e("MicroMsg.WxaSubscribeSysmsgHandler", "shareKey:%s btnState:%d msgState:%d ingore", new Object[] { paramMap, Integer.valueOf(paramString.field_btnState), Integer.valueOf(paramString.field_msgState) });
      AppMethodBeat.o(47713);
      return null;
    }
    if ((parama == null) || (parama.gqE == null))
    {
      ad.e("MicroMsg.WxaSubscribeSysmsgHandler", "addMsgInfo or addMsgInfo.addMsg is null! should not happen");
      AppMethodBeat.o(47713);
      return null;
    }
    paramMap = parama.gqE;
    String str1 = z.a(paramMap.Fvk);
    String str2 = z.a(paramMap.Fvi);
    String str3 = z.a(paramMap.Fvj);
    paramString = ((l)g.ab(l.class)).dlK().aI(str2, paramMap.xbt);
    int i = 0;
    if (paramString.field_msgId > 0L) {
      i = 1;
    }
    paramString.qz(paramMap.xbt);
    if ((!parama.hNU) || (!parama.hNW)) {
      paramString.qA(bj.B(str2, paramMap.CreateTime));
    }
    paramString.setType(603979825);
    paramString.setContent(str1);
    paramString.kr(0);
    paramString.setStatus(3);
    if (str2.equals(u.aAm()))
    {
      paramString.tN(str3);
      paramString.sP(paramMap.Fvn);
      bj.a(paramString, parama);
      if (i != 0) {
        break label474;
      }
      bj.v(paramString);
      label373:
      paramMap = ((l)g.ab(l.class)).azv().aTz(paramString.field_talker);
      if (paramMap == null) {
        break label500;
      }
      paramMap.lO(33554432);
      i = ((l)g.ab(l.class)).azv().a(paramMap, paramString.field_talker);
      ad.d("MicroMsg.WxaSubscribeSysmsgHandler", "username:%s ok:%b", new Object[] { paramString.field_talker, Integer.valueOf(i) });
    }
    for (;;)
    {
      AppMethodBeat.o(47713);
      return null;
      paramString.tN(str2);
      break;
      label474:
      ((l)g.ab(l.class)).dlK().b(paramMap.xbt, paramString);
      break label373;
      label500:
      ad.d("MicroMsg.WxaSubscribeSysmsgHandler", "conv is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.message.d
 * JD-Core Version:    0.7.0.1
 */