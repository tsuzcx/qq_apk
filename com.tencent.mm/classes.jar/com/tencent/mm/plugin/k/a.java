package com.tencent.mm.plugin.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  private static Boolean ubv = Boolean.FALSE;
  
  public static boolean cPp()
  {
    AppMethodBeat.i(204957);
    boolean bool = ((b)h.ae(b.class)).a(b.a.vGz, false);
    if (ubv.booleanValue() != bool)
    {
      ubv = Boolean.valueOf(bool);
      Log.i("MicroMsg.VideoPlayConfig", "enableReadSampleZero :%b", new Object[] { Boolean.valueOf(bool) });
    }
    AppMethodBeat.o(204957);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.k.a
 * JD-Core Version:    0.7.0.1
 */