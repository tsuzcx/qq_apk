package com.tencent.mm.plugin.appbrand.u.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.g;
import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.appbrand.u.a.b;
import com.tencent.mm.plugin.appbrand.u.a.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class h
  extends b
{
  public static h.a qlH;
  
  public final void a(i parami, c paramc)
  {
    AppMethodBeat.i(147396);
    if (qlH == null)
    {
      Log.d("MicroMsg.NodeReportKV", "sDelegate null");
      AppMethodBeat.o(147396);
      return;
    }
    try
    {
      int i = parami.getInt("id");
      parami = parami.optString("val");
      qlH.kvStat(i, parami);
      AppMethodBeat.o(147396);
      return;
    }
    catch (g parami)
    {
      Log.e("MicroMsg.NodeReportKV", "execute exception : %s", new Object[] { parami });
      paramc.Ck(2);
      AppMethodBeat.o(147396);
    }
  }
  
  public final int ccB()
  {
    return 8;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.c.h
 * JD-Core Version:    0.7.0.1
 */