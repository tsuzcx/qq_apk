package com.tencent.mm.plugin.hp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b$a
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(117383);
    uIb = new a("FAILED", 0, 0);
    uIc = new a("SUCCESS", 1, 1);
    uId = new a[] { uIb, uIc };
    AppMethodBeat.o(117383);
  }
  
  private b$a(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.b.a
 * JD-Core Version:    0.7.0.1
 */