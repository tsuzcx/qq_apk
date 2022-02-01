package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.exdevice.g.a.h;
import com.tencent.mm.plugin.exdevice.g.b.b.a;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.storage.bp;

final class ad$9
  implements n.b
{
  ad$9(ad paramad) {}
  
  public final void a(int paramInt, n paramn, final Object paramObject)
  {
    AppMethodBeat.i(23452);
    try
    {
      if (!ba.ajx())
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.exdevice.SubCoreExDevice", "onNotifyChange,acc has not ready");
        AppMethodBeat.o(23452);
        return;
      }
      if ((paramObject instanceof String)) {
        ba.ajF().n(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(23451);
            String str = (String)paramObject;
            if (ad.clv().acD(str))
            {
              ba.aBQ();
              if (!c.azp().aTg(str)) {
                ba.aiU().a(new h(str, null), 0);
              }
            }
            AppMethodBeat.o(23451);
          }
        }, 2000L);
      }
      AppMethodBeat.o(23452);
      return;
    }
    catch (Exception paramn)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.exdevice.SubCoreExDevice", "ap : onNotifyChange exception %s", new Object[] { paramn.getMessage() });
      AppMethodBeat.o(23452);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ad.9
 * JD-Core Version:    0.7.0.1
 */