package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.b;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import java.util.Map;

public final class b
  implements s
{
  public final g.b a(String paramString, Map<String, String> paramMap, g.a parama)
  {
    AppMethodBeat.i(235741);
    Log.d("MicroMsg.openim.OpenIMChatRoomSendMsgFailedNewXmlMsg", "consumeNewXml subType:%s", new Object[] { Util.nullAs(paramString, "") });
    if ((Util.nullAsNil(paramString).equals("SendMsgFailed")) && (paramMap != null)) {}
    for (;;)
    {
      try
      {
        paramString = Util.nullAsNil((String)paramMap.get(".sysmsg.SendMsgFailed.newmsgid")).trim();
        paramMap = Util.nullAsNil((String)paramMap.get(".sysmsg.SendMsgFailed.tousername")).trim();
        Log.i("MicroMsg.openim.OpenIMChatRoomSendMsgFailedNewXmlMsg", "msgId:%s toUsername:%s", new Object[] { paramString, paramMap });
        paramString = ((n)h.ax(n.class)).gaZ().aU(paramMap, Util.safeParseLong(paramString));
        if (paramString != null) {
          continue;
        }
        Log.e("MicroMsg.openim.OpenIMChatRoomSendMsgFailedNewXmlMsg", "info is null");
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.openim.OpenIMChatRoomSendMsgFailedNewXmlMsg", "consumeNewXml Exception:%s %s", new Object[] { paramString.getClass().getSimpleName(), paramString.getMessage() });
        continue;
      }
      AppMethodBeat.o(235741);
      return null;
      paramString.setStatus(5);
      ((n)h.ax(n.class)).gaZ().a(paramString.field_msgId, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.openim.b.b
 * JD-Core Version:    0.7.0.1
 */