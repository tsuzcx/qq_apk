package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.w;
import com.google.android.exoplayer2.w.a;
import com.google.android.exoplayer2.w.b;

public final class k
  extends w
{
  private static final Object aIT = new Object();
  private final long aIU;
  private final long aIV;
  private final long aIW;
  private final long aIX;
  private final long avC;
  private final long avD;
  private final boolean avE;
  private final boolean avF;
  
  public k(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, boolean paramBoolean)
  {
    this.avC = paramLong1;
    this.avD = paramLong2;
    this.aIU = paramLong3;
    this.aIV = paramLong4;
    this.aIW = paramLong5;
    this.aIX = paramLong6;
    this.avE = true;
    this.avF = paramBoolean;
  }
  
  public final int O(Object paramObject)
  {
    if (aIT.equals(paramObject)) {
      return 0;
    }
    return -1;
  }
  
  public final w.a a(int paramInt, w.a parama, boolean paramBoolean)
  {
    a.aI(paramInt, 1);
    if (paramBoolean) {}
    for (Object localObject = aIT;; localObject = null)
    {
      long l1 = this.aIU;
      long l2 = -this.aIW;
      parama.avu = localObject;
      parama.atW = localObject;
      parama.auk = 0;
      parama.auP = l1;
      parama.avv = l2;
      parama.avw = null;
      parama.avx = null;
      parama.avy = null;
      parama.avz = null;
      parama.avA = null;
      parama.avB = -9223372036854775807L;
      return parama;
    }
  }
  
  public final w.b a(int paramInt, w.b paramb, long paramLong)
  {
    a.aI(paramInt, 1);
    long l2 = this.aIX;
    long l1 = l2;
    if (this.avF)
    {
      paramLong = l2 + paramLong;
      l1 = paramLong;
      if (paramLong > this.aIV) {
        l1 = -9223372036854775807L;
      }
    }
    paramLong = this.avC;
    l2 = this.avD;
    boolean bool1 = this.avE;
    boolean bool2 = this.avF;
    long l3 = this.aIV;
    long l4 = this.aIW;
    paramb.avu = null;
    paramb.avC = paramLong;
    paramb.avD = l2;
    paramb.avE = bool1;
    paramb.avF = bool2;
    paramb.avI = l1;
    paramb.auP = l3;
    paramb.avG = 0;
    paramb.avH = 0;
    paramb.avJ = l4;
    return paramb;
  }
  
  public final int kV()
  {
    return 1;
  }
  
  public final int kW()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.k
 * JD-Core Version:    0.7.0.1
 */