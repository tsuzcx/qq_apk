package com.google.android.exoplayer2.source.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public final class b
  extends c
{
  public final long bdJ;
  public final long bxn;
  public final int byQ;
  public final long byR;
  public final boolean byS;
  public final int byT;
  public final int byU;
  public final long byV;
  public final boolean byW;
  public final boolean byX;
  public final boolean byY;
  public final a byZ;
  public final List<a> segments;
  public final int version;
  
  public b(int paramInt1, String paramString, List<String> paramList, long paramLong1, long paramLong2, boolean paramBoolean1, int paramInt2, int paramInt3, int paramInt4, long paramLong3, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, a parama, List<a> paramList1)
  {
    super(paramString, paramList);
    AppMethodBeat.i(62888);
    this.byQ = paramInt1;
    this.bxn = paramLong2;
    this.byS = paramBoolean1;
    this.byT = paramInt2;
    this.byU = paramInt3;
    this.version = paramInt4;
    this.byV = paramLong3;
    this.byW = paramBoolean2;
    this.byX = paramBoolean3;
    this.byY = paramBoolean4;
    this.byZ = parama;
    this.segments = Collections.unmodifiableList(paramList1);
    if (!paramList1.isEmpty())
    {
      paramString = (a)paramList1.get(paramList1.size() - 1);
      paramLong2 = paramString.bzb;
      this.bdJ = (paramString.bdJ + paramLong2);
      if (paramLong1 != -9223372036854775807L) {
        break label166;
      }
      paramLong2 = -9223372036854775807L;
    }
    for (;;)
    {
      this.byR = paramLong2;
      AppMethodBeat.o(62888);
      return;
      this.bdJ = 0L;
      break;
      label166:
      paramLong2 = paramLong1;
      if (paramLong1 < 0L) {
        paramLong2 = paramLong1 + this.bdJ;
      }
    }
  }
  
  public final long vW()
  {
    return this.bxn + this.bdJ;
  }
  
  public static final class a
    implements Comparable<Long>
  {
    public final long bdJ;
    public final boolean bou;
    public final int bza;
    public final long bzb;
    public final String bzc;
    public final String bzd;
    public final long bze;
    public final long bzf;
    public final String url;
    
    public a(String paramString1, long paramLong1, int paramInt, long paramLong2, boolean paramBoolean, String paramString2, String paramString3, long paramLong3, long paramLong4)
    {
      this.url = paramString1;
      this.bdJ = paramLong1;
      this.bza = paramInt;
      this.bzb = paramLong2;
      this.bou = paramBoolean;
      this.bzc = paramString2;
      this.bzd = paramString3;
      this.bze = paramLong3;
      this.bzf = paramLong4;
    }
    
    public a(String paramString, long paramLong1, long paramLong2)
    {
      this(paramString, 0L, -1, -9223372036854775807L, false, null, null, paramLong1, paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.a.b
 * JD-Core Version:    0.7.0.1
 */