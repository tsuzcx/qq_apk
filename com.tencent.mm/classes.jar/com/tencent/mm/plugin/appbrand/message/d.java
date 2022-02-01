package com.tencent.mm.plugin.appbrand.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.c;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.v;
import com.tencent.mm.modelappbrand.m;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bv;
import java.util.Map;

public enum d
  implements p
{
  static
  {
    AppMethodBeat.i(47714);
    lYL = new d("INSTANCE");
    lYM = new d[] { lYL };
    AppMethodBeat.o(47714);
  }
  
  private d() {}
  
  public final e.b a(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(47713);
    if ((paramString == null) || (!paramString.equals("subscribesysmsg")))
    {
      ae.e("MicroMsg.WxaSubscribeSysmsgHandler", "subType is err, return");
      AppMethodBeat.o(47713);
      return null;
    }
    paramMap = (String)paramMap.get(".sysmsg.subscribesysmsg.content_template.link_list.link.share_key");
    if (bu.isNullOrNil(paramMap))
    {
      ae.e("MicroMsg.WxaSubscribeSysmsgHandler", "shareKey is null, return");
      AppMethodBeat.o(47713);
      return null;
    }
    ae.i("MicroMsg.WxaSubscribeSysmsgHandler", "consumeNewXml subType:%s", new Object[] { paramString });
    paramString = ((m)g.ab(m.class)).CF(paramMap);
    if (paramString == null)
    {
      ae.e("MicroMsg.WxaSubscribeSysmsgHandler", "shareKey:%s wxaUpdateableMsg is null, ingore", new Object[] { paramMap });
      AppMethodBeat.o(47713);
      return null;
    }
    if ((paramString.field_btnState != 2) || (paramString.field_msgState != 0))
    {
      ae.e("MicroMsg.WxaSubscribeSysmsgHandler", "shareKey:%s btnState:%d msgState:%d ingore", new Object[] { paramMap, Integer.valueOf(paramString.field_btnState), Integer.valueOf(paramString.field_msgState) });
      AppMethodBeat.o(47713);
      return null;
    }
    if ((parama == null) || (parama.gte == null))
    {
      ae.e("MicroMsg.WxaSubscribeSysmsgHandler", "addMsgInfo or addMsgInfo.addMsg is null! should not happen");
      AppMethodBeat.o(47713);
      return null;
    }
    paramMap = parama.gte;
    String str1 = z.a(paramMap.FNI);
    String str2 = z.a(paramMap.FNG);
    String str3 = z.a(paramMap.FNH);
    paramString = ((l)g.ab(l.class)).doJ().aJ(str2, paramMap.xrk);
    int i = 0;
    if (paramString.field_msgId > 0L) {
      i = 1;
    }
    paramString.qM(paramMap.xrk);
    if ((!parama.hQN) || (!parama.hQP)) {
      paramString.qN(bl.B(str2, paramMap.CreateTime));
    }
    paramString.setType(603979825);
    paramString.setContent(str1);
    paramString.kt(0);
    paramString.setStatus(3);
    if (str2.equals(v.aAC()))
    {
      paramString.ui(str3);
      paramString.tk(paramMap.FNL);
      bl.a(paramString, parama);
      if (i != 0) {
        break label474;
      }
      bl.v(paramString);
      label373:
      paramMap = ((l)g.ab(l.class)).azL().aVa(paramString.field_talker);
      if (paramMap == null) {
        break label500;
      }
      paramMap.lQ(33554432);
      i = ((l)g.ab(l.class)).azL().a(paramMap, paramString.field_talker);
      ae.d("MicroMsg.WxaSubscribeSysmsgHandler", "username:%s ok:%b", new Object[] { paramString.field_talker, Integer.valueOf(i) });
    }
    for (;;)
    {
      AppMethodBeat.o(47713);
      return null;
      paramString.ui(str2);
      break;
      label474:
      ((l)g.ab(l.class)).doJ().b(paramMap.xrk, paramString);
      break label373;
      label500:
      ae.d("MicroMsg.WxaSubscribeSysmsgHandler", "conv is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.message.d
 * JD-Core Version:    0.7.0.1
 */