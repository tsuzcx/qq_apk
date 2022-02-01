package com.tencent.mm.plugin.appbrand.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bq;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.appbrand.service.g;
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

public enum a
  implements s
{
  static
  {
    AppMethodBeat.i(276932);
    qgN = new a("INSTANCE");
    qgO = new a[] { qgN };
    AppMethodBeat.o(276932);
  }
  
  private a() {}
  
  public final h.b a(String paramString, Map<String, String> paramMap, h.a parama)
  {
    AppMethodBeat.i(276931);
    if ((paramString == null) || (!paramString.equals("weapp_pushmsg")))
    {
      Log.e("MicroMsg.WxaAppBrandNotifyMsgHandler", "subType is err, return");
      AppMethodBeat.o(276931);
      return null;
    }
    Log.i("MicroMsg.WxaAppBrandNotifyMsgHandler", "consumeNewXml subType:%s", new Object[] { paramString });
    String str1 = (String)paramMap.get(".sysmsg.weapp_pushmsg.title");
    if (Util.isNullOrNil(str1))
    {
      Log.e("MicroMsg.WxaAppBrandNotifyMsgHandler", "title is null, return");
      AppMethodBeat.o(276931);
      return null;
    }
    if (Util.isNullOrNil((String)paramMap.get(".sysmsg.weapp_pushmsg.wxa_nickname")))
    {
      Log.e("MicroMsg.WxaAppBrandNotifyMsgHandler", "nickname is null, return");
      AppMethodBeat.o(276931);
      return null;
    }
    String str2 = (String)paramMap.get(".sysmsg.weapp_pushmsg.busi_msgid");
    if (Util.isNullOrNil(str2))
    {
      Log.e("MicroMsg.WxaAppBrandNotifyMsgHandler", "msgId is null, return");
      AppMethodBeat.o(276931);
      return null;
    }
    if ((parama == null) || (parama.jQG == null))
    {
      Log.e("MicroMsg.WxaAppBrandNotifyMsgHandler", "addMsgInfo or addMsgInfo.addMsg is null! should not happen");
      AppMethodBeat.o(276931);
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
    db localdb = parama.jQG;
    Object localObject = z.a(localdb.RIF);
    String str4 = z.a(localdb.RID);
    paramString = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aL(str4, localdb.HlH);
    int i = 0;
    if (paramString.field_msgId > 0L) {
      i = 1;
    }
    paramString.EG(localdb.HlH);
    paramString.setCreateTime(bq.z(str4, localdb.CreateTime));
    paramString.setType(872415281);
    paramString.setContent((String)localObject);
    paramString.pJ(0);
    paramString.setStatus(3);
    paramString.Jm("appbrand_notify_message");
    paramString.Ip(localdb.RII);
    paramString.fUk = String.valueOf(System.currentTimeMillis());
    paramString.hwY = true;
    if (bq.RN("appbrand_notify_message") == 0)
    {
      Log.i("MicroMsg.WxaAppBrandNotifyMsgHandler", "empty appbrand notify message, insert tips message");
      localObject = new ca();
      ((ca)localObject).setType(872415281);
      ((ca)localObject).Jm("appbrand_notify_message");
      ((ca)localObject).setContent("");
      ((ca)localObject).setCreateTime(paramString.field_createTime - 1L);
      ((ca)localObject).pJ(2);
      ((ca)localObject).setStatus(4);
      bq.z((ca)localObject);
    }
    bq.a(paramString, parama);
    if (i == 0)
    {
      bq.z(paramString);
      parama = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwx("appbrand_notify_message");
      if (parama == null) {
        break label740;
      }
      parama.rn(134217728);
      i = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().a(parama, "appbrand_notify_message");
      Log.d("MicroMsg.WxaAppBrandNotifyMsgHandler", "username:%s ok:%b", new Object[] { paramString.field_talker, Integer.valueOf(i) });
      label541:
      paramString = (g)com.tencent.mm.kernel.h.ae(g.class);
      if (paramString == null) {
        break label751;
      }
    }
    label740:
    label751:
    for (paramString = paramString.bFl();; paramString = null)
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(19724, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), str3, paramMap, null, str2, Integer.valueOf(0), null, com.tencent.mm.aj.b.a.OZ(str1), Integer.valueOf(0), null, null, paramString });
      AppMethodBeat.o(276931);
      return null;
      ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().b(localdb.HlH, paramString);
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