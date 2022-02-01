package com.tencent.mm.plugin.appbrand.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bl;
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

public enum a
  implements p
{
  static
  {
    AppMethodBeat.i(222838);
    lYx = new a("INSTANCE");
    lYy = new a[] { lYx };
    AppMethodBeat.o(222838);
  }
  
  private a() {}
  
  public final e.b a(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(222837);
    if ((paramString == null) || (!paramString.equals("weapp_pushmsg")))
    {
      ae.e("MicroMsg.WxaAppBrandNotifyMsgHandler", "subType is err, return");
      AppMethodBeat.o(222837);
      return null;
    }
    ae.i("MicroMsg.WxaAppBrandNotifyMsgHandler", "consumeNewXml subType:%s", new Object[] { paramString });
    String str1 = (String)paramMap.get(".sysmsg.weapp_pushmsg.title");
    if (bu.isNullOrNil(str1))
    {
      ae.e("MicroMsg.WxaAppBrandNotifyMsgHandler", "title is null, return");
      AppMethodBeat.o(222837);
      return null;
    }
    if (bu.isNullOrNil((String)paramMap.get(".sysmsg.weapp_pushmsg.wxa_nickname")))
    {
      ae.e("MicroMsg.WxaAppBrandNotifyMsgHandler", "nickname is null, return");
      AppMethodBeat.o(222837);
      return null;
    }
    String str2 = (String)paramMap.get(".sysmsg.weapp_pushmsg.busi_msgid");
    if (bu.isNullOrNil(str2))
    {
      ae.e("MicroMsg.WxaAppBrandNotifyMsgHandler", "msgId is null, return");
      AppMethodBeat.o(222837);
      return null;
    }
    if ((parama == null) || (parama.gte == null))
    {
      ae.e("MicroMsg.WxaAppBrandNotifyMsgHandler", "addMsgInfo or addMsgInfo.addMsg is null! should not happen");
      AppMethodBeat.o(222837);
      return null;
    }
    String str3 = (String)paramMap.get(".sysmsg.weapp_pushmsg.weappinfo.appid");
    if (bu.isNullOrNil(str3)) {
      ae.w("MicroMsg.WxaAppBrandNotifyMsgHandler", "appId is null");
    }
    paramMap = (String)paramMap.get(".sysmsg.weapp_pushmsg.weappinfo.pagepath");
    if (bu.isNullOrNil(paramMap)) {
      ae.w("MicroMsg.WxaAppBrandNotifyMsgHandler", "pagePath is null");
    }
    cv localcv = parama.gte;
    Object localObject = z.a(localcv.FNI);
    String str4 = z.a(localcv.FNG);
    paramString = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().aJ(str4, localcv.xrk);
    int i = 0;
    if (paramString.field_msgId > 0L) {
      i = 1;
    }
    paramString.qM(localcv.xrk);
    paramString.qN(bl.B(str4, localcv.CreateTime));
    paramString.setType(872415281);
    paramString.setContent((String)localObject);
    paramString.kt(0);
    paramString.setStatus(3);
    paramString.ui("appbrand_notify_message");
    paramString.tk(localcv.FNL);
    paramString.dIA = String.valueOf(System.currentTimeMillis());
    paramString.eMD = true;
    if (bl.BO("appbrand_notify_message") == 0)
    {
      ae.i("MicroMsg.WxaAppBrandNotifyMsgHandler", "empty appbrand notify message, insert tips message");
      localObject = new bv();
      ((bv)localObject).setType(872415281);
      ((bv)localObject).ui("appbrand_notify_message");
      ((bv)localObject).setContent("");
      ((bv)localObject).qN(paramString.field_createTime - 1L);
      ((bv)localObject).kt(2);
      ((bv)localObject).setStatus(4);
      bl.v((bv)localObject);
    }
    bl.a(paramString, parama);
    if (i == 0)
    {
      bl.v(paramString);
      parama = ((l)com.tencent.mm.kernel.g.ab(l.class)).azL().aVa("appbrand_notify_message");
      if (parama == null) {
        break label740;
      }
      parama.lQ(134217728);
      i = ((l)com.tencent.mm.kernel.g.ab(l.class)).azL().a(parama, "appbrand_notify_message");
      ae.d("MicroMsg.WxaAppBrandNotifyMsgHandler", "username:%s ok:%b", new Object[] { paramString.field_talker, Integer.valueOf(i) });
      label541:
      paramString = (com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.g.class);
      if (paramString == null) {
        break label751;
      }
    }
    label740:
    label751:
    for (paramString = paramString.aYW();; paramString = null)
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(19724, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), str3, paramMap, null, str2, Integer.valueOf(0), null, com.tencent.mm.ah.a.a.zj(str1), Integer.valueOf(0), null, null, paramString });
      AppMethodBeat.o(222837);
      return null;
      ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().b(localcv.xrk, paramString);
      break;
      ae.d("MicroMsg.WxaAppBrandNotifyMsgHandler", "conv is null");
      break label541;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.message.a
 * JD-Core Version:    0.7.0.1
 */