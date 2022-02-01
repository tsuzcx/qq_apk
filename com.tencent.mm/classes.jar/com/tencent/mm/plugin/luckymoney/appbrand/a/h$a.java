package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum h$a
{
  public final int cqY;
  
  static
  {
    AppMethodBeat.i(64889);
    sYn = new a("RANDOM_LUCK", 0, 1);
    sYo = new a("FIX_NORMAL", 1, 0);
    sYp = new a[] { sYn, sYo };
    AppMethodBeat.o(64889);
  }
  
  private h$a(int paramInt)
  {
    this.cqY = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.a.h.a
 * JD-Core Version:    0.7.0.1
 */