package com.google.android.exoplayer2.source.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public final class b
  extends c
{
  public final long aNk;
  public final long bgP;
  public final a biA;
  public final int bir;
  public final long bis;
  public final boolean bit;
  public final int biu;
  public final int biv;
  public final long biw;
  public final boolean bix;
  public final boolean biy;
  public final boolean biz;
  public final List<a> segments;
  public final int version;
  
  public b(int paramInt1, String paramString, List<String> paramList, long paramLong1, long paramLong2, boolean paramBoolean1, int paramInt2, int paramInt3, int paramInt4, long paramLong3, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, a parama, List<a> paramList1)
  {
    super(paramString, paramList);
    AppMethodBeat.i(62888);
    this.bir = paramInt1;
    this.bgP = paramLong2;
    this.bit = paramBoolean1;
    this.biu = paramInt2;
    this.biv = paramInt3;
    this.version = paramInt4;
    this.biw = paramLong3;
    this.bix = paramBoolean2;
    this.biy = paramBoolean3;
    this.biz = paramBoolean4;
    this.biA = parama;
    this.segments = Collections.unmodifiableList(paramList1);
    if (!paramList1.isEmpty())
    {
      paramString = (a)paramList1.get(paramList1.size() - 1);
      paramLong2 = paramString.biC;
      this.aNk = (paramString.aNk + paramLong2);
      if (paramLong1 != -9223372036854775807L) {
        break label166;
      }
      paramLong2 = -9223372036854775807L;
    }
    for (;;)
    {
      this.bis = paramLong2;
      AppMethodBeat.o(62888);
      return;
      this.aNk = 0L;
      break;
      label166:
      paramLong2 = paramLong1;
      if (paramLong1 < 0L) {
        paramLong2 = paramLong1 + this.aNk;
      }
    }
  }
  
  public final long tU()
  {
    return this.bgP + this.aNk;
  }
  
  public static final class a
    implements Comparable<Long>
  {
    public final long aNk;
    public final boolean aXW;
    public final int biB;
    public final long biC;
    public final String biD;
    public final String biE;
    public final long biF;
    public final long biG;
    public final String url;
    
    public a(String paramString1, long paramLong1, int paramInt, long paramLong2, boolean paramBoolean, String paramString2, String paramString3, long paramLong3, long paramLong4)
    {
      this.url = paramString1;
      this.aNk = paramLong1;
      this.biB = paramInt;
      this.biC = paramLong2;
      this.aXW = paramBoolean;
      this.biD = paramString2;
      this.biE = paramString3;
      this.biF = paramLong3;
      this.biG = paramLong4;
    }
    
    public a(String paramString, long paramLong1, long paramLong2)
    {
      this(paramString, 0L, -1, -9223372036854775807L, false, null, null, paramLong1, paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.a.b
 * JD-Core Version:    0.7.0.1
 */