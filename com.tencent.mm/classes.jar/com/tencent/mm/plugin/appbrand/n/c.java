package com.tencent.mm.plugin.appbrand.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.u;
import com.tencent.mm.modelappbrand.m;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bl;
import java.util.Map;

public enum c
  implements o
{
  static
  {
    AppMethodBeat.i(47714);
    kTu = new c("INSTANCE");
    kTv = new c[] { kTu };
    AppMethodBeat.o(47714);
  }
  
  private c() {}
  
  public final f.b a(String paramString, Map<String, String> paramMap, f.a parama)
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
    paramString = ((m)g.ab(m.class)).uY(paramMap);
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
    if ((parama == null) || (parama.fTo == null))
    {
      ad.e("MicroMsg.WxaSubscribeSysmsgHandler", "addMsgInfo or addMsgInfo.addMsg is null! should not happen");
      AppMethodBeat.o(47713);
      return null;
    }
    paramMap = parama.fTo;
    String str1 = z.a(paramMap.Cxz);
    String str2 = z.a(paramMap.Cxx);
    String str3 = z.a(paramMap.Cxy);
    paramString = ((k)g.ab(k.class)).cOI().aD(str2, paramMap.uKZ);
    int i = 0;
    if (paramString.field_msgId > 0L) {
      i = 1;
    }
    paramString.kX(paramMap.uKZ);
    if ((!parama.gVg) || (!parama.gVi)) {
      paramString.kY(bi.y(str2, paramMap.CreateTime));
    }
    paramString.setType(603979825);
    paramString.setContent(str1);
    paramString.jV(0);
    paramString.setStatus(3);
    if (str2.equals(u.aqG()))
    {
      paramString.nY(str3);
      paramString.mZ(paramMap.CxC);
      bi.a(paramString, parama);
      if (i != 0) {
        break label474;
      }
      bi.u(paramString);
      label373:
      paramMap = ((k)g.ab(k.class)).apR().aIn(paramString.field_talker);
      if (paramMap == null) {
        break label500;
      }
      paramMap.lu(33554432);
      i = ((k)g.ab(k.class)).apR().a(paramMap, paramString.field_talker);
      ad.d("MicroMsg.WxaSubscribeSysmsgHandler", "username:%s ok:%b", new Object[] { paramString.field_talker, Integer.valueOf(i) });
    }
    for (;;)
    {
      AppMethodBeat.o(47713);
      return null;
      paramString.nY(str2);
      break;
      label474:
      ((k)g.ab(k.class)).cOI().b(paramMap.uKZ, paramString);
      break label373;
      label500:
      ad.d("MicroMsg.WxaSubscribeSysmsgHandler", "conv is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.c
 * JD-Core Version:    0.7.0.1
 */