package com.tencent.mm.plugin.ai.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ai.b.a.a.e;
import com.tencent.mm.plugin.ai.b.a.a.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  public final void run()
  {
    int j = 0;
    AppMethodBeat.i(238910);
    a locala = this.kxa;
    long l = Util.currentTicks();
    Object localObject;
    if (locala.kwU == null)
    {
      localObject = new e(locala.kwR);
      if (((e)localObject).wW()) {
        locala.kwU = ((e)localObject);
      }
    }
    else
    {
      if (locala.kwV == null)
      {
        localObject = new f(locala.kwS);
        ((f)localObject).wW();
        locala.kwV = ((f)localObject);
      }
      if (locala.kwU == null) {
        break label178;
      }
    }
    label178:
    for (int i = locala.kwU.hashCode();; i = 0)
    {
      if (locala.kwV != null) {
        j = locala.kwV.hashCode();
      }
      Log.i("MicroMsg.FinderRedDotDetector", "init config finish aiFinderQuantiles [%d] aiFinderTffeat2idx[%d] cost[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(Util.ticksToNow(l)) });
      AppMethodBeat.o(238910);
      return;
      h.CyF.dN(1559, 43);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.d.b.a.1
 * JD-Core Version:    0.7.0.1
 */