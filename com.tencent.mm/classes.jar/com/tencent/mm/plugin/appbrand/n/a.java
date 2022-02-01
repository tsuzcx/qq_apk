package com.tencent.mm.plugin.appbrand.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bl;
import java.util.Map;

public enum a
  implements o
{
  static
  {
    AppMethodBeat.i(196049);
    kTk = new a("INSTANCE");
    kTl = new a[] { kTk };
    AppMethodBeat.o(196049);
  }
  
  private a() {}
  
  public final f.b a(String paramString, Map<String, String> paramMap, f.a parama)
  {
    AppMethodBeat.i(196048);
    if ((paramString == null) || (!paramString.equals("weapp_pushmsg")))
    {
      ad.e("MicroMsg.WxaAppBrandNotifyMsgHandler", "subType is err, return");
      AppMethodBeat.o(196048);
      return null;
    }
    ad.i("MicroMsg.WxaAppBrandNotifyMsgHandler", "consumeNewXml subType:%s", new Object[] { paramString });
    paramString = (String)paramMap.get(".sysmsg.weapp_pushmsg.title");
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.WxaAppBrandNotifyMsgHandler", "title is null, return");
      AppMethodBeat.o(196048);
      return null;
    }
    if (bt.isNullOrNil((String)paramMap.get(".sysmsg.weapp_pushmsg.wxa_nickname")))
    {
      ad.e("MicroMsg.WxaAppBrandNotifyMsgHandler", "nickname is null, return");
      AppMethodBeat.o(196048);
      return null;
    }
    String str1 = (String)paramMap.get(".sysmsg.weapp_pushmsg.busi_msgid");
    if (bt.isNullOrNil(str1))
    {
      ad.e("MicroMsg.WxaAppBrandNotifyMsgHandler", "msgId is null, return");
      AppMethodBeat.o(196048);
      return null;
    }
    if ((parama == null) || (parama.fTo == null))
    {
      ad.e("MicroMsg.WxaAppBrandNotifyMsgHandler", "addMsgInfo or addMsgInfo.addMsg is null! should not happen");
      AppMethodBeat.o(196048);
      return null;
    }
    String str2 = (String)paramMap.get(".sysmsg.weapp_pushmsg.weappinfo.appid");
    if (bt.isNullOrNil(str2)) {
      ad.w("MicroMsg.WxaAppBrandNotifyMsgHandler", "appId is null");
    }
    paramMap = (String)paramMap.get(".sysmsg.weapp_pushmsg.weappinfo.pagepath");
    if (bt.isNullOrNil(paramMap)) {
      ad.w("MicroMsg.WxaAppBrandNotifyMsgHandler", "pagePath is null");
    }
    cs localcs = parama.fTo;
    Object localObject = z.a(localcs.Cxz);
    String str3 = z.a(localcs.Cxx);
    bl localbl = ((k)g.ab(k.class)).cOI().aD(str3, localcs.uKZ);
    int i = 0;
    if (localbl.field_msgId > 0L) {
      i = 1;
    }
    localbl.kX(localcs.uKZ);
    localbl.kY(bi.y(str3, localcs.CreateTime));
    localbl.setType(872415281);
    localbl.setContent((String)localObject);
    localbl.jV(0);
    localbl.setStatus(3);
    localbl.nY("appbrand_notify_message");
    localbl.mZ(localcs.CxC);
    localbl.dxG = String.valueOf(System.currentTimeMillis());
    localbl.erH = true;
    if (bi.uh("appbrand_notify_message") == 0)
    {
      ad.i("MicroMsg.WxaAppBrandNotifyMsgHandler", "empty appbrand notify message, insert tips message");
      localObject = new bl();
      ((bl)localObject).setType(872415281);
      ((bl)localObject).nY("appbrand_notify_message");
      ((bl)localObject).setContent("");
      ((bl)localObject).kY(localbl.field_createTime - 1L);
      ((bl)localObject).jV(2);
      ((bl)localObject).setStatus(4);
      bi.u((bl)localObject);
    }
    bi.a(localbl, parama);
    if (i == 0)
    {
      bi.u(localbl);
      parama = ((k)g.ab(k.class)).apR().aIn("appbrand_notify_message");
      if (parama == null) {
        break label728;
      }
      parama.lu(134217728);
      i = ((k)g.ab(k.class)).apR().a(parama, "appbrand_notify_message");
      ad.d("MicroMsg.WxaAppBrandNotifyMsgHandler", "username:%s ok:%b", new Object[] { localbl.field_talker, Integer.valueOf(i) });
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.vKh.f(19724, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), str2, paramMap, null, str1, Integer.valueOf(0), null, com.tencent.mm.ai.a.a.rF(paramString), Integer.valueOf(0), null, null });
      AppMethodBeat.o(196048);
      return null;
      ((k)g.ab(k.class)).cOI().b(localcs.uKZ, localbl);
      break;
      label728:
      ad.d("MicroMsg.WxaAppBrandNotifyMsgHandler", "conv is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.a
 * JD-Core Version:    0.7.0.1
 */