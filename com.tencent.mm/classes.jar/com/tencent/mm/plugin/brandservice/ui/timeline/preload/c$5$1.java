package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class c$5$1
  implements Runnable
{
  c$5$1(c.5 param5, List paramList) {}
  
  public final void run()
  {
    AppMethodBeat.i(14366);
    c.f(this.jZS.jZR).clear();
    c.f(this.jZS.jZR).addAll(this.ieO);
    AppMethodBeat.o(14366);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.5.1
 * JD-Core Version:    0.7.0.1
 */