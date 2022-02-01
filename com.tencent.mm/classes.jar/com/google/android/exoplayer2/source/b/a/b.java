package com.google.android.exoplayer2.source.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public final class b
  extends c
{
  public final long cHg;
  public final long daJ;
  public final int dcl;
  public final long dcm;
  public final boolean dcn;
  public final int dco;
  public final int dcp;
  public final long dcq;
  public final boolean dcr;
  public final boolean dcs;
  public final boolean dct;
  public final a dcu;
  public final List<a> segments;
  public final int version;
  
  public b(int paramInt1, String paramString, List<String> paramList, long paramLong1, long paramLong2, boolean paramBoolean1, int paramInt2, int paramInt3, int paramInt4, long paramLong3, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, a parama, List<a> paramList1)
  {
    super(paramString, paramList);
    AppMethodBeat.i(62888);
    this.dcl = paramInt1;
    this.daJ = paramLong2;
    this.dcn = paramBoolean1;
    this.dco = paramInt2;
    this.dcp = paramInt3;
    this.version = paramInt4;
    this.dcq = paramLong3;
    this.dcr = paramBoolean2;
    this.dcs = paramBoolean3;
    this.dct = paramBoolean4;
    this.dcu = parama;
    this.segments = Collections.unmodifiableList(paramList1);
    if (!paramList1.isEmpty())
    {
      paramString = (a)paramList1.get(paramList1.size() - 1);
      paramLong2 = paramString.dcw;
      this.cHg = (paramString.cHg + paramLong2);
      if (paramLong1 != -9223372036854775807L) {
        break label166;
      }
      paramLong2 = -9223372036854775807L;
    }
    for (;;)
    {
      this.dcm = paramLong2;
      AppMethodBeat.o(62888);
      return;
      this.cHg = 0L;
      break;
      label166:
      paramLong2 = paramLong1;
      if (paramLong1 < 0L) {
        paramLong2 = paramLong1 + this.cHg;
      }
    }
  }
  
  public final long Tx()
  {
    return this.daJ + this.cHg;
  }
  
  public static final class a
    implements Comparable<Long>
  {
    public final long cHg;
    public final boolean cRS;
    public final long dcA;
    public final int dcv;
    public final long dcw;
    public final String dcx;
    public final String dcy;
    public final long dcz;
    public final String url;
    
    public a(String paramString1, long paramLong1, int paramInt, long paramLong2, boolean paramBoolean, String paramString2, String paramString3, long paramLong3, long paramLong4)
    {
      this.url = paramString1;
      this.cHg = paramLong1;
      this.dcv = paramInt;
      this.dcw = paramLong2;
      this.cRS = paramBoolean;
      this.dcx = paramString2;
      this.dcy = paramString3;
      this.dcz = paramLong3;
      this.dcA = paramLong4;
    }
    
    public a(String paramString, long paramLong1, long paramLong2)
    {
      this(paramString, 0L, -1, -9223372036854775807L, false, null, null, paramLong1, paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.a.b
 * JD-Core Version:    0.7.0.1
 */