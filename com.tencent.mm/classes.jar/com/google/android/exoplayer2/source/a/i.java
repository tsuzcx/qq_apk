package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  extends a
{
  private final long blV;
  private volatile boolean bll;
  private final int bmP;
  private final d bmQ;
  private volatile int bmR;
  private volatile boolean bmS;
  
  public i(g paramg, j paramj, Format paramFormat, int paramInt1, Object paramObject, long paramLong1, long paramLong2, int paramInt2, int paramInt3, long paramLong3, d paramd)
  {
    super(paramg, paramj, paramFormat, paramInt1, paramObject, paramLong1, paramLong2, paramInt2);
    this.bmP = paramInt3;
    this.blV = paramLong3;
    this.bmQ = paramd;
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
    AppMethodBeat.i(92608);
    Object localObject1 = this.bml.ap(this.bmR);
    for (;;)
    {
      try
      {
        localObject1 = new com.google.android.exoplayer2.c.b(this.aWG, ((j)localObject1).bwz, this.aWG.a((j)localObject1));
        Object localObject3;
        if (this.bmR == 0)
        {
          localObject3 = this.bmi;
          ((b)localObject3).ae(this.blV);
          this.bmQ.a((d.b)localObject3);
        }
        int i;
        try
        {
          localObject3 = this.bmQ.blp;
          i = 0;
          if ((i != 0) || (this.bll)) {
            break label200;
          }
          i = ((e)localObject3).a((f)localObject1, null);
          continue;
          com.google.android.exoplayer2.i.a.checkState(bool);
          this.bmR = ((int)(((f)localObject1).getPosition() - this.bml.bwz));
          x.a(this.aWG);
          this.bmS = true;
          AppMethodBeat.o(92608);
          return;
        }
        finally
        {
          this.bmR = ((int)(((f)localObject1).getPosition() - this.bml.bwz));
          AppMethodBeat.o(92608);
        }
        bool = false;
        continue;
        if (i == 1) {
          continue;
        }
      }
      finally
      {
        x.a(this.aWG);
        AppMethodBeat.o(92608);
      }
      label200:
      boolean bool = true;
    }
  }
  
  public final long ub()
  {
    return this.bmR;
  }
  
  public final int uc()
  {
    return this.bmT + this.bmP;
  }
  
  public final boolean ud()
  {
    return this.bmS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.a.i
 * JD-Core Version:    0.7.0.1
 */