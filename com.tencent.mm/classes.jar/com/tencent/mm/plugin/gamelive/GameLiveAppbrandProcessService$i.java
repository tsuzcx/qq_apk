package com.tencent.mm.plugin.gamelive;

import android.content.Context;
import com.tencent.luggage.game.page.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.q;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.t;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
final class GameLiveAppbrandProcessService$i
  implements Runnable
{
  GameLiveAppbrandProcessService$i(t paramt, Context paramContext, String paramString, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(208157);
    c localc = this.DjL.bDA();
    p.j(localc, "appbrandRuntime.service");
    ((q)localc.getJsRuntime().Q(q.class)).post((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(208556);
        Object localObject = this.DjM.DjL.bDv();
        if (localObject != null) {}
        for (localObject = (d)((ah)localObject).R(d.class);; localObject = null)
        {
          if (localObject != null) {
            ((d)localObject).j(false, true);
          }
          a.a(this.DjM.$context, (AppBrandProxyUIProcessTask.ProcessRequest)new GameLiveAppbrandProcessService.EnterFinderLiveRequest(this.DjM.cBD, this.DjM.nKm, GameLiveAppbrandProcessService.c.Djx.ordinal(), 0, 8), (AppBrandProxyUIProcessTask.b)1.DjN);
          AppMethodBeat.o(208556);
          return;
        }
      }
    });
    AppMethodBeat.o(208157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelive.GameLiveAppbrandProcessService.i
 * JD-Core Version:    0.7.0.1
 */