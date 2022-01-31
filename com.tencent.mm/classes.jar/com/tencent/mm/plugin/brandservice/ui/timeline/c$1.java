package com.tencent.mm.plugin.brandservice.ui.timeline;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.s;

final class c$1
  implements Runnable
{
  c$1(c paramc, Runnable paramRunnable) {}
  
  public final void run()
  {
    AppMethodBeat.i(14142);
    Runnable localRunnable = this.eEA;
    if (c.aWM())
    {
      if (localRunnable != null) {
        al.d(localRunnable);
      }
      AppMethodBeat.o(14142);
      return;
    }
    s.pR(false);
    if (localRunnable != null) {
      al.d(localRunnable);
    }
    AppMethodBeat.o(14142);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.c.1
 * JD-Core Version:    0.7.0.1
 */