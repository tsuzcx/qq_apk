package com.tencent.mm.plugin.appbrand.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.c;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.u;
import com.tencent.mm.modelappbrand.m;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bo;
import java.util.Map;

public enum d
  implements o
{
  static
  {
    AppMethodBeat.i(47714);
    luZ = new d("INSTANCE");
    lva = new d[] { luZ };
    AppMethodBeat.o(47714);
  }
  
  private d() {}
  
  public final f.b a(String paramString, Map<String, String> paramMap, f.a parama)
  {
    AppMethodBeat.i(47713);
    if ((paramString == null) || (!paramString.equals("subscribesysmsg")))
    {
      ac.e("MicroMsg.WxaSubscribeSysmsgHandler", "subType is err, return");
      AppMethodBeat.o(47713);
      return null;
    }
    paramMap = (String)paramMap.get(".sysmsg.subscribesysmsg.content_template.link_list.link.share_key");
    if (bs.isNullOrNil(paramMap))
    {
      ac.e("MicroMsg.WxaSubscribeSysmsgHandler", "shareKey is null, return");
      AppMethodBeat.o(47713);
      return null;
    }
    ac.i("MicroMsg.WxaSubscribeSysmsgHandler", "consumeNewXml subType:%s", new Object[] { paramString });
    paramString = ((m)g.ab(m.class)).ze(paramMap);
    if (paramString == null)
    {
      ac.e("MicroMsg.WxaSubscribeSysmsgHandler", "shareKey:%s wxaUpdateableMsg is null, ingore", new Object[] { paramMap });
      AppMethodBeat.o(47713);
      return null;
    }
    if ((paramString.field_btnState != 2) || (paramString.field_msgState != 0))
    {
      ac.e("MicroMsg.WxaSubscribeSysmsgHandler", "shareKey:%s btnState:%d msgState:%d ingore", new Object[] { paramMap, Integer.valueOf(paramString.field_btnState), Integer.valueOf(paramString.field_msgState) });
      AppMethodBeat.o(47713);
      return null;
    }
    if ((parama == null) || (parama.fXi == null))
    {
      ac.e("MicroMsg.WxaSubscribeSysmsgHandler", "addMsgInfo or addMsgInfo.addMsg is null! should not happen");
      AppMethodBeat.o(47713);
      return null;
    }
    paramMap = parama.fXi;
    String str1 = z.a(paramMap.DPV);
    String str2 = z.a(paramMap.DPT);
    String str3 = z.a(paramMap.DPU);
    paramString = ((k)g.ab(k.class)).dcr().aF(str2, paramMap.vTQ);
    int i = 0;
    if (paramString.field_msgId > 0L) {
      i = 1;
    }
    paramString.oz(paramMap.vTQ);
    if ((!parama.hvF) || (!parama.hvH)) {
      paramString.oA(bi.z(str2, paramMap.CreateTime));
    }
    paramString.setType(603979825);
    paramString.setContent(str1);
    paramString.jT(0);
    paramString.setStatus(3);
    if (str2.equals(u.axw()))
    {
      paramString.re(str3);
      paramString.qf(paramMap.DPY);
      bi.a(paramString, parama);
      if (i != 0) {
        break label474;
      }
      bi.u(paramString);
      label373:
      paramMap = ((k)g.ab(k.class)).awG().aNI(paramString.field_talker);
      if (paramMap == null) {
        break label500;
      }
      paramMap.lp(33554432);
      i = ((k)g.ab(k.class)).awG().a(paramMap, paramString.field_talker);
      ac.d("MicroMsg.WxaSubscribeSysmsgHandler", "username:%s ok:%b", new Object[] { paramString.field_talker, Integer.valueOf(i) });
    }
    for (;;)
    {
      AppMethodBeat.o(47713);
      return null;
      paramString.re(str2);
      break;
      label474:
      ((k)g.ab(k.class)).dcr().b(paramMap.vTQ, paramString);
      break label373;
      label500:
      ac.d("MicroMsg.WxaSubscribeSysmsgHandler", "conv is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.message.d
 * JD-Core Version:    0.7.0.1
 */