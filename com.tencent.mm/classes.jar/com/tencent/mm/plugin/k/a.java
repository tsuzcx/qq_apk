package com.tencent.mm.plugin.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  private static Boolean xfh = Boolean.FALSE;
  
  public static boolean dsY()
  {
    AppMethodBeat.i(260363);
    boolean bool = ((c)h.ax(c.class)).a(c.a.yWh, false);
    if (xfh.booleanValue() != bool)
    {
      xfh = Boolean.valueOf(bool);
      Log.i("MicroMsg.VideoPlayConfig", "enableReadSampleZero :%b", new Object[] { Boolean.valueOf(bool) });
    }
    AppMethodBeat.o(260363);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.k.a
 * JD-Core Version:    0.7.0.1
 */