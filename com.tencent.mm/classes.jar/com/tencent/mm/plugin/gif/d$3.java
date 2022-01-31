package com.tencent.mm.plugin.gif;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$3
  implements Runnable
{
  d$3(d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(62382);
    MMGIFJNI.restoreRemainder(d.e(this.nFG));
    d.a(this.nFG, d.f(this.nFG), d.g(this.nFG));
    AppMethodBeat.o(62382);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.d.3
 * JD-Core Version:    0.7.0.1
 */