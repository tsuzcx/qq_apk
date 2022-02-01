package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum hx$b
{
  final int value;
  
  static
  {
    AppMethodBeat.i(180155);
    evj = new b("release", 0, 1);
    evk = new b("debug", 1, 2);
    evl = new b("demo", 2, 3);
    evm = new b[] { evj, evk, evl };
    AppMethodBeat.o(180155);
  }
  
  private hx$b(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hx.b
 * JD-Core Version:    0.7.0.1
 */