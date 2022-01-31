package com.tencent.mm.plugin.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.plugin.f.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

final class b$2$1
  implements Runnable
{
  b$2$1(b.2 param2, h.c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(18574);
    ab.d("MicroMsg.CalcWxService", "on notify change [%s] [%d]", new Object[] { this.jSF.oDP, Integer.valueOf(this.jSF.oDQ.size()) });
    if ("delete".equals(this.jSF.oDP))
    {
      AppMethodBeat.o(18574);
      return;
    }
    int i;
    Iterator localIterator;
    if ("delete".equals(this.jSF.oDP))
    {
      i = 2;
      localIterator = this.jSF.oDQ.iterator();
    }
    for (;;)
    {
      label94:
      if (!localIterator.hasNext()) {
        break label230;
      }
      Object localObject = (bi)localIterator.next();
      if (localObject != null)
      {
        b localb = this.kkt.kks;
        long l = ((dd)localObject).field_msgId;
        if (localb.kke) {}
        for (boolean bool = localb.kkd.contains(Long.valueOf(l));; bool = false)
        {
          if (!bool) {
            break label199;
          }
          ab.d("MicroMsg.CalcWxService", "it locked now [%d]", new Object[] { Long.valueOf(((dd)localObject).field_msgId) });
          break label94;
          i = 1;
          break;
        }
        label199:
        localObject = new a((bi)localObject, i);
        b.d(this.kkt.kks).ac((Runnable)localObject);
      }
    }
    label230:
    AppMethodBeat.o(18574);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.f.b.2.1
 * JD-Core Version:    0.7.0.1
 */