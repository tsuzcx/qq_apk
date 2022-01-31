package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.hj;
import com.tencent.mm.g.a.hj.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.sharecard.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class am$1$1
  implements Runnable
{
  am$1$1(am.1 param1, hj paramhj) {}
  
  public final void run()
  {
    AppMethodBeat.i(87930);
    if (!g.RG())
    {
      AppMethodBeat.o(87930);
      return;
    }
    boolean bool1 = this.kpn.cwv.cww;
    ab.i("MicroMsg.SubCoreCard.cardGetCountListener", "GetCardCountEvent isForceGet is ".concat(String.valueOf(bool1)));
    boolean bool2 = l.bfA();
    boolean bool3 = l.bfC();
    if ((bool2) && (bool3))
    {
      ab.i("MicroMsg.SubCoreCard.cardGetCountListener", "card entrance and share card entrance is open");
      AppMethodBeat.o(87930);
      return;
    }
    if (bool1) {
      g.RK().eHt.a(new y(), 0);
    }
    label250:
    for (;;)
    {
      if (bool3)
      {
        localObject = (Long)g.RL().Ru().get(ac.a.yzc, Long.valueOf(0L));
        if ((localObject != null) && (((Long)localObject).longValue() == 0L)) {
          am.bck().bcy();
        }
      }
      if ((bool2) && (TextUtils.isEmpty((String)g.RL().Ru().get(ac.a.yyS, null))))
      {
        am.bcc();
        com.tencent.mm.plugin.card.b.b.sW(1);
      }
      AppMethodBeat.o(87930);
      return;
      Object localObject = (Integer)g.RL().Ru().get(282882, null);
      if (localObject != null) {}
      for (int i = ((Integer)localObject).intValue();; i = 0)
      {
        if ((int)(System.currentTimeMillis() / 1000L) - i < 7200) {
          break label250;
        }
        g.RK().eHt.a(new y(), 0);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.am.1.1
 * JD-Core Version:    0.7.0.1
 */