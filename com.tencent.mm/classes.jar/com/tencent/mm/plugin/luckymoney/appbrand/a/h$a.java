package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum h$a
{
  public final int bKp;
  
  static
  {
    AppMethodBeat.i(42001);
    oiA = new a("RANDOM_LUCK", 0, 1);
    oiB = new a("FIX_NORMAL", 1, 0);
    oiC = new a[] { oiA, oiB };
    AppMethodBeat.o(42001);
  }
  
  private h$a(int paramInt)
  {
    this.bKp = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.a.h.a
 * JD-Core Version:    0.7.0.1
 */