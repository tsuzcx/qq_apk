package com.tencent.mm.plugin.ipcall.a;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.ipcall.a.g.g;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Map;

final class i$2
  implements bx.a
{
  i$2(i parami) {}
  
  public final void a(e.a parama)
  {
    y.i("MicroMsg.SubCoreIPCall", "WeChatOutMsg onRecieveMsg");
    Object localObject = parama.dBs;
    parama = aa.a(parama.dBs.svH);
    if ((parama == null) || (parama.length() == 0))
    {
      y.e("MicroMsg.SubCoreIPCall", "WeChatOutMsg onReceiveMsg, msgContent is null");
      return;
    }
    parama = bn.s(parama, "sysmsg");
    if (parama == null)
    {
      y.e("MicroMsg.SubCoreIPCall", "WeChatOutMsg onReceiveMsg, values is null");
      return;
    }
    com.tencent.mm.plugin.ipcall.a.g.h localh = i.bcp();
    long l = ((cd)localObject).ndm;
    int i;
    if (parama != null)
    {
      localObject = new g();
      ((g)localObject).field_svrId = l;
      ((g)localObject).field_title = ((String)parama.get(".sysmsg.WeChatOutMsg.Title"));
      if (((g)localObject).field_title == null) {
        ((g)localObject).field_title = "";
      }
      ((g)localObject).field_content = ((String)parama.get(".sysmsg.WeChatOutMsg.Content"));
      if (((g)localObject).field_content == null) {
        ((g)localObject).field_content = "";
      }
      i = bk.getInt((String)parama.get(".sysmsg.WeChatOutMsg.MsgType"), 0);
      ((g)localObject).field_msgType = i;
      ((g)localObject).field_pushTime = bk.getLong((String)parama.get(".sysmsg.WeChatOutMsg.PushTime"), 0L);
      ((g)localObject).field_descUrl = ((String)parama.get(".sysmsg.WeChatOutMsg.DescUrl"));
      if (((g)localObject).field_descUrl == null) {
        ((g)localObject).field_descUrl = "";
      }
      y.i("MicroMsg.IPCallMsgStorage", "insertNewXml svrId:%s,title:%s,content:%s,msgType:%s,pushTime:%s,descUrl=%s", new Object[] { ((g)localObject).field_svrId, ((g)localObject).field_title, ((g)localObject).field_content, ((g)localObject).field_msgType, ((g)localObject).field_pushTime, ((g)localObject).field_descUrl });
      localh.b((com.tencent.mm.sdk.e.c)localObject);
    }
    for (;;)
    {
      if (i != -1)
      {
        au.Hx();
        com.tencent.mm.model.c.Dz().c(ac.a.uqv, Integer.valueOf(i));
      }
      au.Hx();
      com.tencent.mm.model.c.Dz().c(ac.a.uqu, Boolean.valueOf(true));
      com.tencent.mm.plugin.report.service.h.nFQ.f(13254, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(i), Integer.valueOf(-1) });
      return;
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.i.2
 * JD-Core Version:    0.7.0.1
 */