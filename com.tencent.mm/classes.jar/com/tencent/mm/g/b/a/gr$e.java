package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum gr$e
{
  final int value;
  
  static
  {
    AppMethodBeat.i(2601);
    eiM = new e("DEFAULT", 0, 0);
    eiN = new e("NOTSUBSCRIBE", 1, 1);
    eiO = new e("SUBSCRIBE", 2, 2);
    eiP = new e[] { eiM, eiN, eiO };
    AppMethodBeat.o(2601);
  }
  
  private gr$e(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gr.e
 * JD-Core Version:    0.7.0.1
 */