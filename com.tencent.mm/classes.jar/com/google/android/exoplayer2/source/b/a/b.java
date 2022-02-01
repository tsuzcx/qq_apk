package com.google.android.exoplayer2.source.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public final class b
  extends c
{
  public final long bdM;
  public final long bxm;
  public final int byO;
  public final long byP;
  public final boolean byQ;
  public final int byR;
  public final int byS;
  public final long byT;
  public final boolean byU;
  public final boolean byV;
  public final boolean byW;
  public final a byX;
  public final List<a> segments;
  public final int version;
  
  public b(int paramInt1, String paramString, List<String> paramList, long paramLong1, long paramLong2, boolean paramBoolean1, int paramInt2, int paramInt3, int paramInt4, long paramLong3, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, a parama, List<a> paramList1)
  {
    super(paramString, paramList);
    AppMethodBeat.i(62888);
    this.byO = paramInt1;
    this.bxm = paramLong2;
    this.byQ = paramBoolean1;
    this.byR = paramInt2;
    this.byS = paramInt3;
    this.version = paramInt4;
    this.byT = paramLong3;
    this.byU = paramBoolean2;
    this.byV = paramBoolean3;
    this.byW = paramBoolean4;
    this.byX = parama;
    this.segments = Collections.unmodifiableList(paramList1);
    if (!paramList1.isEmpty())
    {
      paramString = (a)paramList1.get(paramList1.size() - 1);
      paramLong2 = paramString.byZ;
      this.bdM = (paramString.bdM + paramLong2);
      if (paramLong1 != -9223372036854775807L) {
        break label166;
      }
      paramLong2 = -9223372036854775807L;
    }
    for (;;)
    {
      this.byP = paramLong2;
      AppMethodBeat.o(62888);
      return;
      this.bdM = 0L;
      break;
      label166:
      paramLong2 = paramLong1;
      if (paramLong1 < 0L) {
        paramLong2 = paramLong1 + this.bdM;
      }
    }
  }
  
  public final long vR()
  {
    return this.bxm + this.bdM;
  }
  
  public static final class a
    implements Comparable<Long>
  {
    public final long bdM;
    public final boolean boz;
    public final int byY;
    public final long byZ;
    public final String bza;
    public final String bzb;
    public final long bzc;
    public final long bzd;
    public final String url;
    
    public a(String paramString1, long paramLong1, int paramInt, long paramLong2, boolean paramBoolean, String paramString2, String paramString3, long paramLong3, long paramLong4)
    {
      this.url = paramString1;
      this.bdM = paramLong1;
      this.byY = paramInt;
      this.byZ = paramLong2;
      this.boz = paramBoolean;
      this.bza = paramString2;
      this.bzb = paramString3;
      this.bzc = paramLong3;
      this.bzd = paramLong4;
    }
    
    public a(String paramString, long paramLong1, long paramLong2)
    {
      this(paramString, 0L, -1, -9223372036854775807L, false, null, null, paramLong1, paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.a.b
 * JD-Core Version:    0.7.0.1
 */