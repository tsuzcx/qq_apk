package com.google.android.exoplayer2.source.b;

import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.k;
import com.google.android.exoplayer2.source.b.a;
import com.google.android.exoplayer2.source.b.a.5;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.source.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

final class i
  implements n
{
  public final int byu;
  private final j byv;
  
  public i(j paramj, int paramInt)
  {
    this.byv = paramj;
    this.byu = paramInt;
  }
  
  public final void Y(long paramLong)
  {
    AppMethodBeat.i(62864);
    j localj = this.byv;
    int i = this.byu;
    m localm = localj.bvQ[i];
    if ((localj.bwd) && (paramLong > localm.bwO.vy()))
    {
      localm.bwO.vH();
      AppMethodBeat.o(62864);
      return;
    }
    localm.f(paramLong, true);
    AppMethodBeat.o(62864);
  }
  
  public final int b(k paramk, e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(62863);
    j localj = this.byv;
    int k = this.byu;
    if (localj.vz())
    {
      AppMethodBeat.o(62863);
      return -3;
    }
    if (!localj.byA.isEmpty())
    {
      label75:
      int j;
      if (localj.byA.size() > 1)
      {
        int m = ((f)localj.byA.getFirst()).uid;
        i = 0;
        if (i < localj.bvQ.length) {
          if (localj.byF[i] != 0)
          {
            localObject1 = localj.bvQ[i].bwO;
            j = ((l)localObject1).eD(((l)localObject1).bwG);
            if (((l)localObject1).vF())
            {
              j = localObject1.bwB[j];
              label140:
              if (j != m) {
                break label177;
              }
            }
          }
        }
        for (i = 0;; i = 1)
        {
          if (i == 0) {
            break label192;
          }
          localj.byA.removeFirst();
          break;
          j = ((l)localObject1).bwM;
          break label140;
          label177:
          i += 1;
          break label75;
        }
      }
      label192:
      Object localObject1 = (f)localj.byA.getFirst();
      Format localFormat = ((f)localObject1).bxk;
      if (!localFormat.equals(localj.byB))
      {
        b.a locala = localj.byl;
        i = localj.trackType;
        j = ((f)localObject1).bxl;
        Object localObject2 = ((f)localObject1).bxm;
        long l = ((f)localObject1).bxn;
        if (locala.bvb != null) {
          locala.handler.post(new b.a.5(locala, i, localFormat, j, localObject2, l));
        }
      }
      localj.byB = localFormat;
    }
    int i = localj.bvQ[k].a(paramk, parame, paramBoolean, localj.bwd, localj.bwa);
    AppMethodBeat.o(62863);
    return i;
  }
  
  public final boolean isReady()
  {
    AppMethodBeat.i(62861);
    j localj = this.byv;
    int i = this.byu;
    if ((localj.bwd) || ((!localj.vz()) && (localj.bvQ[i].bwO.vF())))
    {
      AppMethodBeat.o(62861);
      return true;
    }
    AppMethodBeat.o(62861);
    return false;
  }
  
  public final void vs()
  {
    AppMethodBeat.i(62862);
    this.byv.byx.vs();
    AppMethodBeat.o(62862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.i
 * JD-Core Version:    0.7.0.1
 */