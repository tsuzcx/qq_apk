package com.google.b.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a
{
  private static final a[] cfc;
  public final int cfd;
  
  static
  {
    AppMethodBeat.i(12304);
    ceY = new a("L", 0, 1);
    ceZ = new a("M", 1, 0);
    cfa = new a("Q", 2, 3);
    cfb = new a("H", 3, 2);
    cfe = new a[] { ceY, ceZ, cfa, cfb };
    cfc = new a[] { ceZ, ceY, cfb, cfa };
    AppMethodBeat.o(12304);
  }
  
  private a(int paramInt)
  {
    this.cfd = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.b.f.a.a
 * JD-Core Version:    0.7.0.1
 */