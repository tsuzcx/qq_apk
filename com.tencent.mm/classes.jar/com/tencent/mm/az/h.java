package com.tencent.mm.az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bl;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import java.util.Map;

public final class h
  implements p
{
  public final e.b a(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(184639);
    ae.d("MicroMsg.UpgradeAssociateChatRoomNewXmlMsg", "consumeNewXml， subType:%s", new Object[] { bu.bI(paramString, "") });
    if ((bu.nullAsNil(paramString).equals("NewXmlUpgradeAssociateChatRoom")) && (paramMap != null))
    {
      if (!paramMap.containsKey(".sysmsg.NewXmlUpgradeAssociateChatRoom.text")) {
        break label230;
      }
      paramString = bu.nullAsNil((String)paramMap.get(".sysmsg.NewXmlUpgradeAssociateChatRoom.text"));
      paramMap = bu.nullAsNil((String)paramMap.get(".sysmsg.NewXmlUpgradeAssociateChatRoom.roomname"));
      if ((bu.isNullOrNil(paramString)) || (bu.isNullOrNil(paramMap))) {
        break label200;
      }
      parama = new bv();
      parama.kt(0);
      parama.ui(paramMap);
      parama.setStatus(3);
      parama.setContent(paramString);
      parama.qN(bl.B(paramMap, System.currentTimeMillis() / 1000L));
      parama.setType(10000);
      parama.setFlag(parama.field_flag | 0x8);
      long l = bl.v(parama);
      ae.i("MicroMsg.UpgradeAssociateChatRoomNewXmlMsg", "chatroom:%s text:%s msgId:%s", new Object[] { paramMap, bu.aSM(paramString), Long.valueOf(l) });
    }
    for (;;)
    {
      AppMethodBeat.o(184639);
      return null;
      label200:
      ae.i("MicroMsg.UpgradeAssociateChatRoomNewXmlMsg", "chatroom:%s text:%s ", new Object[] { bu.bI(paramMap, ""), bu.aSM(paramString) });
      continue;
      label230:
      ae.i("MicroMsg.UpgradeAssociateChatRoomNewXmlMsg", "no contains text");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.az.h
 * JD-Core Version:    0.7.0.1
 */