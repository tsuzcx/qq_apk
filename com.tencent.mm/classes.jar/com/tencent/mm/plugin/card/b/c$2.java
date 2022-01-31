package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;
import java.lang.ref.WeakReference;
import java.util.List;

final class c$2
  implements ap.a
{
  c$2(c paramc) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(87638);
    ab.i("MicroMsg.CardCodeMgr", "onTimerExpired, do refresh code one minute");
    c localc = this.klg;
    ab.i("MicroMsg.CardCodeMgr", "onCodeChange()");
    if (localc.kkV != null)
    {
      int i = 0;
      while (i < localc.kkV.size())
      {
        Object localObject = (WeakReference)localc.kkV.get(i);
        if (localObject != null)
        {
          localObject = (c.a)((WeakReference)localObject).get();
          if (localObject != null) {
            ((c.a)localObject).bbx();
          }
        }
        i += 1;
      }
    }
    this.klg.bbv();
    AppMethodBeat.o(87638);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.c.2
 * JD-Core Version:    0.7.0.1
 */