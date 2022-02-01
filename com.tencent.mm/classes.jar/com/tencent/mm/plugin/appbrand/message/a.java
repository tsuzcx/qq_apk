package com.tencent.mm.plugin.appbrand.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.b;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.br;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import java.util.Map;

public enum a
  implements s
{
  static
  {
    AppMethodBeat.i(317183);
    tly = new a("INSTANCE");
    tlz = new a[] { tly };
    AppMethodBeat.o(317183);
  }
  
  private a() {}
  
  public final g.b a(String paramString, Map<String, String> paramMap, g.a parama)
  {
    AppMethodBeat.i(317189);
    if ((paramString == null) || (!paramString.equals("weapp_pushmsg")))
    {
      Log.e("MicroMsg.WxaAppBrandNotifyMsgHandler", "subType is err, return");
      AppMethodBeat.o(317189);
      return null;
    }
    Log.i("MicroMsg.WxaAppBrandNotifyMsgHandler", "consumeNewXml subType:%s", new Object[] { paramString });
    String str1 = (String)paramMap.get(".sysmsg.weapp_pushmsg.title");
    if (Util.isNullOrNil(str1))
    {
      Log.e("MicroMsg.WxaAppBrandNotifyMsgHandler", "title is null, return");
      AppMethodBeat.o(317189);
      return null;
    }
    if (Util.isNullOrNil((String)paramMap.get(".sysmsg.weapp_pushmsg.wxa_nickname")))
    {
      Log.e("MicroMsg.WxaAppBrandNotifyMsgHandler", "nickname is null, return");
      AppMethodBeat.o(317189);
      return null;
    }
    String str2 = (String)paramMap.get(".sysmsg.weapp_pushmsg.busi_msgid");
    if (Util.isNullOrNil(str2))
    {
      Log.e("MicroMsg.WxaAppBrandNotifyMsgHandler", "msgId is null, return");
      AppMethodBeat.o(317189);
      return null;
    }
    if ((parama == null) || (parama.mpN == null))
    {
      Log.e("MicroMsg.WxaAppBrandNotifyMsgHandler", "addMsgInfo or addMsgInfo.addMsg is null! should not happen");
      AppMethodBeat.o(317189);
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
    dl localdl = parama.mpN;
    Object localObject = w.a(localdl.YFG);
    String str4 = w.a(localdl.YFE);
    paramString = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aU(str4, localdl.Njv);
    int i = 0;
    if (paramString.field_msgId > 0L) {
      i = 1;
    }
    paramString.gX(localdl.Njv);
    paramString.setCreateTime(br.D(str4, localdl.CreateTime));
    paramString.setType(872415281);
    paramString.setContent((String)localObject);
    paramString.pI(0);
    paramString.setStatus(3);
    paramString.BS("appbrand_notify_message");
    paramString.AU(localdl.YFJ);
    paramString.iah = String.valueOf(System.currentTimeMillis());
    paramString.jTR = true;
    if (br.JL("appbrand_notify_message") == 0)
    {
      Log.i("MicroMsg.WxaAppBrandNotifyMsgHandler", "empty appbrand notify message, insert tips message");
      localObject = new cc();
      ((cc)localObject).setType(872415281);
      ((cc)localObject).BS("appbrand_notify_message");
      ((cc)localObject).setContent("");
      ((cc)localObject).setCreateTime(paramString.getCreateTime() - 1L);
      ((cc)localObject).pI(2);
      ((cc)localObject).setStatus(4);
      br.B((cc)localObject);
    }
    br.a(paramString, parama);
    if (i == 0)
    {
      br.B(paramString);
      parama = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().bxM("appbrand_notify_message");
      if (parama == null) {
        break label740;
      }
      parama.rv(134217728);
      i = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().c(parama, "appbrand_notify_message");
      Log.d("MicroMsg.WxaAppBrandNotifyMsgHandler", "username:%s ok:%b", new Object[] { paramString.field_talker, Integer.valueOf(i) });
      label541:
      paramString = (com.tencent.mm.plugin.appbrand.service.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.h.class);
      if (paramString == null) {
        break label751;
      }
    }
    label740:
    label751:
    for (paramString = paramString.cez();; paramString = null)
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(19724, new Object[] { Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), str3, paramMap, null, str2, Integer.valueOf(0), null, com.tencent.mm.message.c.a.Hs(str1), Integer.valueOf(0), null, null, paramString });
      AppMethodBeat.o(317189);
      return null;
      ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().b(localdl.Njv, paramString);
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