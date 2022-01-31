package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Timer;

final class e$1$1
  implements Runnable
{
  e$1$1(e.1 param1) {}
  
  public final void run()
  {
    if (j.iFl.iFq == j.c.iGu)
    {
      ArrayList localArrayList = new ArrayList(5);
      ??? = this.iES.iER.iEN.iterator();
      Object localObject3;
      while (((Iterator)???).hasNext())
      {
        localObject3 = (a)((Iterator)???).next();
        j localj = j.iFl;
        boolean bool = j.a((a)localObject3);
        y.v("MicroMsg.OpenVoice.OpenVoiceMemberMgr", "hy: member %s is talking %b", new Object[] { localObject3, Boolean.valueOf(bool) });
        if (bool) {
          localArrayList.add(localObject3);
        }
      }
      Collections.sort(localArrayList, new e.1.1.1(this));
      if (!e.a(this.iES.iER, localArrayList)) {
        synchronized (this.iES.iER.iEP)
        {
          localObject3 = this.iES.iER.iEP.iterator();
          if (((Iterator)localObject3).hasNext()) {
            ((e.a)((Iterator)localObject3).next()).q(localArrayList);
          }
        }
      }
      this.iES.iER.iEO = localObject1;
      return;
    }
    y.w("MicroMsg.OpenVoice.OpenVoiceMemberMgr", "hy: not in room, stop check member change");
    this.iES.iER.iEQ.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.e.1.1
 * JD-Core Version:    0.7.0.1
 */