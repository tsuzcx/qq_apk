package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

final class j$1$1
  implements Runnable
{
  j$1$1(j.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(135477);
    if (o.kKN.kKS == o.d.kMn)
    {
      ArrayList localArrayList = new ArrayList(5);
      ??? = this.kKr.kKq.kKm.iterator();
      Object localObject3;
      while (((Iterator)???).hasNext())
      {
        localObject3 = (b)((Iterator)???).next();
        o localo = o.kKN;
        boolean bool = o.a((b)localObject3);
        ab.v("MicroMsg.OpenVoice.OpenVoiceMemberMgr", "hy: member %s is talking %b", new Object[] { localObject3, Boolean.valueOf(bool) });
        if (bool) {
          localArrayList.add(localObject3);
        }
      }
      Collections.sort(localArrayList, new j.1.1.1(this));
      if (!j.a(this.kKr.kKq, localArrayList)) {
        synchronized (this.kKr.kKq.kKo)
        {
          localObject3 = this.kKr.kKq.kKo.iterator();
          if (((Iterator)localObject3).hasNext()) {
            ((j.a)((Iterator)localObject3).next()).v(localArrayList);
          }
        }
      }
      this.kKr.kKq.kKn = localObject1;
      AppMethodBeat.o(135477);
      return;
    }
    ab.w("MicroMsg.OpenVoice.OpenVoiceMemberMgr", "hy: not in room, ignore speaker change");
    AppMethodBeat.o(135477);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j.1.1
 * JD-Core Version:    0.7.0.1
 */