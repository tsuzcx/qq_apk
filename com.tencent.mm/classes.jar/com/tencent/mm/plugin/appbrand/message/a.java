package com.tencent.mm.plugin.appbrand.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bj;
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

public enum a
  implements p
{
  static
  {
    AppMethodBeat.i(188668);
    lTU = new a("INSTANCE");
    lTV = new a[] { lTU };
    AppMethodBeat.o(188668);
  }
  
  private a() {}
  
  public final e.b a(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(188667);
    if ((paramString == null) || (!paramString.equals("weapp_pushmsg")))
    {
      ad.e("MicroMsg.WxaAppBrandNotifyMsgHandler", "subType is err, return");
      AppMethodBeat.o(188667);
      return null;
    }
    ad.i("MicroMsg.WxaAppBrandNotifyMsgHandler", "consumeNewXml subType:%s", new Object[] { paramString });
    String str1 = (String)paramMap.get(".sysmsg.weapp_pushmsg.title");
    if (bt.isNullOrNil(str1))
    {
      ad.e("MicroMsg.WxaAppBrandNotifyMsgHandler", "title is null, return");
      AppMethodBeat.o(188667);
      return null;
    }
    if (bt.isNullOrNil((String)paramMap.get(".sysmsg.weapp_pushmsg.wxa_nickname")))
    {
      ad.e("MicroMsg.WxaAppBrandNotifyMsgHandler", "nickname is null, return");
      AppMethodBeat.o(188667);
      return null;
    }
    String str2 = (String)paramMap.get(".sysmsg.weapp_pushmsg.busi_msgid");
    if (bt.isNullOrNil(str2))
    {
      ad.e("MicroMsg.WxaAppBrandNotifyMsgHandler", "msgId is null, return");
      AppMethodBeat.o(188667);
      return null;
    }
    if ((parama == null) || (parama.gqE == null))
    {
      ad.e("MicroMsg.WxaAppBrandNotifyMsgHandler", "addMsgInfo or addMsgInfo.addMsg is null! should not happen");
      AppMethodBeat.o(188667);
      return null;
    }
    String str3 = (String)paramMap.get(".sysmsg.weapp_pushmsg.weappinfo.appid");
    if (bt.isNullOrNil(str3)) {
      ad.w("MicroMsg.WxaAppBrandNotifyMsgHandler", "appId is null");
    }
    paramMap = (String)paramMap.get(".sysmsg.weapp_pushmsg.weappinfo.pagepath");
    if (bt.isNullOrNil(paramMap)) {
      ad.w("MicroMsg.WxaAppBrandNotifyMsgHandler", "pagePath is null");
    }
    cv localcv = parama.gqE;
    Object localObject = z.a(localcv.Fvk);
    String str4 = z.a(localcv.Fvi);
    paramString = ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().aI(str4, localcv.xbt);
    int i = 0;
    if (paramString.field_msgId > 0L) {
      i = 1;
    }
    paramString.qz(localcv.xbt);
    paramString.qA(bj.B(str4, localcv.CreateTime));
    paramString.setType(872415281);
    paramString.setContent((String)localObject);
    paramString.kr(0);
    paramString.setStatus(3);
    paramString.tN("appbrand_notify_message");
    paramString.sP(localcv.Fvn);
    paramString.dHv = String.valueOf(System.currentTimeMillis());
    paramString.eKU = true;
    if (bj.Bm("appbrand_notify_message") == 0)
    {
      ad.i("MicroMsg.WxaAppBrandNotifyMsgHandler", "empty appbrand notify message, insert tips message");
      localObject = new bu();
      ((bu)localObject).setType(872415281);
      ((bu)localObject).tN("appbrand_notify_message");
      ((bu)localObject).setContent("");
      ((bu)localObject).qA(paramString.field_createTime - 1L);
      ((bu)localObject).kr(2);
      ((bu)localObject).setStatus(4);
      bj.v((bu)localObject);
    }
    bj.a(paramString, parama);
    if (i == 0)
    {
      bj.v(paramString);
      parama = ((l)com.tencent.mm.kernel.g.ab(l.class)).azv().aTz("appbrand_notify_message");
      if (parama == null) {
        break label740;
      }
      parama.lO(134217728);
      i = ((l)com.tencent.mm.kernel.g.ab(l.class)).azv().a(parama, "appbrand_notify_message");
      ad.d("MicroMsg.WxaAppBrandNotifyMsgHandler", "username:%s ok:%b", new Object[] { paramString.field_talker, Integer.valueOf(i) });
      label541:
      paramString = (com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.g.class);
      if (paramString == null) {
        break label751;
      }
    }
    label740:
    label751:
    for (paramString = paramString.aYA();; paramString = null)
    {
      com.tencent.mm.plugin.report.service.g.yhR.f(19724, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), str3, paramMap, null, str2, Integer.valueOf(0), null, com.tencent.mm.ai.a.a.yz(str1), Integer.valueOf(0), null, null, paramString });
      AppMethodBeat.o(188667);
      return null;
      ((l)com.tencent.mm.kernel.g.ab(l.class)).dlK().b(localcv.xbt, paramString);
      break;
      ad.d("MicroMsg.WxaAppBrandNotifyMsgHandler", "conv is null");
      break label541;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.message.a
 * JD-Core Version:    0.7.0.1
 */