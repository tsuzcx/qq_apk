package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class f$1
  implements Runnable
{
  f$1(f paramf) {}
  
  public final void run()
  {
    AppMethodBeat.i(95477);
    f localf = this.aPK;
    if ((localf.released) || (localf.prepared) || (localf.aPu == null) || (!localf.aPx))
    {
      AppMethodBeat.o(95477);
      return;
    }
    Object localObject1 = localf.aPv;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      if (localObject1[i].aQn.pm() == null) {
        break label296;
      }
      i += 1;
    }
    localf.aPr.qH();
    j = localf.aPv.length;
    localObject1 = new o[j];
    localf.aPD = new boolean[j];
    localf.aPC = new boolean[j];
    localf.axh = localf.aPu.getDurationUs();
    i = 0;
    if (i < j)
    {
      Object localObject2 = localf.aPv[i].aQn.pm();
      localObject1[i] = new o(new Format[] { localObject2 });
      localObject2 = ((Format)localObject2).awK;
      if ((com.google.android.exoplayer2.i.j.aH((String)localObject2)) || (com.google.android.exoplayer2.i.j.aG((String)localObject2))) {}
      for (int k = 1;; k = 0)
      {
        localf.aPD[i] = k;
        localf.aPE = (k | localf.aPE);
        i += 1;
        break;
      }
    }
    localf.aPB = new p((o[])localObject1);
    localf.prepared = true;
    localf.aPl.e(localf.axh, localf.aPu.nV());
    localf.aOX.a(localf);
    label296:
    AppMethodBeat.o(95477);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.f.1
 * JD-Core Version:    0.7.0.1
 */