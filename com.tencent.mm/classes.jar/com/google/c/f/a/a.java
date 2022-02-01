package com.google.c.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a
{
  private static final a[] cgI;
  public final int cgJ;
  
  static
  {
    AppMethodBeat.i(12304);
    cgE = new a("L", 0, 1);
    cgF = new a("M", 1, 0);
    cgG = new a("Q", 2, 3);
    cgH = new a("H", 3, 2);
    cgK = new a[] { cgE, cgF, cgG, cgH };
    cgI = new a[] { cgF, cgE, cgH, cgG };
    AppMethodBeat.o(12304);
  }
  
  private a(int paramInt)
  {
    this.cgJ = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.c.f.a.a
 * JD-Core Version:    0.7.0.1
 */