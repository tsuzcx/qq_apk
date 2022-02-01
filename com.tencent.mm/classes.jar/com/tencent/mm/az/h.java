package com.tencent.mm.az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.Map;

public final class h
  implements p
{
  public final h.b a(String paramString, Map<String, String> paramMap, h.a parama)
  {
    AppMethodBeat.i(184639);
    Log.d("MicroMsg.UpgradeAssociateChatRoomNewXmlMsg", "consumeNewXml， subType:%s", new Object[] { Util.nullAs(paramString, "") });
    if ((Util.nullAsNil(paramString).equals("NewXmlUpgradeAssociateChatRoom")) && (paramMap != null))
    {
      if (!paramMap.containsKey(".sysmsg.NewXmlUpgradeAssociateChatRoom.text")) {
        break label230;
      }
      paramString = Util.nullAsNil((String)paramMap.get(".sysmsg.NewXmlUpgradeAssociateChatRoom.text"));
      paramMap = Util.nullAsNil((String)paramMap.get(".sysmsg.NewXmlUpgradeAssociateChatRoom.roomname"));
      if ((Util.isNullOrNil(paramString)) || (Util.isNullOrNil(paramMap))) {
        break label200;
      }
      parama = new ca();
      parama.nv(0);
      parama.Cy(paramMap);
      parama.setStatus(3);
      parama.setContent(paramString);
      parama.setCreateTime(bp.C(paramMap, System.currentTimeMillis() / 1000L));
      parama.setType(10000);
      parama.setFlag(parama.field_flag | 0x8);
      long l = bp.x(parama);
      Log.i("MicroMsg.UpgradeAssociateChatRoomNewXmlMsg", "chatroom:%s text:%s msgId:%s", new Object[] { paramMap, Util.secPrint(paramString), Long.valueOf(l) });
    }
    for (;;)
    {
      AppMethodBeat.o(184639);
      return null;
      label200:
      Log.i("MicroMsg.UpgradeAssociateChatRoomNewXmlMsg", "chatroom:%s text:%s ", new Object[] { Util.nullAs(paramMap, ""), Util.secPrint(paramString) });
      continue;
      label230:
      Log.i("MicroMsg.UpgradeAssociateChatRoomNewXmlMsg", "no contains text");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.az.h
 * JD-Core Version:    0.7.0.1
 */