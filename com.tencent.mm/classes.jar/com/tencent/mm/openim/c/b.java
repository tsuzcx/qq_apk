package com.tencent.mm.openim.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import java.util.Map;

public final class b
  implements o
{
  public final f.b a(String paramString, Map<String, String> paramMap, f.a parama)
  {
    AppMethodBeat.i(190717);
    ad.d("MicroMsg.openim.OpenIMChatRoomSendMsgFailedNewXmlMsg", "consumeNewXml subType:%s", new Object[] { bt.by(paramString, "") });
    if ((bt.nullAsNil(paramString).equals("SendMsgFailed")) && (paramMap != null)) {}
    try
    {
      paramString = bt.nullAsNil((String)paramMap.get(".sysmsg.SendMsgFailed.newmsgid")).trim();
      paramMap = bt.nullAsNil((String)paramMap.get(".sysmsg.SendMsgFailed.tousername")).trim();
      ad.i("MicroMsg.openim.OpenIMChatRoomSendMsgFailedNewXmlMsg", "msgId:%s toUsername:%s", new Object[] { paramString, paramMap });
      paramString = ((k)g.ab(k.class)).cOI().aD(paramMap, bt.aGi(paramString));
      paramString.setStatus(5);
      ((k)g.ab(k.class)).cOI().a(paramString.field_msgId, paramString);
      AppMethodBeat.o(190717);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.openim.c.b
 * JD-Core Version:    0.7.0.1
 */