package com.tencent.mm.plugin.appbrand.n.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.g;
import com.tencent.mm.aa.i;
import com.tencent.mm.plugin.appbrand.n.a.b;
import com.tencent.mm.plugin.appbrand.n.a.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class f
  extends b
{
  public final void a(i parami, c paramc)
  {
    AppMethodBeat.i(102197);
    for (;;)
    {
      try
      {
        int i = parami.getInt("level");
        parami = parami.optString("message");
        switch (i)
        {
        case 2: 
          ab.d("MicroMsg.NodeJs", parami);
          AppMethodBeat.o(102197);
          return;
        }
      }
      catch (g parami)
      {
        ab.e("MicroMsg.NodeToXLog", "execute exception : %s", new Object[] { parami });
        paramc.aIB();
        AppMethodBeat.o(102197);
        return;
      }
      ab.i("MicroMsg.NodeJs", parami);
      AppMethodBeat.o(102197);
      return;
      ab.w("MicroMsg.NodeJs", parami);
      AppMethodBeat.o(102197);
      return;
      ab.e("MicroMsg.NodeJs", parami);
      AppMethodBeat.o(102197);
      return;
    }
  }
  
  public final int aIA()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.c.f
 * JD-Core Version:    0.7.0.1
 */