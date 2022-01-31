package com.google.b.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b
{
  public final int bkP;
  private final int[] blb;
  
  static
  {
    AppMethodBeat.i(57242);
    bkR = new b("TERMINATOR", 0, new int[] { 0, 0, 0 }, 0);
    bkS = new b("NUMERIC", 1, new int[] { 10, 12, 14 }, 1);
    bkT = new b("ALPHANUMERIC", 2, new int[] { 9, 11, 13 }, 2);
    bkU = new b("STRUCTURED_APPEND", 3, new int[] { 0, 0, 0 }, 3);
    bkV = new b("BYTE", 4, new int[] { 8, 16, 16 }, 4);
    bkW = new b("ECI", 5, new int[] { 0, 0, 0 }, 7);
    bkX = new b("KANJI", 6, new int[] { 8, 10, 12 }, 8);
    bkY = new b("FNC1_FIRST_POSITION", 7, new int[] { 0, 0, 0 }, 5);
    bkZ = new b("FNC1_SECOND_POSITION", 8, new int[] { 0, 0, 0 }, 9);
    bla = new b("HANZI", 9, new int[] { 8, 10, 12 }, 13);
    blc = new b[] { bkR, bkS, bkT, bkU, bkV, bkW, bkX, bkY, bkZ, bla };
    AppMethodBeat.o(57242);
  }
  
  private b(int[] paramArrayOfInt, int paramInt)
  {
    this.blb = paramArrayOfInt;
    this.bkP = paramInt;
  }
  
  public final int a(c paramc)
  {
    int i = paramc.blf;
    if (i <= 9) {
      i = 0;
    }
    for (;;)
    {
      return this.blb[i];
      if (i <= 26) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.b.f.a.b
 * JD-Core Version:    0.7.0.1
 */