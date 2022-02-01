package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bj;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import java.util.Map;

public final class h
  implements p
{
  public final e.b a(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(184639);
    ad.d("MicroMsg.UpgradeAssociateChatRoomNewXmlMsg", "consumeNewXml， subType:%s", new Object[] { bt.bI(paramString, "") });
    if ((bt.nullAsNil(paramString).equals("NewXmlUpgradeAssociateChatRoom")) && (paramMap != null))
    {
      if (!paramMap.containsKey(".sysmsg.NewXmlUpgradeAssociateChatRoom.text")) {
        break label230;
      }
      paramString = bt.nullAsNil((String)paramMap.get(".sysmsg.NewXmlUpgradeAssociateChatRoom.text"));
      paramMap = bt.nullAsNil((String)paramMap.get(".sysmsg.NewXmlUpgradeAssociateChatRoom.roomname"));
      if ((bt.isNullOrNil(paramString)) || (bt.isNullOrNil(paramMap))) {
        break label200;
      }
      parama = new bu();
      parama.kr(0);
      parama.tN(paramMap);
      parama.setStatus(3);
      parama.setContent(paramString);
      parama.qA(bj.B(paramMap, System.currentTimeMillis() / 1000L));
      parama.setType(10000);
      parama.setFlag(parama.field_flag | 0x8);
      long l = bj.v(parama);
      ad.i("MicroMsg.UpgradeAssociateChatRoomNewXmlMsg", "chatroom:%s text:%s msgId:%s", new Object[] { paramMap, bt.aRp(paramString), Long.valueOf(l) });
    }
    for (;;)
    {
      AppMethodBeat.o(184639);
      return null;
      label200:
      ad.i("MicroMsg.UpgradeAssociateChatRoomNewXmlMsg", "chatroom:%s text:%s ", new Object[] { bt.bI(paramMap, ""), bt.aRp(paramString) });
      continue;
      label230:
      ad.i("MicroMsg.UpgradeAssociateChatRoomNewXmlMsg", "no contains text");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ba.h
 * JD-Core Version:    0.7.0.1
 */