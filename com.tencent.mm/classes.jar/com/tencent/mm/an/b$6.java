package com.tencent.mm.an;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

final class b$6
  extends o.a
{
  b$6(b paramb) {}
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(223550);
    Log.i("MicroMsg.CdnTransportService", "onAppBackground %s", new Object[] { paramString });
    if (!b.baJ())
    {
      AppMethodBeat.o(223550);
      return;
    }
    b.a(this.iRJ, false);
    b.d(this.iRJ).stopTimer();
    h.RTc.aX(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(223548);
        Log.i("MicroMsg.CdnTransportService", "appForegroundListener onAppBackground");
        b.b(b.6.this.iRJ);
        Iterator localIterator = b.c(b.6.this.iRJ).entrySet().iterator();
        if (localIterator.hasNext())
        {
          Object localObject = (Map.Entry)localIterator.next();
          localObject = (b.a)b.c(b.6.this.iRJ).remove(((Map.Entry)localObject).getKey());
          if (localObject != null) {}
          for (localObject = ((b.a)localObject).toString();; localObject = "null")
          {
            Log.i("MicroMsg.CdnTransportService", "remove %s", new Object[] { localObject });
            break;
          }
        }
        AppMethodBeat.o(223548);
      }
    });
    AppMethodBeat.o(223550);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(223549);
    Log.i("MicroMsg.CdnTransportService", "onAppForeground %s", new Object[] { paramString });
    if (!b.baJ())
    {
      AppMethodBeat.o(223549);
      return;
    }
    b.a(this.iRJ, true);
    b.c(this.iRJ).clear();
    b.d(this.iRJ).startTimer(60000L);
    AppMethodBeat.o(223549);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.an.b.6
 * JD-Core Version:    0.7.0.1
 */