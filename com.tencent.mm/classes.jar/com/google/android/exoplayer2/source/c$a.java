package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.k;

final class c$a
  implements i
{
  private final long aIe;
  private final long aIf;
  boolean aIi;
  boolean aIj;
  final i asI;
  private final e atV;
  
  public c$a(e parame, i parami, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this.atV = parame;
    this.asI = parami;
    this.aIe = paramLong1;
    this.aIf = paramLong2;
    this.aIi = paramBoolean;
  }
  
  public final void K(long paramLong)
  {
    this.asI.K(this.aIe + paramLong);
  }
  
  public final int b(k paramk, com.google.android.exoplayer2.b.e parame, boolean paramBoolean)
  {
    if (this.aIi) {
      return -3;
    }
    if (this.aIj)
    {
      parame.flags = 4;
      return -4;
    }
    int i = this.asI.b(paramk, parame, paramBoolean);
    if ((this.aIf != -9223372036854775808L) && (((i == -4) && (parame.ayE >= this.aIf)) || ((i == -3) && (this.atV.mB() == -9223372036854775808L))))
    {
      parame.clear();
      parame.flags = 4;
      this.aIj = true;
      return -4;
    }
    if ((i == -4) && (!parame.lz())) {
      parame.ayE -= this.aIe;
    }
    return i;
  }
  
  public final boolean isReady()
  {
    return this.asI.isReady();
  }
  
  public final void mD()
  {
    this.asI.mD();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.source.c.a
 * JD-Core Version:    0.7.0.1
 */