package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum dd$e
{
  final int value;
  
  static
  {
    AppMethodBeat.i(51110);
    deR = new e("DEFAULT", 0, 0);
    deS = new e("NOTSUBSCRIBE", 1, 1);
    deT = new e("SUBSCRIBE", 2, 2);
    deU = new e[] { deR, deS, deT };
    AppMethodBeat.o(51110);
  }
  
  private dd$e(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dd.e
 * JD-Core Version:    0.7.0.1
 */