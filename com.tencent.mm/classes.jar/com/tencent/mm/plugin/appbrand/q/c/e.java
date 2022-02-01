package com.tencent.mm.plugin.appbrand.q.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.g;
import com.tencent.mm.ab.i;
import com.tencent.mm.plugin.appbrand.q.a.b;
import com.tencent.mm.plugin.appbrand.q.a.c;
import com.tencent.mm.sdk.platformtools.ae;

public final class e
  extends b
{
  public static a mcy;
  
  public final void a(i parami, c paramc)
  {
    AppMethodBeat.i(147396);
    if (mcy == null)
    {
      ae.d("MicroMsg.NodeReportKV", "sDelegate null");
      AppMethodBeat.o(147396);
      return;
    }
    try
    {
      int i = parami.getInt("id");
      parami = parami.optString("val");
      mcy.kvStat(i, parami);
      AppMethodBeat.o(147396);
      return;
    }
    catch (g parami)
    {
      ae.e("MicroMsg.NodeReportKV", "execute exception : %s", new Object[] { parami });
      paramc.bun();
      AppMethodBeat.o(147396);
    }
  }
  
  public final int bum()
  {
    return 8;
  }
  
  public static abstract interface a
  {
    public abstract void kvStat(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.c.e
 * JD-Core Version:    0.7.0.1
 */