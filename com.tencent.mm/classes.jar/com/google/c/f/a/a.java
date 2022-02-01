package com.google.c.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a
{
  private static final a[] bUD;
  public final int bUE;
  
  static
  {
    AppMethodBeat.i(12304);
    bUz = new a("L", 0, 1);
    bUA = new a("M", 1, 0);
    bUB = new a("Q", 2, 3);
    bUC = new a("H", 3, 2);
    bUF = new a[] { bUz, bUA, bUB, bUC };
    bUD = new a[] { bUA, bUz, bUC, bUB };
    AppMethodBeat.o(12304);
  }
  
  private a(int paramInt)
  {
    this.bUE = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.c.f.a.a
 * JD-Core Version:    0.7.0.1
 */