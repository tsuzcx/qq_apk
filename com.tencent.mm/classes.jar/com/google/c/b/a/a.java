package com.google.c.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static final a bIA;
  public static final a bIt;
  public static final a bIu;
  public static final a bIv;
  public static final a bIw;
  public static final a bIx;
  public static final a bIy;
  public static final a bIz;
  final int[] bIB;
  final int[] bIC;
  final b bID;
  private final b bIE;
  private final int bIF;
  final int bIG;
  final int size;
  
  static
  {
    AppMethodBeat.i(12338);
    bIt = new a(4201, 4096, 1);
    bIu = new a(1033, 1024, 1);
    bIv = new a(67, 64, 1);
    bIw = new a(19, 16, 1);
    bIx = new a(285, 256, 0);
    a locala = new a(301, 256, 1);
    bIy = locala;
    bIz = locala;
    bIA = bIv;
    AppMethodBeat.o(12338);
  }
  
  private a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(12336);
    this.bIF = paramInt1;
    this.size = paramInt2;
    this.bIG = paramInt3;
    this.bIB = new int[paramInt2];
    this.bIC = new int[paramInt2];
    int i = 0;
    paramInt3 = 1;
    while (i < paramInt2)
    {
      this.bIB[i] = paramInt3;
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
      this.bIC[this.bIB[paramInt1]] = paramInt1;
      paramInt1 += 1;
    }
    this.bID = new b(this, new int[] { 0 });
    this.bIE = new b(this, new int[] { 1 });
    AppMethodBeat.o(12336);
  }
  
  static int bH(int paramInt1, int paramInt2)
  {
    return paramInt1 ^ paramInt2;
  }
  
  final int bI(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      return 0;
    }
    return this.bIB[((this.bIC[paramInt1] + this.bIC[paramInt2]) % (this.size - 1))];
  }
  
  public final String toString()
  {
    AppMethodBeat.i(12337);
    String str = "GF(0x" + Integer.toHexString(this.bIF) + ',' + this.size + ')';
    AppMethodBeat.o(12337);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.c.b.a.a
 * JD-Core Version:    0.7.0.1
 */