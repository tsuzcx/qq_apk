package com.tencent.mm.plugin.appbrand.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.bi;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bo;
import java.util.Map;

public enum a
  implements o
{
  static
  {
    AppMethodBeat.i(186873);
    luL = new a("INSTANCE");
    luM = new a[] { luL };
    AppMethodBeat.o(186873);
  }
  
  private a() {}
  
  public final f.b a(String paramString, Map<String, String> paramMap, f.a parama)
  {
    AppMethodBeat.i(186872);
    if ((paramString == null) || (!paramString.equals("weapp_pushmsg")))
    {
      ac.e("MicroMsg.WxaAppBrandNotifyMsgHandler", "subType is err, return");
      AppMethodBeat.o(186872);
      return null;
    }
    ac.i("MicroMsg.WxaAppBrandNotifyMsgHandler", "consumeNewXml subType:%s", new Object[] { paramString });
    String str1 = (String)paramMap.get(".sysmsg.weapp_pushmsg.title");
    if (bs.isNullOrNil(str1))
    {
      ac.e("MicroMsg.WxaAppBrandNotifyMsgHandler", "title is null, return");
      AppMethodBeat.o(186872);
      return null;
    }
    if (bs.isNullOrNil((String)paramMap.get(".sysmsg.weapp_pushmsg.wxa_nickname")))
    {
      ac.e("MicroMsg.WxaAppBrandNotifyMsgHandler", "nickname is null, return");
      AppMethodBeat.o(186872);
      return null;
    }
    String str2 = (String)paramMap.get(".sysmsg.weapp_pushmsg.busi_msgid");
    if (bs.isNullOrNil(str2))
    {
      ac.e("MicroMsg.WxaAppBrandNotifyMsgHandler", "msgId is null, return");
      AppMethodBeat.o(186872);
      return null;
    }
    if ((parama == null) || (parama.fXi == null))
    {
      ac.e("MicroMsg.WxaAppBrandNotifyMsgHandler", "addMsgInfo or addMsgInfo.addMsg is null! should not happen");
      AppMethodBeat.o(186872);
      return null;
    }
    String str3 = (String)paramMap.get(".sysmsg.weapp_pushmsg.weappinfo.appid");
    if (bs.isNullOrNil(str3)) {
      ac.w("MicroMsg.WxaAppBrandNotifyMsgHandler", "appId is null");
    }
    paramMap = (String)paramMap.get(".sysmsg.weapp_pushmsg.weappinfo.pagepath");
    if (bs.isNullOrNil(paramMap)) {
      ac.w("MicroMsg.WxaAppBrandNotifyMsgHandler", "pagePath is null");
    }
    cu localcu = parama.fXi;
    Object localObject = z.a(localcu.DPV);
    String str4 = z.a(localcu.DPT);
    paramString = ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().aF(str4, localcu.vTQ);
    int i = 0;
    if (paramString.field_msgId > 0L) {
      i = 1;
    }
    paramString.oz(localcu.vTQ);
    paramString.oA(bi.z(str4, localcu.CreateTime));
    paramString.setType(872415281);
    paramString.setContent((String)localObject);
    paramString.jT(0);
    paramString.setStatus(3);
    paramString.re("appbrand_notify_message");
    paramString.qf(localcu.DPY);
    paramString.dvs = String.valueOf(System.currentTimeMillis());
    paramString.etL = true;
    if (bi.yn("appbrand_notify_message") == 0)
    {
      ac.i("MicroMsg.WxaAppBrandNotifyMsgHandler", "empty appbrand notify message, insert tips message");
      localObject = new bo();
      ((bo)localObject).setType(872415281);
      ((bo)localObject).re("appbrand_notify_message");
      ((bo)localObject).setContent("");
      ((bo)localObject).oA(paramString.field_createTime - 1L);
      ((bo)localObject).jT(2);
      ((bo)localObject).setStatus(4);
      bi.u((bo)localObject);
    }
    bi.a(paramString, parama);
    if (i == 0)
    {
      bi.u(paramString);
      parama = ((k)com.tencent.mm.kernel.g.ab(k.class)).awG().aNI("appbrand_notify_message");
      if (parama == null) {
        break label740;
      }
      parama.lp(134217728);
      i = ((k)com.tencent.mm.kernel.g.ab(k.class)).awG().a(parama, "appbrand_notify_message");
      ac.d("MicroMsg.WxaAppBrandNotifyMsgHandler", "username:%s ok:%b", new Object[] { paramString.field_talker, Integer.valueOf(i) });
      label541:
      paramString = (com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.g.class);
      if (paramString == null) {
        break label751;
      }
    }
    label740:
    label751:
    for (paramString = paramString.aVg();; paramString = null)
    {
      com.tencent.mm.plugin.report.service.h.wUl.f(19724, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), str3, paramMap, null, str2, Integer.valueOf(0), null, com.tencent.mm.ah.a.a.vI(str1), Integer.valueOf(0), null, null, paramString });
      AppMethodBeat.o(186872);
      return null;
      ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().b(localcu.vTQ, paramString);
      break;
      ac.d("MicroMsg.WxaAppBrandNotifyMsgHandler", "conv is null");
      break label541;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.message.a
 * JD-Core Version:    0.7.0.1
 */