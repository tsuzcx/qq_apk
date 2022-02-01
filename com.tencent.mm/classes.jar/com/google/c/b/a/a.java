package com.google.c.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static final a bSH;
  public static final a bSI;
  public static final a bSJ;
  public static final a bSK;
  public static final a bSL;
  public static final a bSM;
  public static final a bSN;
  public static final a bSO;
  final int[] bSP;
  final int[] bSQ;
  final b bSR;
  private final b bSS;
  private final int bST;
  final int bSU;
  final int size;
  
  static
  {
    AppMethodBeat.i(12338);
    bSH = new a(4201, 4096, 1);
    bSI = new a(1033, 1024, 1);
    bSJ = new a(67, 64, 1);
    bSK = new a(19, 16, 1);
    bSL = new a(285, 256, 0);
    a locala = new a(301, 256, 1);
    bSM = locala;
    bSN = locala;
    bSO = bSJ;
    AppMethodBeat.o(12338);
  }
  
  private a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(12336);
    this.bST = paramInt1;
    this.size = paramInt2;
    this.bSU = paramInt3;
    this.bSP = new int[paramInt2];
    this.bSQ = new int[paramInt2];
    int i = 0;
    paramInt3 = 1;
    while (i < paramInt2)
    {
      this.bSP[i] = paramInt3;
      int j = paramInt3 << 1;
      paramInt3 = j;
      if (j >= paramInt2) {
        paramInt3 = (j ^ paramInt1) & paramInt2 - 1;
      }
      i += 1;
    }
    paramInt1 = 0;
    while (paramInt1 < paramInt2 - 1)
    {
      this.bSQ[this.bSP[paramInt1]] = paramInt1;
      paramInt1 += 1;
    }
    this.bSR = new b(this, new int[] { 0 });
    this.bSS = new b(this, new int[] { 1 });
    AppMethodBeat.o(12336);
  }
  
  static int bJ(int paramInt1, int paramInt2)
  {
    return paramInt1 ^ paramInt2;
  }
  
  final int bK(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      return 0;
    }
    return this.bSP[((this.bSQ[paramInt1] + this.bSQ[paramInt2]) % (this.size - 1))];
  }
  
  public final String toString()
  {
    AppMethodBeat.i(12337);
    String str = "GF(0x" + Integer.toHexString(this.bST) + ',' + this.size + ')';
    AppMethodBeat.o(12337);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.c.b.a.a
 * JD-Core Version:    0.7.0.1
 */