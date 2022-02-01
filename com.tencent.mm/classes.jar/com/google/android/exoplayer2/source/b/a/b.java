package com.google.android.exoplayer2.source.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public final class b
  extends c
{
  public final long aTs;
  public final long bmR;
  public final boolean boA;
  public final boolean boB;
  public final a boC;
  public final int bot;
  public final long bou;
  public final boolean bov;
  public final int bow;
  public final int box;
  public final long boy;
  public final boolean boz;
  public final List<a> segments;
  public final int version;
  
  public b(int paramInt1, String paramString, List<String> paramList, long paramLong1, long paramLong2, boolean paramBoolean1, int paramInt2, int paramInt3, int paramInt4, long paramLong3, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, a parama, List<a> paramList1)
  {
    super(paramString, paramList);
    AppMethodBeat.i(62888);
    this.bot = paramInt1;
    this.bmR = paramLong2;
    this.bov = paramBoolean1;
    this.bow = paramInt2;
    this.box = paramInt3;
    this.version = paramInt4;
    this.boy = paramLong3;
    this.boz = paramBoolean2;
    this.boA = paramBoolean3;
    this.boB = paramBoolean4;
    this.boC = parama;
    this.segments = Collections.unmodifiableList(paramList1);
    if (!paramList1.isEmpty())
    {
      paramString = (a)paramList1.get(paramList1.size() - 1);
      paramLong2 = paramString.boE;
      this.aTs = (paramString.aTs + paramLong2);
      if (paramLong1 != -9223372036854775807L) {
        break label166;
      }
      paramLong2 = -9223372036854775807L;
    }
    for (;;)
    {
      this.bou = paramLong2;
      AppMethodBeat.o(62888);
      return;
      this.aTs = 0L;
      break;
      label166:
      paramLong2 = paramLong1;
      if (paramLong1 < 0L) {
        paramLong2 = paramLong1 + this.aTs;
      }
    }
  }
  
  public final long us()
  {
    return this.bmR + this.aTs;
  }
  
  public static final class a
    implements Comparable<Long>
  {
    public final long aTs;
    public final boolean bee;
    public final int boD;
    public final long boE;
    public final String boF;
    public final String boG;
    public final long boH;
    public final long boI;
    public final String url;
    
    public a(String paramString1, long paramLong1, int paramInt, long paramLong2, boolean paramBoolean, String paramString2, String paramString3, long paramLong3, long paramLong4)
    {
      this.url = paramString1;
      this.aTs = paramLong1;
      this.boD = paramInt;
      this.boE = paramLong2;
      this.bee = paramBoolean;
      this.boF = paramString2;
      this.boG = paramString3;
      this.boH = paramLong3;
      this.boI = paramLong4;
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