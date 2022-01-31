package com.google.android.exoplayer2.source.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public final class b
  extends c
{
  public final long aQM;
  public final int aSp;
  public final long aSq;
  public final boolean aSr;
  public final int aSs;
  public final int aSt;
  public final long aSu;
  public final boolean aSv;
  public final boolean aSw;
  public final boolean aSx;
  public final b.a aSy;
  public final List<b.a> aSz;
  public final long axh;
  public final int version;
  
  public b(int paramInt1, String paramString, List<String> paramList, long paramLong1, long paramLong2, boolean paramBoolean1, int paramInt2, int paramInt3, int paramInt4, long paramLong3, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, b.a parama, List<b.a> paramList1)
  {
    super(paramString, paramList);
    AppMethodBeat.i(125964);
    this.aSp = paramInt1;
    this.aQM = paramLong2;
    this.aSr = paramBoolean1;
    this.aSs = paramInt2;
    this.aSt = paramInt3;
    this.version = paramInt4;
    this.aSu = paramLong3;
    this.aSv = paramBoolean2;
    this.aSw = paramBoolean3;
    this.aSx = paramBoolean4;
    this.aSy = parama;
    this.aSz = Collections.unmodifiableList(paramList1);
    if (!paramList1.isEmpty())
    {
      paramString = (b.a)paramList1.get(paramList1.size() - 1);
      paramLong2 = paramString.aSB;
      this.axh = (paramString.axh + paramLong2);
      if (paramLong1 != -9223372036854775807L) {
        break label166;
      }
      paramLong2 = -9223372036854775807L;
    }
    for (;;)
    {
      this.aSq = paramLong2;
      AppMethodBeat.o(125964);
      return;
      this.axh = 0L;
      break;
      label166:
      paramLong2 = paramLong1;
      if (paramLong1 < 0L) {
        paramLong2 = paramLong1 + this.axh;
      }
    }
  }
  
  public final long pD()
  {
    return this.aQM + this.axh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.a.b
 * JD-Core Version:    0.7.0.1
 */