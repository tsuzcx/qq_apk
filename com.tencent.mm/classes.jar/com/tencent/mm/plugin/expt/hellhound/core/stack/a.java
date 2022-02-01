package com.tencent.mm.plugin.expt.hellhound.core.stack;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a
{
  int value;
  
  static
  {
    AppMethodBeat.i(121877);
    wfo = new a("CREATE", 0, 0);
    wfp = new a("RESUME", 1, 1);
    wfq = new a("PAUSE", 2, 2);
    wfr = new a("STOP", 3, 3);
    wfs = new a("DESTROY", 4, 4);
    wft = new a[] { wfo, wfp, wfq, wfr, wfs };
    AppMethodBeat.o(121877);
  }
  
  private a(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.stack.a
 * JD-Core Version:    0.7.0.1
 */