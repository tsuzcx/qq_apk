package com.tencent.mm.plugin.appbrand.v.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.g;
import com.tencent.mm.plugin.appbrand.v.a.b;
import com.tencent.mm.plugin.appbrand.v.a.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class i
  extends b
{
  public final void a(com.tencent.mm.ad.i parami, c paramc)
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
          Log.d("MicroMsg.NodeJs", parami);
          AppMethodBeat.o(147397);
          return;
        }
      }
      catch (g parami)
      {
        Log.e("MicroMsg.NodeToXLog", "execute exception : %s", new Object[] { parami });
        paramc.Cz(2);
        AppMethodBeat.o(147397);
        return;
      }
      Log.i("MicroMsg.NodeJs", parami);
      AppMethodBeat.o(147397);
      return;
      Log.w("MicroMsg.NodeJs", parami);
      AppMethodBeat.o(147397);
      return;
      Log.e("MicroMsg.NodeJs", parami);
      AppMethodBeat.o(147397);
      return;
    }
  }
  
  public final int cCX()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.c.i
 * JD-Core Version:    0.7.0.1
 */