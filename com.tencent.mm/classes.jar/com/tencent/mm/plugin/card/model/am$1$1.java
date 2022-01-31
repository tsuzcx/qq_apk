package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.hf;
import com.tencent.mm.h.a.hf.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.sharecard.a.a;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class am$1$1
  implements Runnable
{
  am$1$1(am.1 param1, hf paramhf) {}
  
  public final void run()
  {
    if (!g.DK()) {
      return;
    }
    boolean bool1 = this.ios.bPc.bPd;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SubCoreCard.cardGetCountListener", "GetCardCountEvent isForceGet is " + bool1);
    boolean bool2 = l.aDd();
    boolean bool3 = l.aDf();
    if ((bool2) && (bool3))
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SubCoreCard.cardGetCountListener", "card entrance and share card entrance is open");
      return;
    }
    if (bool1) {
      g.DO().dJT.a(new y(), 0);
    }
    label237:
    for (;;)
    {
      if (bool3)
      {
        localObject = (Long)g.DP().Dz().get(ac.a.upg, Long.valueOf(0L));
        if ((localObject != null) && (((Long)localObject).longValue() == 0L)) {
          am.aAz().aAN();
        }
      }
      if ((!bool2) || (!TextUtils.isEmpty((String)g.DP().Dz().get(ac.a.uoW, null)))) {
        break;
      }
      am.aAr();
      com.tencent.mm.plugin.card.b.b.oM(1);
      return;
      Object localObject = (Integer)g.DP().Dz().get(282882, null);
      if (localObject != null) {}
      for (int i = ((Integer)localObject).intValue();; i = 0)
      {
        if ((int)(System.currentTimeMillis() / 1000L) - i < 7200) {
          break label237;
        }
        g.DO().dJT.a(new y(), 0);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.am.1.1
 * JD-Core Version:    0.7.0.1
 */