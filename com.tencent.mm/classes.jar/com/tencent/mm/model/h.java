package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.b;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class h
  implements f.b
{
  public final g.b a(String paramString, Map<String, String> paramMap, g.a parama)
  {
    AppMethodBeat.i(20316);
    paramString = (String)paramMap.get(".sysmsg.brand_username");
    Object localObject = (String)paramMap.get(".sysmsg.revoke_climsgid");
    paramMap = (String)paramMap.get(".sysmsg.replacemsg");
    bh.bCz();
    localObject = c.bzD().ki(paramString, (String)localObject);
    if ((localObject == null) || (((LinkedList)localObject).isEmpty()))
    {
      AppMethodBeat.o(20316);
      return null;
    }
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      final cc localcc = (cc)((Iterator)localObject).next();
      if ((localcc.jUq & 0x4) != 4)
      {
        localcc.setContent(paramMap);
        localcc.setType(10000);
        br.a(localcc, parama);
        bh.bCz();
        c.bzD().a(localcc.field_msgId, localcc);
      }
      bh.bCz();
      bb localbb = c.bzG().bxM(paramString);
      if ((localbb != null) && (localbb.field_unReadCount > 0))
      {
        bh.bCz();
        int i = c.bzD().aZ(localcc);
        if (localbb.field_unReadCount >= i)
        {
          localbb.pG(localbb.field_unReadCount - 1);
          bh.bCz();
          c.bzG().c(localbb, localbb.field_username);
        }
      }
      if (localcc != null) {
        com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(241859);
            Log.i("MicroMsg.BizChatSysCmdMsgConsumerHandleRevokeMsg", "[deleteLocalFile] id:%s type:%s", new Object[] { Long.valueOf(localcc.field_msgId), Integer.valueOf(localcc.getType()) });
            switch (localcc.getType())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(241859);
              return;
              br.D(localcc);
            }
          }
        });
      }
    }
    AppMethodBeat.o(20316);
    return null;
  }
  
  public final String bAm()
  {
    return "qy_revoke_msg";
  }
  
  public final boolean bAn()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.h
 * JD-Core Version:    0.7.0.1
 */