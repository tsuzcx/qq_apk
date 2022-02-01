package com.google.c.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a
{
  private static final a[] bKq;
  public final int bKr;
  
  static
  {
    AppMethodBeat.i(12304);
    bKm = new a("L", 0, 1);
    bKn = new a("M", 1, 0);
    bKo = new a("Q", 2, 3);
    bKp = new a("H", 3, 2);
    bKs = new a[] { bKm, bKn, bKo, bKp };
    bKq = new a[] { bKn, bKm, bKp, bKo };
    AppMethodBeat.o(12304);
  }
  
  private a(int paramInt)
  {
    this.bKr = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.c.f.a.a
 * JD-Core Version:    0.7.0.1
 */