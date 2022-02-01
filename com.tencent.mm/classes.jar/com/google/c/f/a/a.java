package com.google.c.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a
{
  private static final a[] bMI;
  public final int bMJ;
  
  static
  {
    AppMethodBeat.i(12304);
    bME = new a("L", 0, 1);
    bMF = new a("M", 1, 0);
    bMG = new a("Q", 2, 3);
    bMH = new a("H", 3, 2);
    bMK = new a[] { bME, bMF, bMG, bMH };
    bMI = new a[] { bMF, bME, bMH, bMG };
    AppMethodBeat.o(12304);
  }
  
  private a(int paramInt)
  {
    this.bMJ = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.c.f.a.a
 * JD-Core Version:    0.7.0.1
 */