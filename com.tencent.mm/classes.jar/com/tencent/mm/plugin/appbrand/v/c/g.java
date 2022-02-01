package com.tencent.mm.plugin.appbrand.v.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.appbrand.v.a.b;
import com.tencent.mm.plugin.appbrand.v.a.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class g
  extends b
{
  public static g.a tqE;
  
  public final void a(i parami, c paramc)
  {
    AppMethodBeat.i(147395);
    if (tqE == null)
    {
      Log.d("MicroMsg.NodeReportIDKey", "sDelegate null");
      AppMethodBeat.o(147395);
      return;
    }
    try
    {
      int i = parami.getInt("id");
      int j = parami.getInt("key");
      int k = parami.optInt("val", 1);
      tqE.aj(i, j, k);
      AppMethodBeat.o(147395);
      return;
    }
    catch (com.tencent.mm.ad.g parami)
    {
      Log.e("MicroMsg.NodeReportIDKey", "execute exception : %s", new Object[] { parami });
      paramc.Cz(2);
      AppMethodBeat.o(147395);
    }
  }
  
  public final int cCX()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.c.g
 * JD-Core Version:    0.7.0.1
 */