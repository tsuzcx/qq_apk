package com.tencent.mm.plugin.appbrand.r.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.g;
import com.tencent.mm.ac.i;
import com.tencent.mm.plugin.appbrand.r.a.b;
import com.tencent.mm.plugin.appbrand.r.a.c;
import com.tencent.mm.sdk.platformtools.ad;

public final class e
  extends b
{
  public static e.a kWJ;
  
  public final void a(i parami, c paramc)
  {
    AppMethodBeat.i(147396);
    if (kWJ == null)
    {
      ad.d("MicroMsg.NodeReportKV", "sDelegate null");
      AppMethodBeat.o(147396);
      return;
    }
    try
    {
      int i = parami.getInt("id");
      parami = parami.optString("val");
      kWJ.kvStat(i, parami);
      AppMethodBeat.o(147396);
      return;
    }
    catch (g parami)
    {
      ad.e("MicroMsg.NodeReportKV", "execute exception : %s", new Object[] { parami });
      paramc.biI();
      AppMethodBeat.o(147396);
    }
  }
  
  public final int biH()
  {
    return 8;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.c.e
 * JD-Core Version:    0.7.0.1
 */