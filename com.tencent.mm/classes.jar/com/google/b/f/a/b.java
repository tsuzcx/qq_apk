package com.google.b.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b
{
  public final int cfd;
  private final int[] cfq;
  
  static
  {
    AppMethodBeat.i(12307);
    cff = new b("TERMINATOR", 0, new int[] { 0, 0, 0 }, 0);
    cfh = new b("NUMERIC", 1, new int[] { 10, 12, 14 }, 1);
    cfi = new b("ALPHANUMERIC", 2, new int[] { 9, 11, 13 }, 2);
    cfj = new b("STRUCTURED_APPEND", 3, new int[] { 0, 0, 0 }, 3);
    cfk = new b("BYTE", 4, new int[] { 8, 16, 16 }, 4);
    cfl = new b("ECI", 5, new int[] { 0, 0, 0 }, 7);
    cfm = new b("KANJI", 6, new int[] { 8, 10, 12 }, 8);
    cfn = new b("FNC1_FIRST_POSITION", 7, new int[] { 0, 0, 0 }, 5);
    cfo = new b("FNC1_SECOND_POSITION", 8, new int[] { 0, 0, 0 }, 9);
    cfp = new b("HANZI", 9, new int[] { 8, 10, 12 }, 13);
    cfr = new b[] { cff, cfh, cfi, cfj, cfk, cfl, cfm, cfn, cfo, cfp };
    AppMethodBeat.o(12307);
  }
  
  private b(int[] paramArrayOfInt, int paramInt)
  {
    this.cfq = paramArrayOfInt;
    this.cfd = paramInt;
  }
  
  public final int a(c paramc)
  {
    int i = paramc.cfu;
    if (i <= 9) {
      i = 0;
    }
    for (;;)
    {
      return this.cfq[i];
      if (i <= 26) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.b.f.a.b
 * JD-Core Version:    0.7.0.1
 */