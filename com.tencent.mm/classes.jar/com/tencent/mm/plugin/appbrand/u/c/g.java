package com.tencent.mm.plugin.appbrand.u.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.appbrand.u.a.b;
import com.tencent.mm.plugin.appbrand.u.a.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class g
  extends b
{
  public static g.a qlG;
  
  public final void a(i parami, c paramc)
  {
    AppMethodBeat.i(147395);
    if (qlG == null)
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
      qlG.S(i, j, k);
      AppMethodBeat.o(147395);
      return;
    }
    catch (com.tencent.mm.ad.g parami)
    {
      Log.e("MicroMsg.NodeReportIDKey", "execute exception : %s", new Object[] { parami });
      paramc.Ck(2);
      AppMethodBeat.o(147395);
    }
  }
  
  public final int ccB()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.c.g
 * JD-Core Version:    0.7.0.1
 */