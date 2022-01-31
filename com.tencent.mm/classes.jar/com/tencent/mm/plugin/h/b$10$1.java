package com.tencent.mm.plugin.h;

import com.tencent.mm.h.c.cs;
import com.tencent.mm.plugin.h.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.c;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

final class b$10$1
  implements Runnable
{
  b$10$1(b.10 param10, g.c paramc) {}
  
  public final void run()
  {
    y.d("MicroMsg.CalcWxService", "on notify change [%s] [%d]", new Object[] { this.ijy.mdt, Integer.valueOf(this.ijy.mdu.size()) });
    if ("delete".equals(this.ijy.mdt)) {}
    label82:
    label216:
    for (;;)
    {
      return;
      int i;
      Iterator localIterator;
      if ("delete".equals(this.ijy.mdt))
      {
        i = 2;
        localIterator = this.ijy.mdu.iterator();
      }
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label216;
        }
        Object localObject = (bi)localIterator.next();
        if (localObject != null)
        {
          b localb = this.ijz.ijs;
          long l = ((cs)localObject).field_msgId;
          if (localb.ije) {}
          for (boolean bool = localb.ijd.contains(Long.valueOf(l));; bool = false)
          {
            if (!bool) {
              break label187;
            }
            y.d("MicroMsg.CalcWxService", "it locked now [%d]", new Object[] { Long.valueOf(((cs)localObject).field_msgId) });
            break label82;
            i = 1;
            break;
          }
          localObject = new a((bi)localObject, i);
          b.d(this.ijz.ijs).O((Runnable)localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.h.b.10.1
 * JD-Core Version:    0.7.0.1
 */