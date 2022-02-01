package com.tencent.mm.plugin.expt.hellhound.core.stack;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a
{
  int value;
  
  static
  {
    AppMethodBeat.i(121877);
    szs = new a("CREATE", 0, 0);
    szt = new a("RESUME", 1, 1);
    szu = new a("PAUSE", 2, 2);
    szv = new a("STOP", 3, 3);
    szw = new a("DESTROY", 4, 4);
    szx = new a[] { szs, szt, szu, szv, szw };
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