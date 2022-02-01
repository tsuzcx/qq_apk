package com.google.android.exoplayer2.source.b;

import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.source.a.a;
import com.google.android.exoplayer2.source.a.a.5;
import com.google.android.exoplayer2.source.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

final class i
  implements l
{
  public final int bnX;
  private final j bnY;
  
  public i(j paramj, int paramInt)
  {
    this.bnY = paramj;
    this.bnX = paramInt;
  }
  
  public final void Y(long paramLong)
  {
    AppMethodBeat.i(62864);
    j localj = this.bnY;
    int i = this.bnX;
    com.google.android.exoplayer2.source.k localk = localj.blA[i];
    if ((localj.blN) && (paramLong > localk.bms.tT()))
    {
      localk.bms.ud();
      AppMethodBeat.o(62864);
      return;
    }
    localk.f(paramLong, true);
    AppMethodBeat.o(62864);
  }
  
  public final int b(com.google.android.exoplayer2.k paramk, e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(62863);
    j localj = this.bnY;
    int k = this.bnX;
    if (localj.tU())
    {
      AppMethodBeat.o(62863);
      return -3;
    }
    if (!localj.bod.isEmpty())
    {
      label75:
      int j;
      if (localj.bod.size() > 1)
      {
        int m = ((f)localj.bod.getFirst()).uid;
        i = 0;
        if (i < localj.blA.length) {
          if (localj.boi[i] != 0)
          {
            localObject1 = localj.blA[i].bms;
            j = ((com.google.android.exoplayer2.source.j)localObject1).eA(((com.google.android.exoplayer2.source.j)localObject1).bmk);
            if (((com.google.android.exoplayer2.source.j)localObject1).ub())
            {
              j = localObject1.bmf[j];
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
          localj.bod.removeFirst();
          break;
          j = ((com.google.android.exoplayer2.source.j)localObject1).bmq;
          break label140;
          label177:
          i += 1;
          break label75;
        }
      }
      label192:
      Object localObject1 = (f)localj.bod.getFirst();
      Format localFormat = ((f)localObject1).bmO;
      if (!localFormat.equals(localj.boe))
      {
        a.a locala = localj.bnO;
        i = localj.trackType;
        j = ((f)localObject1).bmP;
        Object localObject2 = ((f)localObject1).bmQ;
        long l = ((f)localObject1).bmR;
        if (locala.bkL != null) {
          locala.handler.post(new a.a.5(locala, i, localFormat, j, localObject2, l));
        }
      }
      localj.boe = localFormat;
    }
    int i = localj.blA[k].a(paramk, parame, paramBoolean, localj.blN, localj.blK);
    AppMethodBeat.o(62863);
    return i;
  }
  
  public final boolean isReady()
  {
    AppMethodBeat.i(62861);
    j localj = this.bnY;
    int i = this.bnX;
    if ((localj.blN) || ((!localj.tU()) && (localj.blA[i].bms.ub())))
    {
      AppMethodBeat.o(62861);
      return true;
    }
    AppMethodBeat.o(62861);
    return false;
  }
  
  public final void tN()
  {
    AppMethodBeat.i(62862);
    this.bnY.boa.tN();
    AppMethodBeat.o(62862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.i
 * JD-Core Version:    0.7.0.1
 */