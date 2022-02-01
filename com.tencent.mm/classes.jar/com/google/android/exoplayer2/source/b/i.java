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
  public final int bys;
  private final j byt;
  
  public i(j paramj, int paramInt)
  {
    this.byt = paramj;
    this.bys = paramInt;
  }
  
  public final void Y(long paramLong)
  {
    AppMethodBeat.i(62864);
    j localj = this.byt;
    int i = this.bys;
    com.google.android.exoplayer2.source.k localk = localj.bvV[i];
    if ((localj.bwi) && (paramLong > localk.bwN.vs()))
    {
      localk.bwN.vC();
      AppMethodBeat.o(62864);
      return;
    }
    localk.f(paramLong, true);
    AppMethodBeat.o(62864);
  }
  
  public final int b(com.google.android.exoplayer2.k paramk, e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(62863);
    j localj = this.byt;
    int k = this.bys;
    if (localj.vt())
    {
      AppMethodBeat.o(62863);
      return -3;
    }
    if (!localj.byy.isEmpty())
    {
      label75:
      int j;
      if (localj.byy.size() > 1)
      {
        int m = ((f)localj.byy.getFirst()).uid;
        i = 0;
        if (i < localj.bvV.length) {
          if (localj.byD[i] != 0)
          {
            localObject1 = localj.bvV[i].bwN;
            j = ((com.google.android.exoplayer2.source.j)localObject1).eE(((com.google.android.exoplayer2.source.j)localObject1).bwF);
            if (((com.google.android.exoplayer2.source.j)localObject1).vA())
            {
              j = localObject1.bwA[j];
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
          localj.byy.removeFirst();
          break;
          j = ((com.google.android.exoplayer2.source.j)localObject1).bwL;
          break label140;
          label177:
          i += 1;
          break label75;
        }
      }
      label192:
      Object localObject1 = (f)localj.byy.getFirst();
      Format localFormat = ((f)localObject1).bxj;
      if (!localFormat.equals(localj.byz))
      {
        a.a locala = localj.byj;
        i = localj.trackType;
        j = ((f)localObject1).bxk;
        Object localObject2 = ((f)localObject1).bxl;
        long l = ((f)localObject1).bxm;
        if (locala.bvg != null) {
          locala.handler.post(new a.a.5(locala, i, localFormat, j, localObject2, l));
        }
      }
      localj.byz = localFormat;
    }
    int i = localj.bvV[k].a(paramk, parame, paramBoolean, localj.bwi, localj.bwf);
    AppMethodBeat.o(62863);
    return i;
  }
  
  public final boolean isReady()
  {
    AppMethodBeat.i(62861);
    j localj = this.byt;
    int i = this.bys;
    if ((localj.bwi) || ((!localj.vt()) && (localj.bvV[i].bwN.vA())))
    {
      AppMethodBeat.o(62861);
      return true;
    }
    AppMethodBeat.o(62861);
    return false;
  }
  
  public final void vm()
  {
    AppMethodBeat.i(62862);
    this.byt.byv.vm();
    AppMethodBeat.o(62862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.i
 * JD-Core Version:    0.7.0.1
 */