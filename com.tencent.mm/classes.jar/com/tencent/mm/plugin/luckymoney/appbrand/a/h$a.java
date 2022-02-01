package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum h$a
{
  public final int cof;
  
  static
  {
    AppMethodBeat.i(64889);
    ugB = new a("RANDOM_LUCK", 0, 1);
    ugC = new a("FIX_NORMAL", 1, 0);
    ugD = new a[] { ugB, ugC };
    AppMethodBeat.o(64889);
  }
  
  private h$a(int paramInt)
  {
    this.cof = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.a.h.a
 * JD-Core Version:    0.7.0.1
 */