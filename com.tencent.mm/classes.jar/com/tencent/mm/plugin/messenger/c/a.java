package com.tencent.mm.plugin.messenger.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bs;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/messenger/sec/SecurityMsgNewXmlReceived;", "Lcom/tencent/mm/plugin/messenger/foundation/api/INewXmlReceived;", "()V", "TAG", "", "onNewXmlReceived", "", "subType", "values", "", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "plugin-messenger_release"})
public final class a
  implements t
{
  public static final a EVW;
  
  static
  {
    AppMethodBeat.i(213422);
    EVW = new a();
    AppMethodBeat.o(213422);
  }
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, h.a parama)
  {
    AppMethodBeat.i(213421);
    if ((p.h("secmsg", paramString)) && (paramMap != null))
    {
      parama = Util.nullAsNil((String)paramMap.get(".sysmsg.secmsg.session"));
      paramString = Util.nullAsNil((String)paramMap.get(".sysmsg.secmsg.newmsgid"));
      int i = Util.safeParseInt((String)paramMap.get(".sysmsg.secmsg.sec_msg_node.sfn"));
      Object localObject = Util.nullAsNil((String)paramMap.get(".sysmsg.secmsg.sec_msg_node.show-h5"));
      int j = Util.safeParseInt((String)paramMap.get(".sysmsg.secmsg.sec_msg_node.clip-len"));
      String str = Util.nullAsNil((String)paramMap.get(".sysmsg.secmsg.sec_msg_node.share-tip-url"));
      int k = Util.safeParseInt((String)paramMap.get(".sysmsg.secmsg.sec_msg_node.fold-reduce"));
      int m = Util.safeParseInt((String)paramMap.get(".sysmsg.secmsg.sec_msg_node.media-to-emoji"));
      int n = Util.safeParseInt((String)paramMap.get(".sysmsg.secmsg.sec_msg_node.block-range"));
      int i1 = Util.safeParseInt((String)paramMap.get(".sysmsg.secmsg.sec_msg_node.bubble-type"));
      int i2 = Util.safeParseInt((String)paramMap.get(".sysmsg.secmsg.sec_msg_node.preview-type"));
      int i3 = Util.safeParseInt((String)paramMap.get(".sysmsg.secmsg.sec_msg_node.url-click-type"));
      Log.i("MicroMsg.SecurityMsgNewXmlReceived", "msgId:" + Util.safeParseLong(paramString) + " [" + i + "],[" + (String)localObject + "],[" + j + "],[" + str + "],[" + k + "],[" + n + "],[" + m + ']');
      paramMap = (Map)new HashMap();
      paramMap.put(".msgsource.sec_msg_node.sfn", String.valueOf(i));
      p.j(localObject, "showH5");
      paramMap.put(".msgsource.sec_msg_node.show-h5", localObject);
      paramMap.put(".msgsource.sec_msg_node.clip-len", String.valueOf(j));
      p.j(str, "shareTipUrl");
      paramMap.put(".msgsource.sec_msg_node.share-tip-url", str);
      paramMap.put(".msgsource.sec_msg_node.fold-reduce", String.valueOf(k));
      paramMap.put(".msgsource.sec_msg_node.media-to-emoji", String.valueOf(m));
      paramMap.put(".msgsource.sec_msg_node.block-range", String.valueOf(n));
      paramMap.put(".msgsource.sec_msg_node.bubble-type", String.valueOf(i1));
      paramMap.put(".msgsource.sec_msg_node.preview-type", String.valueOf(i2));
      paramMap.put(".msgsource.sec_msg_node.url-click-type", String.valueOf(i3));
      if (!Util.isNullOrNil(new String[] { parama, paramString }))
      {
        localObject = h.ae(n.class);
        p.j(localObject, "MMKernel.service(IMessengerStorage::class.java)");
        parama = ((n)localObject).eSe().aL(parama, Util.safeParseLong(paramString));
        if ((!Util.isNullOrNil(parama.apJ())) && (parama.apH() > 0L))
        {
          bs.a(parama, bs.t(paramMap));
          AppMethodBeat.o(213421);
          return;
        }
        Log.i("MicroMsg.SecurityMsgNewXmlReceived", "msg " + paramString + " not found!");
        bs.e(Util.safeParseLong(paramString), bs.t(paramMap));
      }
      AppMethodBeat.o(213421);
      return;
    }
    AppMethodBeat.o(213421);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.c.a
 * JD-Core Version:    0.7.0.1
 */