package com.tencent.mm.plugin.expt.hellhound.core.stack;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a
{
  int value;
  
  static
  {
    AppMethodBeat.i(121877);
    pEq = new a("CREATE", 0, 0);
    pEr = new a("RESUME", 1, 1);
    pEs = new a("PAUSE", 2, 2);
    pEt = new a("STOP", 3, 3);
    pEu = new a("DESTROY", 4, 4);
    pEv = new a[] { pEq, pEr, pEs, pEt, pEu };
    AppMethodBeat.o(121877);
  }
  
  private a(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.stack.a
 * JD-Core Version:    0.7.0.1
 */