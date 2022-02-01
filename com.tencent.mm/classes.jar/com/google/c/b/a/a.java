package com.google.c.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static final a ceJ;
  public static final a ceK;
  public static final a ceL;
  public static final a ceM;
  public static final a ceN;
  public static final a ceO;
  public static final a ceP;
  public static final a ceQ;
  final int[] ceR;
  final int[] ceS;
  final b ceT;
  private final b ceU;
  private final int ceV;
  final int ceW;
  final int size;
  
  static
  {
    AppMethodBeat.i(12338);
    ceJ = new a(4201, 4096, 1);
    ceK = new a(1033, 1024, 1);
    ceL = new a(67, 64, 1);
    ceM = new a(19, 16, 1);
    ceN = new a(285, 256, 0);
    a locala = new a(301, 256, 1);
    ceO = locala;
    ceP = locala;
    ceQ = ceL;
    AppMethodBeat.o(12338);
  }
  
  private a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(12336);
    this.ceV = paramInt1;
    this.size = paramInt2;
    this.ceW = paramInt3;
    this.ceR = new int[paramInt2];
    this.ceS = new int[paramInt2];
    int i = 0;
    paramInt3 = 1;
    while (i < paramInt2)
    {
      this.ceR[i] = paramInt3;
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
      this.ceS[this.ceR[paramInt1]] = paramInt1;
      paramInt1 += 1;
    }
    this.ceT = new b(this, new int[] { 0 });
    this.ceU = new b(this, new int[] { 1 });
    AppMethodBeat.o(12336);
  }
  
  static int cb(int paramInt1, int paramInt2)
  {
    return paramInt1 ^ paramInt2;
  }
  
  final int cc(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      return 0;
    }
    return this.ceR[((this.ceS[paramInt1] + this.ceS[paramInt2]) % (this.size - 1))];
  }
  
  public final String toString()
  {
    AppMethodBeat.i(12337);
    String str = "GF(0x" + Integer.toHexString(this.ceV) + ',' + this.size + ')';
    AppMethodBeat.o(12337);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.c.b.a.a
 * JD-Core Version:    0.7.0.1
 */