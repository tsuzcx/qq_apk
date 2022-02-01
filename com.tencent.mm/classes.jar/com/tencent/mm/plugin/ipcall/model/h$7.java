package com.tencent.mm.plugin.ipcall.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.c;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cl.a;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.ipcall.model.h.g;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.Map;

final class h$7
  implements cl.a
{
  h$7(h paramh) {}
  
  public final void a(g.a parama)
  {
    AppMethodBeat.i(25388);
    Log.i("MicroMsg.SubCoreIPCall", "WeChatOutMsg onRecieveMsg");
    Object localObject = parama.mpN;
    parama = w.a(parama.mpN.YFG);
    if ((parama == null) || (parama.length() == 0))
    {
      Log.e("MicroMsg.SubCoreIPCall", "WeChatOutMsg onReceiveMsg, msgContent is null");
      AppMethodBeat.o(25388);
      return;
    }
    parama = XmlParser.parseXml(parama, "sysmsg", null);
    if (parama == null)
    {
      Log.e("MicroMsg.SubCoreIPCall", "WeChatOutMsg onReceiveMsg, values is null");
      AppMethodBeat.o(25388);
      return;
    }
    com.tencent.mm.plugin.ipcall.model.h.h localh = h.fRz();
    long l = ((dl)localObject).Njs;
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
      i = Util.getInt((String)parama.get(".sysmsg.WeChatOutMsg.MsgType"), 0);
      ((g)localObject).field_msgType = i;
      ((g)localObject).field_pushTime = Util.getLong((String)parama.get(".sysmsg.WeChatOutMsg.PushTime"), 0L);
      ((g)localObject).field_descUrl = ((String)parama.get(".sysmsg.WeChatOutMsg.DescUrl"));
      if (((g)localObject).field_descUrl == null) {
        ((g)localObject).field_descUrl = "";
      }
      Log.i("MicroMsg.IPCallMsgStorage", "insertNewXml svrId:%s,title:%s,content:%s,msgType:%s,pushTime:%s,descUrl=%s", new Object[] { ((g)localObject).field_svrId, ((g)localObject).field_title, ((g)localObject).field_content, ((g)localObject).field_msgType, ((g)localObject).field_pushTime, ((g)localObject).field_descUrl });
      localh.insert((IAutoDBItem)localObject);
    }
    for (;;)
    {
      if (i != -1)
      {
        bh.bCz();
        c.ban().set(at.a.acKR, Integer.valueOf(i));
      }
      bh.bCz();
      c.ban().set(at.a.acKQ, Boolean.TRUE);
      com.tencent.mm.plugin.report.service.h.OAn.b(13254, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(i), Integer.valueOf(-1) });
      AppMethodBeat.o(25388);
      return;
      i = -1;
    }
  }
  
  public final void a(g.c paramc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.h.7
 * JD-Core Version:    0.7.0.1
 */