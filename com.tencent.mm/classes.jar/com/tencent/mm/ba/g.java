package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.bi;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import java.util.Map;

public final class g
  implements o
{
  public final f.b a(String paramString, Map<String, String> paramMap, f.a parama)
  {
    AppMethodBeat.i(184639);
    ad.d("MicroMsg.UpgradeAssociateChatRoomNewXmlMsg", "consumeNewXml， subType:%s", new Object[] { bt.by(paramString, "") });
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
      parama = new bl();
      parama.jV(0);
      parama.nY(paramMap);
      parama.setStatus(3);
      parama.setContent(paramString);
      parama.kY(bi.y(paramMap, System.currentTimeMillis() / 1000L));
      parama.setType(10000);
      parama.setFlag(parama.field_flag | 0x8);
      long l = bi.u(parama);
      ad.i("MicroMsg.UpgradeAssociateChatRoomNewXmlMsg", "chatroom:%s text:%s msgId:%s", new Object[] { paramMap, bt.aGs(paramString), Long.valueOf(l) });
    }
    for (;;)
    {
      AppMethodBeat.o(184639);
      return null;
      label200:
      ad.i("MicroMsg.UpgradeAssociateChatRoomNewXmlMsg", "chatroom:%s text:%s ", new Object[] { bt.by(paramMap, ""), bt.aGs(paramString) });
      continue;
      label230:
      ad.i("MicroMsg.UpgradeAssociateChatRoomNewXmlMsg", "no contains text");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ba.g
 * JD-Core Version:    0.7.0.1
 */