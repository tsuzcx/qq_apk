package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.b;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.f.c.et;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class h
  implements f.b
{
  public final h.b a(String paramString, Map<String, String> paramMap, h.a parama)
  {
    AppMethodBeat.i(20316);
    paramString = (String)paramMap.get(".sysmsg.brand_username");
    Object localObject = (String)paramMap.get(".sysmsg.revoke_climsgid");
    paramMap = (String)paramMap.get(".sysmsg.replacemsg");
    bh.beI();
    localObject = c.bbO().iU(paramString, (String)localObject);
    if ((localObject == null) || (((LinkedList)localObject).isEmpty()))
    {
      AppMethodBeat.o(20316);
      return null;
    }
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      final ca localca = (ca)((Iterator)localObject).next();
      if ((localca.hxx & 0x4) != 4)
      {
        localca.setContent(paramMap);
        localca.setType(10000);
        bq.a(localca, parama);
        bh.beI();
        c.bbO().a(localca.field_msgId, localca);
      }
      bh.beI();
      az localaz = c.bbR().bwx(paramString);
      if ((localaz != null) && (localaz.field_unReadCount > 0))
      {
        bh.beI();
        int i = c.bbO().aL(localca);
        if (localaz.field_unReadCount >= i)
        {
          localaz.pH(localaz.field_unReadCount - 1);
          bh.beI();
          c.bbR().a(localaz, localaz.field_username);
        }
      }
      if (localca != null) {
        com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(279948);
            Log.i("MicroMsg.BizChatSysCmdMsgConsumerHandleRevokeMsg", "[deleteLocalFile] id:%s type:%s", new Object[] { Long.valueOf(localca.field_msgId), Integer.valueOf(localca.getType()) });
            switch (localca.getType())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(279948);
              return;
              bq.B(localca);
            }
          }
        });
      }
    }
    AppMethodBeat.o(20316);
    return null;
  }
  
  public final String bcy()
  {
    return "qy_revoke_msg";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.h
 * JD-Core Version:    0.7.0.1
 */