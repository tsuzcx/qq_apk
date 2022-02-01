package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.exdevice.g.a.h;
import com.tencent.mm.plugin.exdevice.g.b.b.a;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.storage.bq;

final class ad$9
  implements n.b
{
  ad$9(ad paramad) {}
  
  public final void a(int paramInt, n paramn, final Object paramObject)
  {
    AppMethodBeat.i(23452);
    try
    {
      if (!bc.ajM())
      {
        ae.w("MicroMsg.exdevice.SubCoreExDevice", "onNotifyChange,acc has not ready");
        AppMethodBeat.o(23452);
        return;
      }
      if ((paramObject instanceof String)) {
        bc.ajU().n(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(23451);
            String str = (String)paramObject;
            if (ad.cmL().adu(str))
            {
              bc.aCg();
              if (!c.azF().aUH(str)) {
                bc.ajj().a(new h(str, null), 0);
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
      ae.e("MicroMsg.exdevice.SubCoreExDevice", "ap : onNotifyChange exception %s", new Object[] { paramn.getMessage() });
      AppMethodBeat.o(23452);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ad.9
 * JD-Core Version:    0.7.0.1
 */