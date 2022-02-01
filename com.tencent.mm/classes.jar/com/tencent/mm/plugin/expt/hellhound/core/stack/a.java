package com.tencent.mm.plugin.expt.hellhound.core.stack;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a
{
  int value;
  
  static
  {
    AppMethodBeat.i(121877);
    zBo = new a("CREATE", 0, 0);
    zBp = new a("RESUME", 1, 1);
    zBq = new a("PAUSE", 2, 2);
    zBr = new a("STOP", 3, 3);
    zBs = new a("DESTROY", 4, 4);
    zBt = new a[] { zBo, zBp, zBq, zBr, zBs };
    AppMethodBeat.o(121877);
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