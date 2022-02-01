package com.google.android.exoplayer2.source.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public final class b
  extends c
{
  public final long aSz;
  public final long bmp;
  public final int bpS;
  public final long bpT;
  public final boolean bpU;
  public final int bpV;
  public final int bpW;
  public final long bpX;
  public final boolean bpY;
  public final boolean bpZ;
  public final boolean bqa;
  public final a bqb;
  public final List<a> segments;
  public final int version;
  
  public b(int paramInt1, String paramString, List<String> paramList, long paramLong1, long paramLong2, boolean paramBoolean1, int paramInt2, int paramInt3, int paramInt4, long paramLong3, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, a parama, List<a> paramList1)
  {
    super(paramString, paramList);
    AppMethodBeat.i(62888);
    this.bpS = paramInt1;
    this.bmp = paramLong2;
    this.bpU = paramBoolean1;
    this.bpV = paramInt2;
    this.bpW = paramInt3;
    this.version = paramInt4;
    this.bpX = paramLong3;
    this.bpY = paramBoolean2;
    this.bpZ = paramBoolean3;
    this.bqa = paramBoolean4;
    this.bqb = parama;
    this.segments = Collections.unmodifiableList(paramList1);
    if (!paramList1.isEmpty())
    {
      paramString = (a)paramList1.get(paramList1.size() - 1);
      paramLong2 = paramString.bqe;
      this.aSz = (paramString.aSz + paramLong2);
      if (paramLong1 != -9223372036854775807L) {
        break label166;
      }
      paramLong2 = -9223372036854775807L;
    }
    for (;;)
    {
      this.bpT = paramLong2;
      AppMethodBeat.o(62888);
      return;
      this.aSz = 0L;
      break;
      label166:
      paramLong2 = paramLong1;
      if (paramLong1 < 0L) {
        paramLong2 = paramLong1 + this.aSz;
      }
    }
  }
  
  public final long uw()
  {
    return this.bmp + this.aSz;
  }
  
  public static final class a
    implements Comparable<Long>
  {
    public final long aSz;
    public final boolean bds;
    public final int bqd;
    public final long bqe;
    public final String bqf;
    public final String bqg;
    public final long bqh;
    public final long bqi;
    public final String url;
    
    public a(String paramString1, long paramLong1, int paramInt, long paramLong2, boolean paramBoolean, String paramString2, String paramString3, long paramLong3, long paramLong4)
    {
      this.url = paramString1;
      this.aSz = paramLong1;
      this.bqd = paramInt;
      this.bqe = paramLong2;
      this.bds = paramBoolean;
      this.bqf = paramString2;
      this.bqg = paramString3;
      this.bqh = paramLong3;
      this.bqi = paramLong4;
    }
    
    public a(String paramString, long paramLong1, long paramLong2)
    {
      this(paramString, 0L, -1, -9223372036854775807L, false, null, null, paramLong1, paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.a.b
 * JD-Core Version:    0.7.0.1
 */