package com.google.android.exoplayer2.source.b;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.source.a.a;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.source.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

final class i
  implements m
{
  public final int bpx;
  private final j bpy;
  
  public i(j paramj, int paramInt)
  {
    this.bpy = paramj;
    this.bpx = paramInt;
  }
  
  public final void X(long paramLong)
  {
    AppMethodBeat.i(62864);
    j localj = this.bpy;
    int i = this.bpx;
    l locall = localj.bkV[i];
    if ((localj.bli) && (paramLong > locall.blN.tL()))
    {
      locall.blN.tV();
      AppMethodBeat.o(62864);
      return;
    }
    locall.f(paramLong, true);
    AppMethodBeat.o(62864);
  }
  
  public final int b(com.google.android.exoplayer2.k paramk, e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(62863);
    j localj = this.bpy;
    int k = this.bpx;
    if (localj.tM())
    {
      AppMethodBeat.o(62863);
      return -3;
    }
    if (!localj.bmG.isEmpty())
    {
      if (localj.bmG.size() > 1)
      {
        int m = ((f)localj.bmG.getFirst()).uid;
        i = 0;
        label75:
        int j;
        if (i < localj.bkV.length) {
          if (localj.bpG[i] != 0)
          {
            localObject = localj.bkV[i].blN;
            j = ((com.google.android.exoplayer2.source.k)localObject).eB(((com.google.android.exoplayer2.source.k)localObject).blF);
            if (((com.google.android.exoplayer2.source.k)localObject).tT())
            {
              j = localObject.blA[j];
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
          localj.bmG.removeFirst();
          break;
          j = ((com.google.android.exoplayer2.source.k)localObject).blL;
          break label140;
          label177:
          i += 1;
          break label75;
        }
      }
      label192:
      Object localObject = (f)localj.bmG.getFirst();
      Format localFormat = ((f)localObject).bmm;
      if (!localFormat.equals(localj.bpD)) {
        localj.bmE.a(localj.aQq, localFormat, ((f)localObject).bmn, ((f)localObject).bmo, ((f)localObject).bmp);
      }
      localj.bpD = localFormat;
    }
    int i = localj.bkV[k].a(paramk, parame, paramBoolean, localj.bli, localj.blf);
    AppMethodBeat.o(62863);
    return i;
  }
  
  public final boolean isReady()
  {
    AppMethodBeat.i(62861);
    j localj = this.bpy;
    int i = this.bpx;
    if ((localj.bli) || ((!localj.tM()) && (localj.bkV[i].blN.tT())))
    {
      AppMethodBeat.o(62861);
      return true;
    }
    AppMethodBeat.o(62861);
    return false;
  }
  
  public final void tF()
  {
    AppMethodBeat.i(62862);
    this.bpy.bpA.tF();
    AppMethodBeat.o(62862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.i
 * JD-Core Version:    0.7.0.1
 */