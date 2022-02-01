package com.tencent.mm.plugin.appbrand.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bq;
import com.tencent.mm.modelappbrand.m;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import java.util.Map;

public enum d
  implements s
{
  static
  {
    AppMethodBeat.i(47714);
    qhb = new d("INSTANCE");
    qhc = new d[] { qhb };
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
    paramString = ((m)h.ae(m.class)).SJ(paramMap);
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
    if ((parama == null) || (parama.jQG == null))
    {
      Log.e("MicroMsg.WxaSubscribeSysmsgHandler", "addMsgInfo or addMsgInfo.addMsg is null! should not happen");
      AppMethodBeat.o(47713);
      return null;
    }
    paramMap = parama.jQG;
    String str1 = com.tencent.mm.platformtools.z.a(paramMap.RIF);
    String str2 = com.tencent.mm.platformtools.z.a(paramMap.RID);
    String str3 = com.tencent.mm.platformtools.z.a(paramMap.RIE);
    paramString = ((n)h.ae(n.class)).eSe().aL(str2, paramMap.HlH);
    int i = 0;
    if (paramString.field_msgId > 0L) {
      i = 1;
    }
    paramString.EG(paramMap.HlH);
    if ((!parama.lCc) || (!parama.lCe)) {
      paramString.setCreateTime(bq.z(str2, paramMap.CreateTime));
    }
    paramString.setType(603979825);
    paramString.setContent(str1);
    paramString.pJ(0);
    paramString.setStatus(3);
    if (str2.equals(com.tencent.mm.model.z.bcZ()))
    {
      paramString.Jm(str3);
      paramString.Ip(paramMap.RII);
      bq.a(paramString, parama);
      if (i != 0) {
        break label474;
      }
      bq.z(paramString);
      label373:
      paramMap = ((n)h.ae(n.class)).bbR().bwx(paramString.field_talker);
      if (paramMap == null) {
        break label500;
      }
      paramMap.rn(33554432);
      i = ((n)h.ae(n.class)).bbR().a(paramMap, paramString.field_talker);
      Log.d("MicroMsg.WxaSubscribeSysmsgHandler", "username:%s ok:%b", new Object[] { paramString.field_talker, Integer.valueOf(i) });
    }
    for (;;)
    {
      AppMethodBeat.o(47713);
      return null;
      paramString.Jm(str2);
      break;
      label474:
      ((n)h.ae(n.class)).eSe().b(paramMap.HlH, paramString);
      break label373;
      label500:
      Log.d("MicroMsg.WxaSubscribeSysmsgHandler", "conv is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.message.d
 * JD-Core Version:    0.7.0.1
 */