package com.tencent.mm.plugin.expt.hellhound.core.stack;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a
{
  int value;
  
  static
  {
    AppMethodBeat.i(73357);
    lZI = new a("CREATE", 0, 0);
    lZJ = new a("RESUME", 1, 1);
    lZK = new a("PAUSE", 2, 2);
    lZL = new a("STOP", 3, 3);
    lZM = new a("DESTROY", 4, 4);
    lZN = new a[] { lZI, lZJ, lZK, lZL, lZM };
    AppMethodBeat.o(73357);
  }
  
  private a(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.stack.a
 * JD-Core Version:    0.7.0.1
 */