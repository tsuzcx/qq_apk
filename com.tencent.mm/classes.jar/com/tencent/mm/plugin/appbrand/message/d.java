package com.tencent.mm.plugin.appbrand.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.a.c;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.modelappbrand.m;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import java.util.Map;

public enum d
  implements p
{
  static
  {
    AppMethodBeat.i(47714);
    ngr = new d("INSTANCE");
    ngs = new d[] { ngr };
    AppMethodBeat.o(47714);
  }
  
  private d() {}
  
  public final h.b a(String paramString, Map<String, String> paramMap, h.a parama)
  {
    AppMethodBeat.i(47713);
    if ((paramString == null) || (!paramString.equals("subscribesysmsg")))
    {
      Log.e("MicroMsg.WxaSubscribeSysmsgHandler", "subType is err, return");
      AppMethodBeat.o(47713);
      return null;
    }
    paramMap = (String)paramMap.get(".sysmsg.subscribesysmsg.content_template.link_list.link.share_key");
    if (Util.isNullOrNil(paramMap))
    {
      Log.e("MicroMsg.WxaSubscribeSysmsgHandler", "shareKey is null, return");
      AppMethodBeat.o(47713);
      return null;
    }
    Log.i("MicroMsg.WxaSubscribeSysmsgHandler", "consumeNewXml subType:%s", new Object[] { paramString });
    paramString = ((m)g.af(m.class)).Lq(paramMap);
    if (paramString == null)
    {
      Log.e("MicroMsg.WxaSubscribeSysmsgHandler", "shareKey:%s wxaUpdateableMsg is null, ingore", new Object[] { paramMap });
      AppMethodBeat.o(47713);
      return null;
    }
    if ((paramString.field_btnState != 2) || (paramString.field_msgState != 0))
    {
      Log.e("MicroMsg.WxaSubscribeSysmsgHandler", "shareKey:%s btnState:%d msgState:%d ingore", new Object[] { paramMap, Integer.valueOf(paramString.field_btnState), Integer.valueOf(paramString.field_msgState) });
      AppMethodBeat.o(47713);
      return null;
    }
    if ((parama == null) || (parama.heO == null))
    {
      Log.e("MicroMsg.WxaSubscribeSysmsgHandler", "addMsgInfo or addMsgInfo.addMsg is null! should not happen");
      AppMethodBeat.o(47713);
      return null;
    }
    paramMap = parama.heO;
    String str1 = com.tencent.mm.platformtools.z.a(paramMap.KHn);
    String str2 = com.tencent.mm.platformtools.z.a(paramMap.KHl);
    String str3 = com.tencent.mm.platformtools.z.a(paramMap.KHm);
    paramString = ((l)g.af(l.class)).eiy().aJ(str2, paramMap.Brn);
    int i = 0;
    if (paramString.field_msgId > 0L) {
      i = 1;
    }
    paramString.yF(paramMap.Brn);
    if ((!parama.iLV) || (!parama.iLX)) {
      paramString.setCreateTime(bp.C(str2, paramMap.CreateTime));
    }
    paramString.setType(603979825);
    paramString.setContent(str1);
    paramString.nv(0);
    paramString.setStatus(3);
    if (str2.equals(com.tencent.mm.model.z.aTY()))
    {
      paramString.Cy(str3);
      paramString.BB(paramMap.KHq);
      bp.a(paramString, parama);
      if (i != 0) {
        break label474;
      }
      bp.x(paramString);
      label373:
      paramMap = ((l)g.af(l.class)).aST().bjY(paramString.field_talker);
      if (paramMap == null) {
        break label500;
      }
      paramMap.oT(33554432);
      i = ((l)g.af(l.class)).aST().a(paramMap, paramString.field_talker);
      Log.d("MicroMsg.WxaSubscribeSysmsgHandler", "username:%s ok:%b", new Object[] { paramString.field_talker, Integer.valueOf(i) });
    }
    for (;;)
    {
      AppMethodBeat.o(47713);
      return null;
      paramString.Cy(str2);
      break;
      label474:
      ((l)g.af(l.class)).eiy().b(paramMap.Brn, paramString);
      break label373;
      label500:
      Log.d("MicroMsg.WxaSubscribeSysmsgHandler", "conv is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.message.d
 * JD-Core Version:    0.7.0.1
 */