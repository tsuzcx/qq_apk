package com.tencent.mm.plugin.appbrand.n.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.g;
import com.tencent.mm.aa.i;
import com.tencent.mm.plugin.appbrand.n.a.b;
import com.tencent.mm.plugin.appbrand.n.a.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class e
  extends b
{
  public static e.a iuo;
  
  public final void a(i parami, c paramc)
  {
    AppMethodBeat.i(102196);
    if (iuo == null)
    {
      ab.d("MicroMsg.NodeReportKV", "sDelegate null");
      AppMethodBeat.o(102196);
      return;
    }
    try
    {
      int i = parami.getInt("id");
      parami = parami.optString("val");
      iuo.kvStat(i, parami);
      AppMethodBeat.o(102196);
      return;
    }
    catch (g parami)
    {
      ab.e("MicroMsg.NodeReportKV", "execute exception : %s", new Object[] { parami });
      paramc.aIB();
      AppMethodBeat.o(102196);
    }
  }
  
  public final int aIA()
  {
    return 8;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.c.e
 * JD-Core Version:    0.7.0.1
 */