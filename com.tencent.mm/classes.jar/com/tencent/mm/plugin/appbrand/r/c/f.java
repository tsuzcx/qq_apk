package com.tencent.mm.plugin.appbrand.r.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.g;
import com.tencent.mm.ac.i;
import com.tencent.mm.plugin.appbrand.r.a.b;
import com.tencent.mm.plugin.appbrand.r.a.c;
import com.tencent.mm.sdk.platformtools.ad;

public final class f
  extends b
{
  public final void a(i parami, c paramc)
  {
    AppMethodBeat.i(147397);
    for (;;)
    {
      try
      {
        int i = parami.getInt("level");
        parami = parami.optString("message");
        switch (i)
        {
        case 2: 
          ad.d("MicroMsg.NodeJs", parami);
          AppMethodBeat.o(147397);
          return;
        }
      }
      catch (g parami)
      {
        ad.e("MicroMsg.NodeToXLog", "execute exception : %s", new Object[] { parami });
        paramc.biI();
        AppMethodBeat.o(147397);
        return;
      }
      ad.i("MicroMsg.NodeJs", parami);
      AppMethodBeat.o(147397);
      return;
      ad.w("MicroMsg.NodeJs", parami);
      AppMethodBeat.o(147397);
      return;
      ad.e("MicroMsg.NodeJs", parami);
      AppMethodBeat.o(147397);
      return;
    }
  }
  
  public final int biH()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.c.f
 * JD-Core Version:    0.7.0.1
 */