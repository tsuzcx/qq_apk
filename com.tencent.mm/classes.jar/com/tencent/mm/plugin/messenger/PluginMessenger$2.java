package com.tencent.mm.plugin.messenger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.Map;

final class PluginMessenger$2
  implements o
{
  PluginMessenger$2(PluginMessenger paramPluginMessenger) {}
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(136876);
    if ("secmsg".equals(paramString))
    {
      Object localObject = bo.nullAsNil((String)paramMap.get(".sysmsg.secmsg.session"));
      paramString = bo.nullAsNil((String)paramMap.get(".sysmsg.secmsg.newmsgid"));
      int i = bo.apV((String)paramMap.get(".sysmsg.secmsg.sec_msg_node.sfn"));
      int j = bo.apV((String)paramMap.get(".sysmsg.secmsg.sec_msg_node.fd"));
      parama = bo.nullAsNil((String)paramMap.get(".sysmsg.secmsg.sec_msg_node.show-h5"));
      int k = bo.apV((String)paramMap.get(".sysmsg.secmsg.sec_msg_node.clip-len"));
      paramMap = bo.nullAsNil((String)paramMap.get(".sysmsg.secmsg.sec_msg_node.share-tip-url"));
      ab.i("MicroMsg.PluginMessenger", "%d,%d,%s,%d,%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), parama, Integer.valueOf(k), paramMap });
      if (!bo.Q(new String[] { localObject, paramString }))
      {
        localObject = ((j)g.E(j.class)).bPQ().ag((String)localObject, bo.apW(paramString));
        if ((!bo.isNullOrNil(((dd)localObject).field_talker)) && (((dd)localObject).field_msgSvrId > 0L))
        {
          if (((dd)localObject).field_isSend != 1)
          {
            bh.a((bi)localObject, i, j, parama, k, paramMap);
            AppMethodBeat.o(136876);
          }
        }
        else {
          ab.i("MicroMsg.PluginMessenger", "msg %s not found!", new Object[] { paramString });
        }
      }
    }
    AppMethodBeat.o(136876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.PluginMessenger.2
 * JD-Core Version:    0.7.0.1
 */