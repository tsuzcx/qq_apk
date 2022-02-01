package com.tencent.mm.plugin.messenger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bl;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Map;

final class PluginMessenger$5
  implements q
{
  PluginMessenger$5(PluginMessenger paramPluginMessenger) {}
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(211824);
    if ("secmsg".equals(paramString))
    {
      parama = bt.nullAsNil((String)paramMap.get(".sysmsg.secmsg.session"));
      paramString = bt.nullAsNil((String)paramMap.get(".sysmsg.secmsg.newmsgid"));
      int i = bt.aRe((String)paramMap.get(".sysmsg.secmsg.sec_msg_node.sfn"));
      String str1 = bt.nullAsNil((String)paramMap.get(".sysmsg.secmsg.sec_msg_node.show-h5"));
      int j = bt.aRe((String)paramMap.get(".sysmsg.secmsg.sec_msg_node.clip-len"));
      String str2 = bt.nullAsNil((String)paramMap.get(".sysmsg.secmsg.sec_msg_node.share-tip-url"));
      int k = bt.aRe((String)paramMap.get(".sysmsg.secmsg.sec_msg_node.fold-reduce"));
      ad.i("MicroMsg.PluginMessenger", "[%d],[%s],[%d],[%s],[%d]", new Object[] { Integer.valueOf(i), str1, Integer.valueOf(j), str2, Integer.valueOf(k) });
      paramMap = new HashMap();
      paramMap.put(".msgsource.sec_msg_node.sfn", String.valueOf(i));
      paramMap.put(".msgsource.sec_msg_node.show-h5", str1);
      paramMap.put(".msgsource.sec_msg_node.clip-len", String.valueOf(j));
      paramMap.put(".msgsource.sec_msg_node.share-tip-url", str2);
      paramMap.put(".msgsource.sec_msg_node.fold-reduce", String.valueOf(k));
      if (!bt.V(new String[] { parama, paramString }))
      {
        parama = ((l)g.ab(l.class)).dlK().aI(parama, bt.aRf(paramString));
        if ((!bt.isNullOrNil(parama.field_talker)) && (parama.field_msgSvrId > 0L))
        {
          bl.a(parama, bl.r(paramMap));
          AppMethodBeat.o(211824);
          return;
        }
        ad.i("MicroMsg.PluginMessenger", "msg %s not found!", new Object[] { paramString });
        bl.d(bt.aRf(paramString), bl.r(paramMap));
      }
    }
    AppMethodBeat.o(211824);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.PluginMessenger.5
 * JD-Core Version:    0.7.0.1
 */