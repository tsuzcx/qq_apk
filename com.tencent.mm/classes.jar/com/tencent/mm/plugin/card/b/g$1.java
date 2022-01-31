package com.tencent.mm.plugin.card.b;

import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.List;

final class g$1
  implements am.a
{
  g$1(g paramg) {}
  
  public final boolean tC()
  {
    y.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onTimerExpired, do refresh code!");
    g localg = this.iku;
    y.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onShowTimeExpired()");
    if (localg.fKm != null)
    {
      int i = 0;
      while (i < localg.fKm.size())
      {
        Object localObject = (WeakReference)localg.fKm.get(i);
        if (localObject != null)
        {
          localObject = (g.a)((WeakReference)localObject).get();
          if (localObject != null) {
            ((g.a)localObject).azX();
          }
        }
        i += 1;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.g.1
 * JD-Core Version:    0.7.0.1
 */