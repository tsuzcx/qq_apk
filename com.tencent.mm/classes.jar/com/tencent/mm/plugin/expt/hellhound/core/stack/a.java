package com.tencent.mm.plugin.expt.hellhound.core.stack;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a
{
  int value;
  
  static
  {
    AppMethodBeat.i(121877);
    qZb = new a("CREATE", 0, 0);
    qZc = new a("RESUME", 1, 1);
    qZd = new a("PAUSE", 2, 2);
    qZe = new a("STOP", 3, 3);
    qZf = new a("DESTROY", 4, 4);
    qZg = new a[] { qZb, qZc, qZd, qZe, qZf };
    AppMethodBeat.o(121877);
  }
  
  private a(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.stack.a
 * JD-Core Version:    0.7.0.1
 */