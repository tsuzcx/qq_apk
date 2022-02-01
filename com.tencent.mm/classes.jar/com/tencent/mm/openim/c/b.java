package com.tencent.mm.openim.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import java.util.Map;

public final class b
  implements o
{
  public final f.b a(String paramString, Map<String, String> paramMap, f.a parama)
  {
    AppMethodBeat.i(192614);
    ac.d("MicroMsg.openim.OpenIMChatRoomSendMsgFailedNewXmlMsg", "consumeNewXml subType:%s", new Object[] { bs.bG(paramString, "") });
    if ((bs.nullAsNil(paramString).equals("SendMsgFailed")) && (paramMap != null)) {}
    try
    {
      paramString = bs.nullAsNil((String)paramMap.get(".sysmsg.SendMsgFailed.newmsgid")).trim();
      paramMap = bs.nullAsNil((String)paramMap.get(".sysmsg.SendMsgFailed.tousername")).trim();
      ac.i("MicroMsg.openim.OpenIMChatRoomSendMsgFailedNewXmlMsg", "msgId:%s toUsername:%s", new Object[] { paramString, paramMap });
      paramString = ((k)g.ab(k.class)).dcr().aF(paramMap, bs.aLz(paramString));
      paramString.setStatus(5);
      ((k)g.ab(k.class)).dcr().a(paramString.field_msgId, paramString);
      AppMethodBeat.o(192614);
      return null;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ac.e("MicroMsg.openim.OpenIMChatRoomSendMsgFailedNewXmlMsg", "consumeNewXml Exception:%s %s", new Object[] { paramString.getClass().getSimpleName(), paramString.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.openim.c.b
 * JD-Core Version:    0.7.0.1
 */