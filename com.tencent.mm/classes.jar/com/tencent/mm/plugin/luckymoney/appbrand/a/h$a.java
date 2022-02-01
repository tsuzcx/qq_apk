package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum h$a
{
  public final int eJM;
  
  static
  {
    AppMethodBeat.i(64889);
    Kmk = new a("RANDOM_LUCK", 0, 1);
    Kml = new a("FIX_NORMAL", 1, 0);
    Kmm = new a[] { Kmk, Kml };
    AppMethodBeat.o(64889);
  }
  
  private h$a(int paramInt)
  {
    this.eJM = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.a.h.a
 * JD-Core Version:    0.7.0.1
 */