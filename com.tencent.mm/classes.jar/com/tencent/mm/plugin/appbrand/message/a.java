package com.tencent.mm.plugin.appbrand.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bp;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import java.util.Map;

public enum a
  implements p
{
  static
  {
    AppMethodBeat.i(227189);
    ngd = new a("INSTANCE");
    nge = new a[] { ngd };
    AppMethodBeat.o(227189);
  }
  
  private a() {}
  
  public final h.b a(String paramString, Map<String, String> paramMap, h.a parama)
  {
    AppMethodBeat.i(227188);
    if ((paramString == null) || (!paramString.equals("weapp_pushmsg")))
    {
      Log.e("MicroMsg.WxaAppBrandNotifyMsgHandler", "subType is err, return");
      AppMethodBeat.o(227188);
      return null;
    }
    Log.i("MicroMsg.WxaAppBrandNotifyMsgHandler", "consumeNewXml subType:%s", new Object[] { paramString });
    String str1 = (String)paramMap.get(".sysmsg.weapp_pushmsg.title");
    if (Util.isNullOrNil(str1))
    {
      Log.e("MicroMsg.WxaAppBrandNotifyMsgHandler", "title is null, return");
      AppMethodBeat.o(227188);
      return null;
    }
    if (Util.isNullOrNil((String)paramMap.get(".sysmsg.weapp_pushmsg.wxa_nickname")))
    {
      Log.e("MicroMsg.WxaAppBrandNotifyMsgHandler", "nickname is null, return");
      AppMethodBeat.o(227188);
      return null;
    }
    String str2 = (String)paramMap.get(".sysmsg.weapp_pushmsg.busi_msgid");
    if (Util.isNullOrNil(str2))
    {
      Log.e("MicroMsg.WxaAppBrandNotifyMsgHandler", "msgId is null, return");
      AppMethodBeat.o(227188);
      return null;
    }
    if ((parama == null) || (parama.heO == null))
    {
      Log.e("MicroMsg.WxaAppBrandNotifyMsgHandler", "addMsgInfo or addMsgInfo.addMsg is null! should not happen");
      AppMethodBeat.o(227188);
      return null;
    }
    String str3 = (String)paramMap.get(".sysmsg.weapp_pushmsg.weappinfo.appid");
    if (Util.isNullOrNil(str3)) {
      Log.w("MicroMsg.WxaAppBrandNotifyMsgHandler", "appId is null");
    }
    paramMap = (String)paramMap.get(".sysmsg.weapp_pushmsg.weappinfo.pagepath");
    if (Util.isNullOrNil(paramMap)) {
      Log.w("MicroMsg.WxaAppBrandNotifyMsgHandler", "pagePath is null");
    }
    de localde = parama.heO;
    Object localObject = z.a(localde.KHn);
    String str4 = z.a(localde.KHl);
    paramString = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().aJ(str4, localde.Brn);
    int i = 0;
    if (paramString.field_msgId > 0L) {
      i = 1;
    }
    paramString.yF(localde.Brn);
    paramString.setCreateTime(bp.C(str4, localde.CreateTime));
    paramString.setType(872415281);
    paramString.setContent((String)localObject);
    paramString.nv(0);
    paramString.setStatus(3);
    paramString.Cy("appbrand_notify_message");
    paramString.BB(localde.KHq);
    paramString.ean = String.valueOf(System.currentTimeMillis());
    paramString.fqk = true;
    if (bp.Ku("appbrand_notify_message") == 0)
    {
      Log.i("MicroMsg.WxaAppBrandNotifyMsgHandler", "empty appbrand notify message, insert tips message");
      localObject = new ca();
      ((ca)localObject).setType(872415281);
      ((ca)localObject).Cy("appbrand_notify_message");
      ((ca)localObject).setContent("");
      ((ca)localObject).setCreateTime(paramString.field_createTime - 1L);
      ((ca)localObject).nv(2);
      ((ca)localObject).setStatus(4);
      bp.x((ca)localObject);
    }
    bp.a(paramString, parama);
    if (i == 0)
    {
      bp.x(paramString);
      parama = ((l)com.tencent.mm.kernel.g.af(l.class)).aST().bjY("appbrand_notify_message");
      if (parama == null) {
        break label740;
      }
      parama.oT(134217728);
      i = ((l)com.tencent.mm.kernel.g.af(l.class)).aST().a(parama, "appbrand_notify_message");
      Log.d("MicroMsg.WxaAppBrandNotifyMsgHandler", "username:%s ok:%b", new Object[] { paramString.field_talker, Integer.valueOf(i) });
      label541:
      paramString = (com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.g.class);
      if (paramString == null) {
        break label751;
      }
    }
    label740:
    label751:
    for (paramString = paramString.bul();; paramString = null)
    {
      h.CyF.a(19724, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), str3, paramMap, null, str2, Integer.valueOf(0), null, com.tencent.mm.ag.a.a.HL(str1), Integer.valueOf(0), null, null, paramString });
      AppMethodBeat.o(227188);
      return null;
      ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().b(localde.Brn, paramString);
      break;
      Log.d("MicroMsg.WxaAppBrandNotifyMsgHandler", "conv is null");
      break label541;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.message.a
 * JD-Core Version:    0.7.0.1
 */