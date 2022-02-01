package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.b;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
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
    bg.aVF();
    localObject = c.aSQ().iJ(paramString, (String)localObject);
    if ((localObject == null) || (((LinkedList)localObject).isEmpty()))
    {
      AppMethodBeat.o(20316);
      return null;
    }
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      final ca localca = (ca)((Iterator)localObject).next();
      if ((localca.fqJ & 0x4) != 4)
      {
        localca.setContent(paramMap);
        localca.setType(10000);
        bp.a(localca, parama);
        bg.aVF();
        c.aSQ().a(localca.field_msgId, localca);
      }
      bg.aVF();
      az localaz = c.aST().bjY(paramString);
      if ((localaz != null) && (localaz.field_unReadCount > 0))
      {
        bg.aVF();
        int i = c.aSQ().aB(localca);
        if (localaz.field_unReadCount >= i)
        {
          localaz.nt(localaz.field_unReadCount - 1);
          bg.aVF();
          c.aST().a(localaz, localaz.field_username);
        }
      }
      if (localca != null) {
        g.aAk().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(231537);
            Log.i("MicroMsg.BizChatSysCmdMsgConsumerHandleRevokeMsg", "[deleteLocalFile] id:%s type:%s", new Object[] { Long.valueOf(localca.field_msgId), Integer.valueOf(localca.getType()) });
            switch (localca.getType())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(231537);
              return;
              bp.z(localca);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.h
 * JD-Core Version:    0.7.0.1
 */