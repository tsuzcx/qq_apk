package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.i;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.n.e;
import com.tencent.mm.n.g;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ax.a;

public final class m
{
  public static void run()
  {
    AppMethodBeat.i(19897);
    int i = g.acL().getInt("EnableFlockMultiProcSPProb", 0);
    bc.aCg();
    int j = i.cf(c.getUin(), 101);
    if ((b.fnF()) || ((i > 0) && (j >= 0) && (j <= i))) {}
    for (boolean bool = true;; bool = false)
    {
      ax.a.setValue(ax.a.IyF, bool);
      ae.i("MicroMsg.PostTaskUpdateMultiProcSPSwitchListener", "Update MMImgDecSwitch, userHash:%d, prob:%d, enabled: %b", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Boolean.valueOf(bool) });
      AppMethodBeat.o(19897);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.booter.m
 * JD-Core Version:    0.7.0.1
 */