package com.tencent.mm.plugin.appbrand.q.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.g;
import com.tencent.mm.ab.i;
import com.tencent.mm.plugin.appbrand.q.a.b;
import com.tencent.mm.plugin.appbrand.q.a.c;
import com.tencent.mm.sdk.platformtools.ac;

public final class d
  extends b
{
  public static a lys;
  
  public final void a(i parami, c paramc)
  {
    AppMethodBeat.i(147395);
    if (lys == null)
    {
      ac.d("MicroMsg.NodeReportIDKey", "sDelegate null");
      AppMethodBeat.o(147395);
      return;
    }
    try
    {
      int i = parami.getInt("id");
      int j = parami.getInt("key");
      int k = parami.optInt("val", 1);
      lys.N(i, j, k);
      AppMethodBeat.o(147395);
      return;
    }
    catch (g parami)
    {
      ac.e("MicroMsg.NodeReportIDKey", "execute exception : %s", new Object[] { parami });
      paramc.bpB();
      AppMethodBeat.o(147395);
    }
  }
  
  public final int bpA()
  {
    return 3;
  }
  
  public static abstract interface a
  {
    public abstract void N(int paramInt1, int paramInt2, int paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.c.d
 * JD-Core Version:    0.7.0.1
 */