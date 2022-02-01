package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum fa$b
{
  final int value;
  
  static
  {
    AppMethodBeat.i(180155);
    eaR = new b("release", 0, 1);
    eaS = new b("debug", 1, 2);
    eaT = new b("demo", 2, 3);
    eaU = new b[] { eaR, eaS, eaT };
    AppMethodBeat.o(180155);
  }
  
  private fa$b(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fa.b
 * JD-Core Version:    0.7.0.1
 */