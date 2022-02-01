package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.threadpool.i.d;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandCgiPrefetchApi$AppBrandCgiPrefetchPullResultTask;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandCgiPrefetchApi$PullPrefetchResultReq;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandCgiPrefetchedResp;", "()V", "invoke", "req", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandCgiPrefetchApi$a
  implements m<AppBrandCgiPrefetchApi.PullPrefetchResultReq, AppBrandCgiPrefetchedResp>
{
  private static AppBrandCgiPrefetchedResp a(AppBrandCgiPrefetchApi.PullPrefetchResultReq paramPullPrefetchResultReq)
  {
    AppMethodBeat.i(320676);
    if (paramPullPrefetchResultReq != null)
    {
      paramPullPrefetchResultReq = b.sVC.aB(paramPullPrefetchResultReq.sVB, paramPullPrefetchResultReq.eup);
      if (paramPullPrefetchResultReq == null) {}
    }
    try
    {
      paramPullPrefetchResultReq = (AppBrandCgiPrefetchedResp)paramPullPrefetchResultReq.sVE.get();
      AppMethodBeat.o(320676);
      return paramPullPrefetchResultReq;
    }
    catch (InterruptedException paramPullPrefetchResultReq)
    {
      AppMethodBeat.o(320676);
      return null;
    }
    catch (CancellationException paramPullPrefetchResultReq)
    {
      label49:
      break label49;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandCgiPrefetchApi.a
 * JD-Core Version:    0.7.0.1
 */