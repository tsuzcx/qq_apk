package com.tencent.mm.plugin.ai.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ai.data.business.finder.f;
import com.tencent.mm.plugin.ai.data.business.finder.g;
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
    AppMethodBeat.i(267449);
    a locala = this.qoz;
    long l = Util.currentTicks();
    Object localObject;
    if (locala.qot == null)
    {
      localObject = new f(locala.qoq);
      if (((f)localObject).Ux()) {
        locala.qot = ((f)localObject);
      }
    }
    else
    {
      if (locala.qou == null)
      {
        localObject = new g(locala.qor);
        if (!((g)localObject).Ux()) {
          break label180;
        }
        locala.qou = ((g)localObject);
      }
      label91:
      if (locala.qot == null) {
        break label194;
      }
    }
    label180:
    label194:
    for (int i = locala.qot.hashCode();; i = 0)
    {
      if (locala.qou != null) {
        j = locala.qou.hashCode();
      }
      Log.i("MicroMsg.FinderRedDotDetector", "init config finish aiFinderQuantiles [%d] aiFinderTffeat2idx[%d] cost[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(Util.ticksToNow(l)) });
      AppMethodBeat.o(267449);
      return;
      h.OAn.kJ(1559, 43);
      break;
      h.OAn.kJ(1559, 44);
      break label91;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.c.b.a.1
 * JD-Core Version:    0.7.0.1
 */