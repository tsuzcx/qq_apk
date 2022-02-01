package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.b;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
  extends c
{
  private volatile boolean bll;
  private final d bmQ;
  private volatile int bmR;
  
  public k(g paramg, j paramj, Format paramFormat, int paramInt, Object paramObject, d paramd)
  {
    super(paramg, paramj, 2, paramFormat, paramInt, paramObject, -9223372036854775807L, -9223372036854775807L);
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
    AppMethodBeat.i(92609);
    Object localObject1 = this.bml.ap(this.bmR);
    for (;;)
    {
      try
      {
        localObject1 = new b(this.aWG, ((j)localObject1).bwz, this.aWG.a((j)localObject1));
        if (this.bmR == 0) {
          this.bmQ.a(null);
        }
        int i;
        try
        {
          e locale = this.bmQ.blp;
          i = 0;
          if ((i != 0) || (this.bll)) {
            break label179;
          }
          i = locale.a((f)localObject1, null);
          continue;
          a.checkState(bool);
          this.bmR = ((int)(((f)localObject1).getPosition() - this.bml.bwz));
          return;
        }
        finally
        {
          this.bmR = ((int)(((f)localObject1).getPosition() - this.bml.bwz));
          AppMethodBeat.o(92609);
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
        AppMethodBeat.o(92609);
      }
      label179:
      boolean bool = true;
    }
  }
  
  public final long ub()
  {
    return this.bmR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.a.k
 * JD-Core Version:    0.7.0.1
 */