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
  private final j dbQ;
  public final int group;
  
  public i(j paramj, int paramInt)
  {
    this.dbQ = paramj;
    this.group = paramInt;
  }
  
  public final void ST()
  {
    AppMethodBeat.i(62862);
    this.dbQ.ST();
    AppMethodBeat.o(62862);
  }
  
  public final int b(k paramk, e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(62863);
    j localj = this.dbQ;
    int k = this.group;
    if (localj.Ta())
    {
      AppMethodBeat.o(62863);
      return -3;
    }
    if (!localj.dbV.isEmpty())
    {
      label75:
      int j;
      if (localj.dbV.size() > 1)
      {
        int m = ((f)localj.dbV.getFirst()).uid;
        i = 0;
        if (i < localj.cZl.length) {
          if (localj.dca[i] != 0)
          {
            localObject1 = localj.cZl[i].daj;
            j = ((l)localObject1).ij(((l)localObject1).dab);
            if (((l)localObject1).Tg())
            {
              j = localObject1.cZW[j];
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
          localj.dbV.removeFirst();
          break;
          j = ((l)localObject1).dah;
          break label140;
          label177:
          i += 1;
          break label75;
        }
      }
      label192:
      Object localObject1 = (f)localj.dbV.getFirst();
      Format localFormat = ((f)localObject1).daG;
      if (!localFormat.equals(localj.dbW))
      {
        b.a locala = localj.dbH;
        i = localj.trackType;
        j = ((f)localObject1).daH;
        Object localObject2 = ((f)localObject1).daI;
        long l = ((f)localObject1).daJ;
        if (locala.cYw != null) {
          locala.handler.post(new b.a.5(locala, i, localFormat, j, localObject2, l));
        }
      }
      localj.dbW = localFormat;
    }
    int i = localj.cZl[k].a(paramk, parame, paramBoolean, localj.cZy, localj.cZv);
    AppMethodBeat.o(62863);
    return i;
  }
  
  public final void cp(long paramLong)
  {
    AppMethodBeat.i(62864);
    j localj = this.dbQ;
    int i = this.group;
    m localm = localj.cZl[i];
    if ((localj.cZy) && (paramLong > localm.daj.SZ()))
    {
      localm.daj.Ti();
      AppMethodBeat.o(62864);
      return;
    }
    localm.k(paramLong, true);
    AppMethodBeat.o(62864);
  }
  
  public final boolean isReady()
  {
    AppMethodBeat.i(62861);
    j localj = this.dbQ;
    int i = this.group;
    if ((localj.cZy) || ((!localj.Ta()) && (localj.cZl[i].daj.Tg())))
    {
      AppMethodBeat.o(62861);
      return true;
    }
    AppMethodBeat.o(62861);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.i
 * JD-Core Version:    0.7.0.1
 */