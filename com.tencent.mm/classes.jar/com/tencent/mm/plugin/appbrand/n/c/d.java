package com.tencent.mm.plugin.appbrand.n.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.g;
import com.tencent.mm.aa.i;
import com.tencent.mm.plugin.appbrand.n.a.b;
import com.tencent.mm.plugin.appbrand.n.a.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class d
  extends b
{
  public static d.a iun;
  
  public final void a(i parami, c paramc)
  {
    AppMethodBeat.i(102195);
    if (iun == null)
    {
      ab.d("MicroMsg.NodeReportIDKey", "sDelegate null");
      AppMethodBeat.o(102195);
      return;
    }
    try
    {
      int i = parami.getInt("id");
      int j = parami.getInt("key");
      int k = parami.optInt("val", 1);
      iun.L(i, j, k);
      AppMethodBeat.o(102195);
      return;
    }
    catch (g parami)
    {
      ab.e("MicroMsg.NodeReportIDKey", "execute exception : %s", new Object[] { parami });
      paramc.aIB();
      AppMethodBeat.o(102195);
    }
  }
  
  public final int aIA()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.c.d
 * JD-Core Version:    0.7.0.1
 */