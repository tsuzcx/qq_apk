package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.i;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ar.a;

public final class m
{
  public static void run()
  {
    AppMethodBeat.i(15861);
    int i = g.Nq().getInt("EnableFlockMultiProcSPProb", 0);
    aw.aaz();
    int j = i.bQ(c.getUin(), 101);
    if ((b.dsf()) || ((i > 0) && (j >= 0) && (j <= i))) {}
    for (boolean bool = true;; bool = false)
    {
      ar.a.setValue(ar.a.yoH, bool);
      ab.i("MicroMsg.PostTaskUpdateMultiProcSPSwitchListener", "Update MMImgDecSwitch, userHash:%d, prob:%d, enabled: %b", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Boolean.valueOf(bool) });
      AppMethodBeat.o(15861);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.booter.m
 * JD-Core Version:    0.7.0.1
 */