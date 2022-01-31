package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum e$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(15825);
    cPO = new a("ok", 0, 0);
    cPP = new a("cancel", 1, 1);
    cPQ = new a("error", 2, 2);
    cPR = new a[] { cPO, cPP, cPQ };
    AppMethodBeat.o(15825);
  }
  
  private e$a(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.e.a
 * JD-Core Version:    0.7.0.1
 */