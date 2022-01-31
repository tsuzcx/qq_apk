package com.google.b.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static final a biR;
  public static final a biS;
  public static final a biT;
  public static final a biU;
  public static final a biV;
  public static final a biW;
  public static final a biX;
  public static final a biY;
  final int[] biZ;
  final int[] bja;
  final b bjb;
  private final b bjc;
  private final int bjd;
  final int bje;
  final int size;
  
  static
  {
    AppMethodBeat.i(57273);
    biR = new a(4201, 4096, 1);
    biS = new a(1033, 1024, 1);
    biT = new a(67, 64, 1);
    biU = new a(19, 16, 1);
    biV = new a(285, 256, 0);
    a locala = new a(301, 256, 1);
    biW = locala;
    biX = locala;
    biY = biT;
    AppMethodBeat.o(57273);
  }
  
  private a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(57271);
    this.bjd = paramInt1;
    this.size = paramInt2;
    this.bje = paramInt3;
    this.biZ = new int[paramInt2];
    this.bja = new int[paramInt2];
    int i = 0;
    paramInt3 = 1;
    while (i < paramInt2)
    {
      this.biZ[i] = paramInt3;
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
      this.bja[this.biZ[paramInt1]] = paramInt1;
      paramInt1 += 1;
    }
    this.bjb = new b(this, new int[] { 0 });
    this.bjc = new b(this, new int[] { 1 });
    AppMethodBeat.o(57271);
  }
  
  static int bv(int paramInt1, int paramInt2)
  {
    return paramInt1 ^ paramInt2;
  }
  
  final int bw(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      return 0;
    }
    return this.biZ[((this.bja[paramInt1] + this.bja[paramInt2]) % (this.size - 1))];
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57272);
    String str = "GF(0x" + Integer.toHexString(this.bjd) + ',' + this.size + ')';
    AppMethodBeat.o(57272);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.b.b.a.a
 * JD-Core Version:    0.7.0.1
 */