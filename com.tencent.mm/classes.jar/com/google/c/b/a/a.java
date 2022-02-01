package com.google.c.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static final a bKL;
  public static final a bKM;
  public static final a bKN;
  public static final a bKO;
  public static final a bKP;
  public static final a bKQ;
  public static final a bKR;
  public static final a bKS;
  final int[] bKT;
  final int[] bKU;
  final b bKV;
  private final b bKW;
  private final int bKX;
  final int bKY;
  final int size;
  
  static
  {
    AppMethodBeat.i(12338);
    bKL = new a(4201, 4096, 1);
    bKM = new a(1033, 1024, 1);
    bKN = new a(67, 64, 1);
    bKO = new a(19, 16, 1);
    bKP = new a(285, 256, 0);
    a locala = new a(301, 256, 1);
    bKQ = locala;
    bKR = locala;
    bKS = bKN;
    AppMethodBeat.o(12338);
  }
  
  private a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(12336);
    this.bKX = paramInt1;
    this.size = paramInt2;
    this.bKY = paramInt3;
    this.bKT = new int[paramInt2];
    this.bKU = new int[paramInt2];
    int i = 0;
    paramInt3 = 1;
    while (i < paramInt2)
    {
      this.bKT[i] = paramInt3;
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
      this.bKU[this.bKT[paramInt1]] = paramInt1;
      paramInt1 += 1;
    }
    this.bKV = new b(this, new int[] { 0 });
    this.bKW = new b(this, new int[] { 1 });
    AppMethodBeat.o(12336);
  }
  
  static int bK(int paramInt1, int paramInt2)
  {
    return paramInt1 ^ paramInt2;
  }
  
  final int bL(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      return 0;
    }
    return this.bKT[((this.bKU[paramInt1] + this.bKU[paramInt2]) % (this.size - 1))];
  }
  
  public final String toString()
  {
    AppMethodBeat.i(12337);
    String str = "GF(0x" + Integer.toHexString(this.bKX) + ',' + this.size + ')';
    AppMethodBeat.o(12337);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.c.b.a.a
 * JD-Core Version:    0.7.0.1
 */