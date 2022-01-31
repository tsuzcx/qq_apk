package com.tencent.mm.plugin.appbrand.jsapi.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.s.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.List;

final class k$1
  implements Runnable
{
  k$1(k paramk) {}
  
  public final void run()
  {
    AppMethodBeat.i(126397);
    synchronized (this.hZe.hZc)
    {
      if (this.hZe.hZc.isEmpty())
      {
        AppMethodBeat.o(126397);
        return;
      }
      ai localai = (ai)this.hZe.hZc.remove(0);
      int i = this.hZe.hZc.size();
      localai.aBz();
      ab.v("MicroMsg.SensorJsEventPublisher", "publish next event(event : %s), list size is : %d.", new Object[] { localai.getName(), Integer.valueOf(i) });
    }
    synchronized (this.hZe.hZc)
    {
      boolean bool = this.hZe.hZc.isEmpty();
      if (!bool) {
        m.aNS().o(this, k.hZb);
      }
      AppMethodBeat.o(126397);
      return;
      localObject1 = finally;
      AppMethodBeat.o(126397);
      throw localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.k.1
 * JD-Core Version:    0.7.0.1
 */