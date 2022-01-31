package com.google.android.exoplayer2.source.b.a;

import java.util.Collections;
import java.util.List;

public final class b
  extends c
{
  public final long aJe;
  public final int aKV;
  public final long aKW;
  public final boolean aKX;
  public final int aKY;
  public final int aKZ;
  public final long aLa;
  public final boolean aLb;
  public final boolean aLc;
  public final boolean aLd;
  public final b.a aLe;
  public final List<b.a> aLf;
  public final long auP;
  public final int version;
  
  public b(int paramInt1, String paramString, List<String> paramList, long paramLong1, long paramLong2, boolean paramBoolean1, int paramInt2, int paramInt3, int paramInt4, long paramLong3, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, b.a parama, List<b.a> paramList1)
  {
    super(paramString, paramList);
    this.aKV = paramInt1;
    this.aJe = paramLong2;
    this.aKX = paramBoolean1;
    this.aKY = paramInt2;
    this.aKZ = paramInt3;
    this.version = paramInt4;
    this.aLa = paramLong3;
    this.aLb = paramBoolean2;
    this.aLc = paramBoolean3;
    this.aLd = paramBoolean4;
    this.aLe = parama;
    this.aLf = Collections.unmodifiableList(paramList1);
    if (!paramList1.isEmpty())
    {
      paramString = (b.a)paramList1.get(paramList1.size() - 1);
      paramLong2 = paramString.aLh;
      this.auP = (paramString.auP + paramLong2);
      if (paramLong1 != -9223372036854775807L) {
        break label156;
      }
      paramLong2 = -9223372036854775807L;
    }
    for (;;)
    {
      this.aKW = paramLong2;
      return;
      this.auP = 0L;
      break;
      label156:
      paramLong2 = paramLong1;
      if (paramLong1 < 0L) {
        paramLong2 = paramLong1 + this.auP;
      }
    }
  }
  
  public final long ng()
  {
    return this.aJe + this.auP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.a.b
 * JD-Core Version:    0.7.0.1
 */