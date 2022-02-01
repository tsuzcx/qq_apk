package com.tencent.mm.plugin.appbrand.q.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.g;
import com.tencent.mm.ac.i;
import com.tencent.mm.plugin.appbrand.q.a.b;
import com.tencent.mm.plugin.appbrand.q.a.c;
import com.tencent.mm.sdk.platformtools.ad;

public final class e
  extends b
{
  public static e.a lXR;
  
  public final void a(i parami, c paramc)
  {
    AppMethodBeat.i(147396);
    if (lXR == null)
    {
      ad.d("MicroMsg.NodeReportKV", "sDelegate null");
      AppMethodBeat.o(147396);
      return;
    }
    try
    {
      int i = parami.getInt("id");
      parami = parami.optString("val");
      lXR.kvStat(i, parami);
      AppMethodBeat.o(147396);
      return;
    }
    catch (g parami)
    {
      ad.e("MicroMsg.NodeReportKV", "execute exception : %s", new Object[] { parami });
      paramc.btC();
      AppMethodBeat.o(147396);
    }
  }
  
  public final int btB()
  {
    return 8;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.c.e
 * JD-Core Version:    0.7.0.1
 */