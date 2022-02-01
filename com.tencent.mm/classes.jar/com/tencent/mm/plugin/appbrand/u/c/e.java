package com.tencent.mm.plugin.appbrand.u.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.g;
import com.tencent.mm.ab.i;
import com.tencent.mm.plugin.appbrand.u.a.b;
import com.tencent.mm.plugin.appbrand.u.a.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  extends b
{
  public static a nkj;
  
  public final void a(i parami, c paramc)
  {
    AppMethodBeat.i(147396);
    if (nkj == null)
    {
      Log.d("MicroMsg.NodeReportKV", "sDelegate null");
      AppMethodBeat.o(147396);
      return;
    }
    try
    {
      int i = parami.getInt("id");
      parami = parami.optString("val");
      nkj.kvStat(i, parami);
      AppMethodBeat.o(147396);
      return;
    }
    catch (g parami)
    {
      Log.e("MicroMsg.NodeReportKV", "execute exception : %s", new Object[] { parami });
      paramc.bPU();
      AppMethodBeat.o(147396);
    }
  }
  
  public final int bPT()
  {
    return 8;
  }
  
  public static abstract interface a
  {
    public abstract void kvStat(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.c.e
 * JD-Core Version:    0.7.0.1
 */