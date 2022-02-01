package com.google.c.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b
{
  private final int[] bKD;
  public final int bKr;
  
  static
  {
    AppMethodBeat.i(12307);
    bKt = new b("TERMINATOR", 0, new int[] { 0, 0, 0 }, 0);
    bKu = new b("NUMERIC", 1, new int[] { 10, 12, 14 }, 1);
    bKv = new b("ALPHANUMERIC", 2, new int[] { 9, 11, 13 }, 2);
    bKw = new b("STRUCTURED_APPEND", 3, new int[] { 0, 0, 0 }, 3);
    bKx = new b("BYTE", 4, new int[] { 8, 16, 16 }, 4);
    bKy = new b("ECI", 5, new int[] { 0, 0, 0 }, 7);
    bKz = new b("KANJI", 6, new int[] { 8, 10, 12 }, 8);
    bKA = new b("FNC1_FIRST_POSITION", 7, new int[] { 0, 0, 0 }, 5);
    bKB = new b("FNC1_SECOND_POSITION", 8, new int[] { 0, 0, 0 }, 9);
    bKC = new b("HANZI", 9, new int[] { 8, 10, 12 }, 13);
    bKE = new b[] { bKt, bKu, bKv, bKw, bKx, bKy, bKz, bKA, bKB, bKC };
    AppMethodBeat.o(12307);
  }
  
  private b(int[] paramArrayOfInt, int paramInt)
  {
    this.bKD = paramArrayOfInt;
    this.bKr = paramInt;
  }
  
  public final int a(c paramc)
  {
    int i = paramc.bKH;
    if (i <= 9) {
      i = 0;
    }
    for (;;)
    {
      return this.bKD[i];
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