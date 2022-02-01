package com.tencent.mm.az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.bi;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import java.util.Map;

public final class g
  implements o
{
  public final f.b a(String paramString, Map<String, String> paramMap, f.a parama)
  {
    AppMethodBeat.i(184639);
    ac.d("MicroMsg.UpgradeAssociateChatRoomNewXmlMsg", "consumeNewXml， subType:%s", new Object[] { bs.bG(paramString, "") });
    if ((bs.nullAsNil(paramString).equals("NewXmlUpgradeAssociateChatRoom")) && (paramMap != null))
    {
      if (!paramMap.containsKey(".sysmsg.NewXmlUpgradeAssociateChatRoom.text")) {
        break label230;
      }
      paramString = bs.nullAsNil((String)paramMap.get(".sysmsg.NewXmlUpgradeAssociateChatRoom.text"));
      paramMap = bs.nullAsNil((String)paramMap.get(".sysmsg.NewXmlUpgradeAssociateChatRoom.roomname"));
      if ((bs.isNullOrNil(paramString)) || (bs.isNullOrNil(paramMap))) {
        break label200;
      }
      parama = new bo();
      parama.jT(0);
      parama.re(paramMap);
      parama.setStatus(3);
      parama.setContent(paramString);
      parama.oA(bi.z(paramMap, System.currentTimeMillis() / 1000L));
      parama.setType(10000);
      parama.setFlag(parama.field_flag | 0x8);
      long l = bi.u(parama);
      ac.i("MicroMsg.UpgradeAssociateChatRoomNewXmlMsg", "chatroom:%s text:%s msgId:%s", new Object[] { paramMap, bs.aLJ(paramString), Long.valueOf(l) });
    }
    for (;;)
    {
      AppMethodBeat.o(184639);
      return null;
      label200:
      ac.i("MicroMsg.UpgradeAssociateChatRoomNewXmlMsg", "chatroom:%s text:%s ", new Object[] { bs.bG(paramMap, ""), bs.aLJ(paramString) });
      continue;
      label230:
      ac.i("MicroMsg.UpgradeAssociateChatRoomNewXmlMsg", "no contains text");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.az.g
 * JD-Core Version:    0.7.0.1
 */