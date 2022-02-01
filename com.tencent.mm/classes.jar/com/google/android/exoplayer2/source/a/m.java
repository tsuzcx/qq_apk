package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
  extends a
{
  private final int aQq;
  private volatile boolean bll;
  private volatile int bmR;
  private volatile boolean bmS;
  private final Format bmw;
  
  public m(g paramg, j paramj, Format paramFormat1, int paramInt1, Object paramObject, long paramLong1, long paramLong2, int paramInt2, int paramInt3, Format paramFormat2)
  {
    super(paramg, paramj, paramFormat1, paramInt1, paramObject, paramLong1, paramLong2, paramInt2);
    this.aQq = paramInt3;
    this.bmw = paramFormat2;
  }
  
  public final void tN()
  {
    this.bll = true;
  }
  
  public final boolean tO()
  {
    return this.bll;
  }
  
  public final void tP()
  {
    AppMethodBeat.i(92610);
    Object localObject1 = this.bml.ap(this.bmR);
    try
    {
      long l2 = this.aWG.a((j)localObject1);
      long l1 = l2;
      if (l2 != -1L) {
        l1 = l2 + this.bmR;
      }
      localObject1 = new com.google.android.exoplayer2.c.b(this.aWG, this.bmR, l1);
      Object localObject3 = this.bmi;
      ((b)localObject3).ae(0L);
      localObject3 = ((b)localObject3).eF(this.aQq);
      ((com.google.android.exoplayer2.c.m)localObject3).f(this.bmw);
      for (int i = 0; i != -1; i = ((com.google.android.exoplayer2.c.m)localObject3).a((f)localObject1, 2147483647, true)) {
        this.bmR = (i + this.bmR);
      }
      i = this.bmR;
      ((com.google.android.exoplayer2.c.m)localObject3).a(this.bmp, 1, i, 0, null);
      x.a(this.aWG);
      this.bmS = true;
      AppMethodBeat.o(92610);
      return;
    }
    finally
    {
      x.a(this.aWG);
      AppMethodBeat.o(92610);
    }
  }
  
  public final long ub()
  {
    return this.bmR;
  }
  
  public final boolean ud()
  {
    return this.bmS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.a.m
 * JD-Core Version:    0.7.0.1
 */