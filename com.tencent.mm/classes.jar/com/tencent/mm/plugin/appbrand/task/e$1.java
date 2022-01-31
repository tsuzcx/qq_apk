package com.tencent.mm.plugin.appbrand.task;

import android.os.SystemClock;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.i.y;
import com.tencent.mm.plugin.appbrand.x;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class e$1
  implements Runnable
{
  e$1(g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(132790);
    try
    {
      e.aLO().startTime = SystemClock.elapsedRealtime();
      ab.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "preInit start");
      al.Nf(-2);
      try
      {
        WxaCommLibRuntimeReader.ph();
        y.aAM();
        if (this.gSx == g.iKT)
        {
          e.access$200();
          e.access$300();
          ab.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "[wagame] misc preload done");
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        ab.e("MicroMsg.AppBrandProcessPreloader[applaunch]", "skip preload runtime, load CommLib get exception %s", new Object[] { Log.getStackTraceString(localThrowable) });
        e.access$100();
        return;
      }
      e.BI();
      if (x.aul())
      {
        e.aLP();
        ab.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "webview already init done");
        return;
      }
      x.a(new e.1.1(this, System.currentTimeMillis()));
      return;
    }
    finally
    {
      ab.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "misc preload done");
      al.Nf(10);
      AppMethodBeat.o(132790);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.e.1
 * JD-Core Version:    0.7.0.1
 */