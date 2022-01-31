package com.google.b.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a
{
  private static final a[] bkO;
  public final int bkP;
  
  static
  {
    AppMethodBeat.i(57239);
    bkK = new a("L", 0, 1);
    bkL = new a("M", 1, 0);
    bkM = new a("Q", 2, 3);
    bkN = new a("H", 3, 2);
    bkQ = new a[] { bkK, bkL, bkM, bkN };
    bkO = new a[] { bkL, bkK, bkN, bkM };
    AppMethodBeat.o(57239);
  }
  
  private a(int paramInt)
  {
    this.bkP = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.b.f.a.a
 * JD-Core Version:    0.7.0.1
 */