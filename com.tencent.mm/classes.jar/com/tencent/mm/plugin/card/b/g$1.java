package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;
import java.lang.ref.WeakReference;
import java.util.List;

final class g$1
  implements ap.a
{
  g$1(g paramg) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(87680);
    ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onTimerExpired, do refresh code!");
    g localg = this.klt;
    ab.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onShowTimeExpired()");
    if (localg.kkV != null)
    {
      int i = 0;
      while (i < localg.kkV.size())
      {
        Object localObject = (WeakReference)localg.kkV.get(i);
        if (localObject != null)
        {
          localObject = (g.a)((WeakReference)localObject).get();
          if (localObject != null) {
            ((g.a)localObject).bbI();
          }
        }
        i += 1;
      }
    }
    AppMethodBeat.o(87680);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.g.1
 * JD-Core Version:    0.7.0.1
 */