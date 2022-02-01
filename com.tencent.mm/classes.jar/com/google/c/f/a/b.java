package com.google.c.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b
{
  public final int bMJ;
  private final int[] bMV;
  
  static
  {
    AppMethodBeat.i(12307);
    bML = new b("TERMINATOR", 0, new int[] { 0, 0, 0 }, 0);
    bMM = new b("NUMERIC", 1, new int[] { 10, 12, 14 }, 1);
    bMN = new b("ALPHANUMERIC", 2, new int[] { 9, 11, 13 }, 2);
    bMO = new b("STRUCTURED_APPEND", 3, new int[] { 0, 0, 0 }, 3);
    bMP = new b("BYTE", 4, new int[] { 8, 16, 16 }, 4);
    bMQ = new b("ECI", 5, new int[] { 0, 0, 0 }, 7);
    bMR = new b("KANJI", 6, new int[] { 8, 10, 12 }, 8);
    bMS = new b("FNC1_FIRST_POSITION", 7, new int[] { 0, 0, 0 }, 5);
    bMT = new b("FNC1_SECOND_POSITION", 8, new int[] { 0, 0, 0 }, 9);
    bMU = new b("HANZI", 9, new int[] { 8, 10, 12 }, 13);
    bMW = new b[] { bML, bMM, bMN, bMO, bMP, bMQ, bMR, bMS, bMT, bMU };
    AppMethodBeat.o(12307);
  }
  
  private b(int[] paramArrayOfInt, int paramInt)
  {
    this.bMV = paramArrayOfInt;
    this.bMJ = paramInt;
  }
  
  public final int a(c paramc)
  {
    int i = paramc.bMZ;
    if (i <= 9) {
      i = 0;
    }
    for (;;)
    {
      return this.bMV[i];
      if (i <= 26) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.c.f.a.b
 * JD-Core Version:    0.7.0.1
 */