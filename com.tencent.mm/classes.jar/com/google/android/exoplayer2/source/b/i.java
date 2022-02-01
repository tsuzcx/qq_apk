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
  private final j bhW;
  public final int group;
  
  public i(j paramj, int paramInt)
  {
    this.bhW = paramj;
    this.group = paramInt;
  }
  
  public final void ab(long paramLong)
  {
    AppMethodBeat.i(62864);
    j localj = this.bhW;
    int i = this.group;
    m localm = localj.bfs[i];
    if ((localj.bfF) && (paramLong > localm.bgq.tw()))
    {
      localm.bgq.tF();
      AppMethodBeat.o(62864);
      return;
    }
    localm.f(paramLong, true);
    AppMethodBeat.o(62864);
  }
  
  public final int b(k paramk, e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(62863);
    j localj = this.bhW;
    int k = this.group;
    if (localj.tx())
    {
      AppMethodBeat.o(62863);
      return -3;
    }
    if (!localj.bib.isEmpty())
    {
      label75:
      int j;
      if (localj.bib.size() > 1)
      {
        int m = ((f)localj.bib.getFirst()).uid;
        i = 0;
        if (i < localj.bfs.length) {
          if (localj.big[i] != 0)
          {
            localObject1 = localj.bfs[i].bgq;
            j = ((l)localObject1).eT(((l)localObject1).bgi);
            if (((l)localObject1).tD())
            {
              j = localObject1.bgd[j];
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
          localj.bib.removeFirst();
          break;
          j = ((l)localObject1).bgo;
          break label140;
          label177:
          i += 1;
          break label75;
        }
      }
      label192:
      Object localObject1 = (f)localj.bib.getFirst();
      Format localFormat = ((f)localObject1).bgM;
      if (!localFormat.equals(localj.bic))
      {
        b.a locala = localj.bhN;
        i = localj.trackType;
        j = ((f)localObject1).bgN;
        Object localObject2 = ((f)localObject1).bgO;
        long l = ((f)localObject1).bgP;
        if (locala.beD != null) {
          locala.handler.post(new b.a.5(locala, i, localFormat, j, localObject2, l));
        }
      }
      localj.bic = localFormat;
    }
    int i = localj.bfs[k].a(paramk, parame, paramBoolean, localj.bfF, localj.bfC);
    AppMethodBeat.o(62863);
    return i;
  }
  
  public final boolean isReady()
  {
    AppMethodBeat.i(62861);
    j localj = this.bhW;
    int i = this.group;
    if ((localj.bfF) || ((!localj.tx()) && (localj.bfs[i].bgq.tD())))
    {
      AppMethodBeat.o(62861);
      return true;
    }
    AppMethodBeat.o(62861);
    return false;
  }
  
  public final void tq()
  {
    AppMethodBeat.i(62862);
    this.bhW.tq();
    AppMethodBeat.o(62862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.i
 * JD-Core Version:    0.7.0.1
 */