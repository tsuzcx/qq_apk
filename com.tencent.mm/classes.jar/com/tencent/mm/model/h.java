package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bu;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class h
  implements f.b
{
  public final e.b a(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(20316);
    paramString = (String)paramMap.get(".sysmsg.brand_username");
    Object localObject = (String)paramMap.get(".sysmsg.revoke_climsgid");
    paramMap = (String)paramMap.get(".sysmsg.replacemsg");
    ba.aBQ();
    localObject = c.azs().hT(paramString, (String)localObject);
    if ((localObject == null) || (((LinkedList)localObject).isEmpty()))
    {
      AppMethodBeat.o(20316);
      return null;
    }
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      final bu localbu = (bu)((Iterator)localObject).next();
      if ((localbu.eLr & 0x4) != 4)
      {
        localbu.setContent(paramMap);
        localbu.setType(10000);
        bj.a(localbu, parama);
        ba.aBQ();
        c.azs().a(localbu.field_msgId, localbu);
      }
      ba.aBQ();
      at localat = c.azv().aTz(paramString);
      if ((localat != null) && (localat.field_unReadCount > 0))
      {
        ba.aBQ();
        int i = c.azs().ar(localbu);
        if (localat.field_unReadCount >= i)
        {
          localat.kp(localat.field_unReadCount - 1);
          ba.aBQ();
          c.azv().a(localat, localat.field_username);
        }
      }
      if (localbu != null) {
        g.ajF().ay(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(193114);
            ad.i("MicroMsg.BizChatSysCmdMsgConsumerHandleRevokeMsg", "[deleteLocalFile] id:%s type:%s", new Object[] { Long.valueOf(localbu.field_msgId), Integer.valueOf(localbu.getType()) });
            switch (localbu.getType())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(193114);
              return;
              bj.x(localbu);
            }
          }
        });
      }
    }
    AppMethodBeat.o(20316);
    return null;
  }
  
  public final String getSubType()
  {
    return "qy_revoke_msg";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.h
 * JD-Core Version:    0.7.0.1
 */