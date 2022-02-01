package com.google.b.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static final a cdg;
  public static final a cdh;
  public static final a cdi;
  public static final a cdj;
  public static final a cdk;
  public static final a cdl;
  public static final a cdm;
  public static final a cdn;
  final int[] cdo;
  final int[] cdp;
  final b cdq;
  private final b cdr;
  private final int cds;
  final int cdt;
  final int size;
  
  static
  {
    AppMethodBeat.i(12338);
    cdg = new a(4201, 4096, 1);
    cdh = new a(1033, 1024, 1);
    cdi = new a(67, 64, 1);
    cdj = new a(19, 16, 1);
    cdk = new a(285, 256, 0);
    a locala = new a(301, 256, 1);
    cdl = locala;
    cdm = locala;
    cdn = cdi;
    AppMethodBeat.o(12338);
  }
  
  private a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(12336);
    this.cds = paramInt1;
    this.size = paramInt2;
    this.cdt = paramInt3;
    this.cdo = new int[paramInt2];
    this.cdp = new int[paramInt2];
    int i = 0;
    paramInt3 = 1;
    while (i < paramInt2)
    {
      this.cdo[i] = paramInt3;
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
      this.cdp[this.cdo[paramInt1]] = paramInt1;
      paramInt1 += 1;
    }
    this.cdq = new b(this, new int[] { 0 });
    this.cdr = new b(this, new int[] { 1 });
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
    return this.cdo[((this.cdp[paramInt1] + this.cdp[paramInt2]) % (this.size - 1))];
  }
  
  public final String toString()
  {
    AppMethodBeat.i(12337);
    String str = "GF(0x" + Integer.toHexString(this.cds) + ',' + this.size + ')';
    AppMethodBeat.o(12337);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.b.b.a.a
 * JD-Core Version:    0.7.0.1
 */