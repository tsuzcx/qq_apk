package com.tencent.mm.plugin.expt.hellhound.core.stack;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a
{
  int value;
  
  static
  {
    AppMethodBeat.i(121877);
    qRd = new a("CREATE", 0, 0);
    qRe = new a("RESUME", 1, 1);
    qRf = new a("PAUSE", 2, 2);
    qRg = new a("STOP", 3, 3);
    qRh = new a("DESTROY", 4, 4);
    qRi = new a[] { qRd, qRe, qRf, qRg, qRh };
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