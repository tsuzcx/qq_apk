package com.tencent.mm.plugin.card.b;

import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.List;

final class c$2
  implements am.a
{
  c$2(c paramc) {}
  
  public final boolean tC()
  {
    y.i("MicroMsg.CardCodeMgr", "onTimerExpired, do refresh code one minute");
    c localc = this.ikg;
    y.i("MicroMsg.CardCodeMgr", "onCodeChange()");
    if (localc.fKm != null)
    {
      int i = 0;
      while (i < localc.fKm.size())
      {
        Object localObject = (WeakReference)localc.fKm.get(i);
        if (localObject != null)
        {
          localObject = (c.a)((WeakReference)localObject).get();
          if (localObject != null) {
            ((c.a)localObject).azP();
          }
        }
        i += 1;
      }
    }
    this.ikg.azN();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.c.2
 * JD-Core Version:    0.7.0.1
 */