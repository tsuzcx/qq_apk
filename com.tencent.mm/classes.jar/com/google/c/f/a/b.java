package com.google.c.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b
{
  public final int cgJ;
  private final int[] cgV;
  
  static
  {
    AppMethodBeat.i(12307);
    cgL = new b("TERMINATOR", 0, new int[] { 0, 0, 0 }, 0);
    cgM = new b("NUMERIC", 1, new int[] { 10, 12, 14 }, 1);
    cgN = new b("ALPHANUMERIC", 2, new int[] { 9, 11, 13 }, 2);
    cgO = new b("STRUCTURED_APPEND", 3, new int[] { 0, 0, 0 }, 3);
    cgP = new b("BYTE", 4, new int[] { 8, 16, 16 }, 4);
    cgQ = new b("ECI", 5, new int[] { 0, 0, 0 }, 7);
    cgR = new b("KANJI", 6, new int[] { 8, 10, 12 }, 8);
    cgS = new b("FNC1_FIRST_POSITION", 7, new int[] { 0, 0, 0 }, 5);
    cgT = new b("FNC1_SECOND_POSITION", 8, new int[] { 0, 0, 0 }, 9);
    cgU = new b("HANZI", 9, new int[] { 8, 10, 12 }, 13);
    cgW = new b[] { cgL, cgM, cgN, cgO, cgP, cgQ, cgR, cgS, cgT, cgU };
    AppMethodBeat.o(12307);
  }
  
  private b(int[] paramArrayOfInt, int paramInt)
  {
    this.cgV = paramArrayOfInt;
    this.cgJ = paramInt;
  }
  
  public final int a(c paramc)
  {
    int i = paramc.cgZ;
    if (i <= 9) {
      i = 0;
    }
    for (;;)
    {
      return this.cgV[i];
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