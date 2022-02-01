package com.google.c.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b
{
  public final int bUE;
  private final int[] bUQ;
  
  static
  {
    AppMethodBeat.i(12307);
    bUG = new b("TERMINATOR", 0, new int[] { 0, 0, 0 }, 0);
    bUH = new b("NUMERIC", 1, new int[] { 10, 12, 14 }, 1);
    bUI = new b("ALPHANUMERIC", 2, new int[] { 9, 11, 13 }, 2);
    bUJ = new b("STRUCTURED_APPEND", 3, new int[] { 0, 0, 0 }, 3);
    bUK = new b("BYTE", 4, new int[] { 8, 16, 16 }, 4);
    bUL = new b("ECI", 5, new int[] { 0, 0, 0 }, 7);
    bUM = new b("KANJI", 6, new int[] { 8, 10, 12 }, 8);
    bUN = new b("FNC1_FIRST_POSITION", 7, new int[] { 0, 0, 0 }, 5);
    bUO = new b("FNC1_SECOND_POSITION", 8, new int[] { 0, 0, 0 }, 9);
    bUP = new b("HANZI", 9, new int[] { 8, 10, 12 }, 13);
    bUR = new b[] { bUG, bUH, bUI, bUJ, bUK, bUL, bUM, bUN, bUO, bUP };
    AppMethodBeat.o(12307);
  }
  
  private b(int[] paramArrayOfInt, int paramInt)
  {
    this.bUQ = paramArrayOfInt;
    this.bUE = paramInt;
  }
  
  public final int a(c paramc)
  {
    int i = paramc.bUU;
    if (i <= 9) {
      i = 0;
    }
    for (;;)
    {
      return this.bUQ[i];
      if (i <= 26) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.c.f.a.b
 * JD-Core Version:    0.7.0.1
 */