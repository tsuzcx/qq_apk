package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.b;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bv;
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
    bc.aCg();
    localObject = c.azI().ia(paramString, (String)localObject);
    if ((localObject == null) || (((LinkedList)localObject).isEmpty()))
    {
      AppMethodBeat.o(20316);
      return null;
    }
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      final bv localbv = (bv)((Iterator)localObject).next();
      if ((localbv.eNc & 0x4) != 4)
      {
        localbv.setContent(paramMap);
        localbv.setType(10000);
        bl.a(localbv, parama);
        bc.aCg();
        c.azI().a(localbv.field_msgId, localbv);
      }
      bc.aCg();
      au localau = c.azL().aVa(paramString);
      if ((localau != null) && (localau.field_unReadCount > 0))
      {
        bc.aCg();
        int i = c.azI().aq(localbv);
        if (localau.field_unReadCount >= i)
        {
          localau.kr(localau.field_unReadCount - 1);
          bc.aCg();
          c.azL().a(localau, localau.field_username);
        }
      }
      if (localbv != null) {
        g.ajU().aw(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(186355);
            ae.i("MicroMsg.BizChatSysCmdMsgConsumerHandleRevokeMsg", "[deleteLocalFile] id:%s type:%s", new Object[] { Long.valueOf(localbv.field_msgId), Integer.valueOf(localbv.getType()) });
            switch (localbv.getType())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(186355);
              return;
              bl.x(localbv);
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