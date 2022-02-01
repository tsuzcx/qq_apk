package com.tencent.mm.plugin.appbrand.q.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.g;
import com.tencent.mm.ab.i;
import com.tencent.mm.plugin.appbrand.q.a.b;
import com.tencent.mm.plugin.appbrand.q.a.c;
import com.tencent.mm.sdk.platformtools.ac;

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
          ac.d("MicroMsg.NodeJs", parami);
          AppMethodBeat.o(147397);
          return;
        }
      }
      catch (g parami)
      {
        ac.e("MicroMsg.NodeToXLog", "execute exception : %s", new Object[] { parami });
        paramc.bpB();
        AppMethodBeat.o(147397);
        return;
      }
      ac.i("MicroMsg.NodeJs", parami);
      AppMethodBeat.o(147397);
      return;
      ac.w("MicroMsg.NodeJs", parami);
      AppMethodBeat.o(147397);
      return;
      ac.e("MicroMsg.NodeJs", parami);
      AppMethodBeat.o(147397);
      return;
    }
  }
  
  public final int bpA()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.c.f
 * JD-Core Version:    0.7.0.1
 */