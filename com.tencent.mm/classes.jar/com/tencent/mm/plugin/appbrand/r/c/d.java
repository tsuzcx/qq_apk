package com.tencent.mm.plugin.appbrand.r.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.g;
import com.tencent.mm.ac.i;
import com.tencent.mm.plugin.appbrand.r.a.b;
import com.tencent.mm.plugin.appbrand.r.a.c;
import com.tencent.mm.sdk.platformtools.ad;

public final class d
  extends b
{
  public static d.a kWI;
  
  public final void a(i parami, c paramc)
  {
    AppMethodBeat.i(147395);
    if (kWI == null)
    {
      ad.d("MicroMsg.NodeReportIDKey", "sDelegate null");
      AppMethodBeat.o(147395);
      return;
    }
    try
    {
      int i = parami.getInt("id");
      int j = parami.getInt("key");
      int k = parami.optInt("val", 1);
      kWI.M(i, j, k);
      AppMethodBeat.o(147395);
      return;
    }
    catch (g parami)
    {
      ad.e("MicroMsg.NodeReportIDKey", "execute exception : %s", new Object[] { parami });
      paramc.biI();
      AppMethodBeat.o(147395);
    }
  }
  
  public final int biH()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.c.d
 * JD-Core Version:    0.7.0.1
 */