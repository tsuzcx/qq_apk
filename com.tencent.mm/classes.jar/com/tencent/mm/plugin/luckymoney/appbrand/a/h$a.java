package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum h$a
{
  public final int cND;
  
  static
  {
    AppMethodBeat.i(64889);
    yPE = new a("RANDOM_LUCK", 0, 1);
    yPF = new a("FIX_NORMAL", 1, 0);
    yPG = new a[] { yPE, yPF };
    AppMethodBeat.o(64889);
  }
  
  private h$a(int paramInt)
  {
    this.cND = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.a.h.a
 * JD-Core Version:    0.7.0.1
 */