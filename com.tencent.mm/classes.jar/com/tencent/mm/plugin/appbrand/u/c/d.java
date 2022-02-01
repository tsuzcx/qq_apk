package com.tencent.mm.plugin.appbrand.u.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.g;
import com.tencent.mm.ab.i;
import com.tencent.mm.plugin.appbrand.u.a.b;
import com.tencent.mm.plugin.appbrand.u.a.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends b
{
  public static d.a nki;
  
  public final void a(i parami, c paramc)
  {
    AppMethodBeat.i(147395);
    if (nki == null)
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
      nki.Q(i, j, k);
      AppMethodBeat.o(147395);
      return;
    }
    catch (g parami)
    {
      Log.e("MicroMsg.NodeReportIDKey", "execute exception : %s", new Object[] { parami });
      paramc.bPU();
      AppMethodBeat.o(147395);
    }
  }
  
  public final int bPT()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.c.d
 * JD-Core Version:    0.7.0.1
 */