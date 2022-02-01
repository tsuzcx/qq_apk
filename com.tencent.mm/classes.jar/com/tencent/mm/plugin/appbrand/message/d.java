package com.tencent.mm.plugin.appbrand.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.b;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.modelappbrand.m;
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

public enum d
  implements s
{
  static
  {
    AppMethodBeat.i(47714);
    tlM = new d("INSTANCE");
    tlN = new d[] { tlM };
    AppMethodBeat.o(47714);
  }
  
  private d() {}
  
  public final g.b a(String paramString, Map<String, String> paramMap, g.a parama)
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
    paramString = ((m)h.ax(m.class)).KL(paramMap);
    if (paramString == null)
    {
      Log.e("MicroMsg.WxaSubscribeSysmsgHandler", "shareKey:%s wxaUpdateableMsg is null, ingore", new Object[] { paramMap });
      AppMethodBeat.o(47713);
      return null;
    }
    if (paramString.field_btnState != 2)
    {
      Log.e("MicroMsg.WxaSubscribeSysmsgHandler", "shareKey:%s btnState:%d msgState:%d ingore", new Object[] { paramMap, Integer.valueOf(paramString.field_btnState), Integer.valueOf(paramString.field_msgState) });
      AppMethodBeat.o(47713);
      return null;
    }
    if ((parama == null) || (parama.mpN == null))
    {
      Log.e("MicroMsg.WxaSubscribeSysmsgHandler", "addMsgInfo or addMsgInfo.addMsg is null! should not happen");
      AppMethodBeat.o(47713);
      return null;
    }
    paramMap = parama.mpN;
    String str1 = w.a(paramMap.YFG);
    String str2 = w.a(paramMap.YFE);
    String str3 = w.a(paramMap.YFF);
    paramString = ((n)h.ax(n.class)).gaZ().aU(str2, paramMap.Njv);
    int i = 0;
    if (paramString.field_msgId > 0L) {
      i = 1;
    }
    paramString.gX(paramMap.Njv);
    if ((!parama.otM) || (!parama.otO)) {
      paramString.setCreateTime(br.D(str2, paramMap.CreateTime));
    }
    paramString.setType(603979825);
    paramString.setContent(str1);
    paramString.pI(0);
    paramString.setStatus(3);
    if (str2.equals(z.bAM()))
    {
      paramString.BS(str3);
      paramString.AU(paramMap.YFJ);
      br.a(paramString, parama);
      if (i != 0) {
        break label467;
      }
      br.B(paramString);
      label366:
      paramMap = ((n)h.ax(n.class)).bzG().bxM(paramString.field_talker);
      if (paramMap == null) {
        break label493;
      }
      paramMap.rv(33554432);
      i = ((n)h.ax(n.class)).bzG().c(paramMap, paramString.field_talker);
      Log.d("MicroMsg.WxaSubscribeSysmsgHandler", "username:%s ok:%b", new Object[] { paramString.field_talker, Integer.valueOf(i) });
    }
    for (;;)
    {
      AppMethodBeat.o(47713);
      return null;
      paramString.BS(str2);
      break;
      label467:
      ((n)h.ax(n.class)).gaZ().b(paramMap.Njv, paramString);
      break label366;
      label493:
      Log.d("MicroMsg.WxaSubscribeSysmsgHandler", "conv is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.message.d
 * JD-Core Version:    0.7.0.1
 */