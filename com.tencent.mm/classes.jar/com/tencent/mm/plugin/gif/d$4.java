package com.tencent.mm.plugin.gif;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$4
  implements Runnable
{
  d$4(d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(62383);
    MMGIFJNI.reset(d.e(this.nFG));
    d.a(this.nFG, -1);
    d.a(this.nFG, d.f(this.nFG), 0L);
    AppMethodBeat.o(62383);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.d.4
 * JD-Core Version:    0.7.0.1
 */