package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum p$a
{
  public int value = 0;
  
  static
  {
    AppMethodBeat.i(35588);
    fUA = new a("Chat", 0, 1);
    fUB = new a("TalkChat", 1, 2);
    fUC = new a("Sns", 2, 3);
    fUD = new a[] { fUA, fUB, fUC };
    AppMethodBeat.o(35588);
  }
  
  private p$a(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelstat.p.a
 * JD-Core Version:    0.7.0.1
 */