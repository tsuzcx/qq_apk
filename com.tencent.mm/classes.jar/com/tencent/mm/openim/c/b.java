package com.tencent.mm.openim.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import java.util.Map;

public final class b
  implements p
{
  public final e.b a(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(195294);
    ad.d("MicroMsg.openim.OpenIMChatRoomSendMsgFailedNewXmlMsg", "consumeNewXml subType:%s", new Object[] { bt.bI(paramString, "") });
    if ((bt.nullAsNil(paramString).equals("SendMsgFailed")) && (paramMap != null)) {}
    try
    {
      paramString = bt.nullAsNil((String)paramMap.get(".sysmsg.SendMsgFailed.newmsgid")).trim();
      paramMap = bt.nullAsNil((String)paramMap.get(".sysmsg.SendMsgFailed.tousername")).trim();
      ad.i("MicroMsg.openim.OpenIMChatRoomSendMsgFailedNewXmlMsg", "msgId:%s toUsername:%s", new Object[] { paramString, paramMap });
      paramString = ((l)g.ab(l.class)).dlK().aI(paramMap, bt.aRf(paramString));
      paramString.setStatus(5);
      ((l)g.ab(l.class)).dlK().a(paramString.field_msgId, paramString);
      AppMethodBeat.o(195294);
      return null;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ad.e("MicroMsg.openim.OpenIMChatRoomSendMsgFailedNewXmlMsg", "consumeNewXml Exception:%s %s", new Object[] { paramString.getClass().getSimpleName(), paramString.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.c.b
 * JD-Core Version:    0.7.0.1
 */