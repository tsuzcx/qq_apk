package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum hv$b
{
  final int value;
  
  static
  {
    AppMethodBeat.i(180155);
    etC = new b("release", 0, 1);
    etD = new b("debug", 1, 2);
    etE = new b("demo", 2, 3);
    etF = new b[] { etC, etD, etE };
    AppMethodBeat.o(180155);
  }
  
  private hv$b(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hv.b
 * JD-Core Version:    0.7.0.1
 */