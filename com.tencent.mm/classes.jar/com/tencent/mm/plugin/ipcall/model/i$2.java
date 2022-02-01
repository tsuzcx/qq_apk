package com.tencent.mm.plugin.ipcall.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.ipcall.model.h.h;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.Map;

final class i$2
  implements cf.a
{
  i$2(i parami) {}
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(25383);
    ae.i("MicroMsg.SubCoreIPCall", "WeChatOutMsg onRecieveMsg");
    Object localObject = parama.gte;
    parama = z.a(parama.gte.FNI);
    if ((parama == null) || (parama.length() == 0))
    {
      ae.e("MicroMsg.SubCoreIPCall", "WeChatOutMsg onReceiveMsg, msgContent is null");
      AppMethodBeat.o(25383);
      return;
    }
    parama = bx.M(parama, "sysmsg");
    if (parama == null)
    {
      ae.e("MicroMsg.SubCoreIPCall", "WeChatOutMsg onReceiveMsg, values is null");
      AppMethodBeat.o(25383);
      return;
    }
    h localh = i.dgH();
    long l = ((cv)localObject).xri;
    int i;
    if (parama != null)
    {
      localObject = new com.tencent.mm.plugin.ipcall.model.h.g();
      ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_svrId = l;
      ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_title = ((String)parama.get(".sysmsg.WeChatOutMsg.Title"));
      if (((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_title == null) {
        ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_title = "";
      }
      ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_content = ((String)parama.get(".sysmsg.WeChatOutMsg.Content"));
      if (((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_content == null) {
        ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_content = "";
      }
      i = bu.getInt((String)parama.get(".sysmsg.WeChatOutMsg.MsgType"), 0);
      ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_msgType = i;
      ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_pushTime = bu.getLong((String)parama.get(".sysmsg.WeChatOutMsg.PushTime"), 0L);
      ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_descUrl = ((String)parama.get(".sysmsg.WeChatOutMsg.DescUrl"));
      if (((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_descUrl == null) {
        ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_descUrl = "";
      }
      ae.i("MicroMsg.IPCallMsgStorage", "insertNewXml svrId:%s,title:%s,content:%s,msgType:%s,pushTime:%s,descUrl=%s", new Object[] { ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_svrId, ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_title, ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_content, ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_msgType, ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_pushTime, ((com.tencent.mm.plugin.ipcall.model.h.g)localObject).field_descUrl });
      localh.insert((com.tencent.mm.sdk.e.c)localObject);
    }
    for (;;)
    {
      if (i != -1)
      {
        bc.aCg();
        com.tencent.mm.model.c.ajA().set(am.a.INu, Integer.valueOf(i));
      }
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(am.a.INt, Boolean.TRUE);
      com.tencent.mm.plugin.report.service.g.yxI.f(13254, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(i), Integer.valueOf(-1) });
      AppMethodBeat.o(25383);
      return;
      i = -1;
    }
  }
  
  public final void a(e.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.i.2
 * JD-Core Version:    0.7.0.1
 */