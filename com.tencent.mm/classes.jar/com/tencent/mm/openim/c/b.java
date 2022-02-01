package com.tencent.mm.openim.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.Map;

public final class b
  implements p
{
  public final h.b a(String paramString, Map<String, String> paramMap, h.a parama)
  {
    AppMethodBeat.i(223647);
    Log.d("MicroMsg.openim.OpenIMChatRoomSendMsgFailedNewXmlMsg", "consumeNewXml subType:%s", new Object[] { Util.nullAs(paramString, "") });
    if ((Util.nullAsNil(paramString).equals("SendMsgFailed")) && (paramMap != null)) {}
    try
    {
      paramString = Util.nullAsNil((String)paramMap.get(".sysmsg.SendMsgFailed.newmsgid")).trim();
      paramMap = Util.nullAsNil((String)paramMap.get(".sysmsg.SendMsgFailed.tousername")).trim();
      Log.i("MicroMsg.openim.OpenIMChatRoomSendMsgFailedNewXmlMsg", "msgId:%s toUsername:%s", new Object[] { paramString, paramMap });
      paramString = ((l)g.af(l.class)).eiy().aJ(paramMap, Util.safeParseLong(paramString));
      paramString.setStatus(5);
      ((l)g.af(l.class)).eiy().a(paramString.field_msgId, paramString);
      AppMethodBeat.o(223647);
      return null;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.openim.OpenIMChatRoomSendMsgFailedNewXmlMsg", "consumeNewXml Exception:%s %s", new Object[] { paramString.getClass().getSimpleName(), paramString.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.c.b
 * JD-Core Version:    0.7.0.1
 */