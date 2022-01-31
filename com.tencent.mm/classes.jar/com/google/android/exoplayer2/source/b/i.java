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
  public final int aRS;
  private final j aRT;
  
  public i(j paramj, int paramInt)
  {
    this.aRT = paramj;
    this.aRS = paramInt;
  }
  
  public final void R(long paramLong)
  {
    AppMethodBeat.i(125940);
    j localj = this.aRT;
    int i = this.aRS;
    com.google.android.exoplayer2.source.k localk = localj.aPv[i];
    if ((localj.aPJ) && (paramLong > localk.aQn.pd()))
    {
      localk.aQn.pn();
      AppMethodBeat.o(125940);
      return;
    }
    localk.g(paramLong, true);
    AppMethodBeat.o(125940);
  }
  
  public final int b(com.google.android.exoplayer2.k paramk, e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(125939);
    j localj = this.aRT;
    int k = this.aRS;
    if (localj.pe())
    {
      AppMethodBeat.o(125939);
      return -3;
    }
    if (!localj.aRY.isEmpty())
    {
      label75:
      int j;
      if (localj.aRY.size() > 1)
      {
        int m = ((f)localj.aRY.getFirst()).uid;
        i = 0;
        if (i < localj.aPv.length) {
          if (localj.aSd[i] != 0)
          {
            localObject1 = localj.aPv[i].aQn;
            j = ((com.google.android.exoplayer2.source.j)localObject1).dP(((com.google.android.exoplayer2.source.j)localObject1).aQf);
            if (((com.google.android.exoplayer2.source.j)localObject1).pl())
            {
              j = localObject1.aQa[j];
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
          localj.aRY.removeFirst();
          break;
          j = ((com.google.android.exoplayer2.source.j)localObject1).aQl;
          break label140;
          label177:
          i += 1;
          break label75;
        }
      }
      label192:
      Object localObject1 = (f)localj.aRY.getFirst();
      Format localFormat = ((f)localObject1).aQJ;
      if (!localFormat.equals(localj.aRZ))
      {
        a.a locala = localj.aRJ;
        i = localj.auX;
        j = ((f)localObject1).aQK;
        Object localObject2 = ((f)localObject1).aQL;
        long l = ((f)localObject1).aQM;
        if (locala.aOG != null) {
          locala.handler.post(new a.a.5(locala, i, localFormat, j, localObject2, l));
        }
      }
      localj.aRZ = localFormat;
    }
    int i = localj.aPv[k].a(paramk, parame, paramBoolean, localj.aPJ, localj.aPG);
    AppMethodBeat.o(125939);
    return i;
  }
  
  public final boolean isReady()
  {
    AppMethodBeat.i(125937);
    j localj = this.aRT;
    int i = this.aRS;
    if ((localj.aPJ) || ((!localj.pe()) && (localj.aPv[i].aQn.pl())))
    {
      AppMethodBeat.o(125937);
      return true;
    }
    AppMethodBeat.o(125937);
    return false;
  }
  
  public final void oX()
  {
    AppMethodBeat.i(125938);
    this.aRT.aRV.oX();
    AppMethodBeat.o(125938);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.i
 * JD-Core Version:    0.7.0.1
 */