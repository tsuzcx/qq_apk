package com.tencent.mm.openim.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import java.util.Map;

public final class b
  implements p
{
  public final e.b a(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(218747);
    ae.d("MicroMsg.openim.OpenIMChatRoomSendMsgFailedNewXmlMsg", "consumeNewXml subType:%s", new Object[] { bu.bI(paramString, "") });
    if ((bu.nullAsNil(paramString).equals("SendMsgFailed")) && (paramMap != null)) {}
    try
    {
      paramString = bu.nullAsNil((String)paramMap.get(".sysmsg.SendMsgFailed.newmsgid")).trim();
      paramMap = bu.nullAsNil((String)paramMap.get(".sysmsg.SendMsgFailed.tousername")).trim();
      ae.i("MicroMsg.openim.OpenIMChatRoomSendMsgFailedNewXmlMsg", "msgId:%s toUsername:%s", new Object[] { paramString, paramMap });
      paramString = ((l)g.ab(l.class)).doJ().aJ(paramMap, bu.aSC(paramString));
      paramString.setStatus(5);
      ((l)g.ab(l.class)).doJ().a(paramString.field_msgId, paramString);
      AppMethodBeat.o(218747);
      return null;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ae.e("MicroMsg.openim.OpenIMChatRoomSendMsgFailedNewXmlMsg", "consumeNewXml Exception:%s %s", new Object[] { paramString.getClass().getSimpleName(), paramString.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.openim.c.b
 * JD-Core Version:    0.7.0.1
 */