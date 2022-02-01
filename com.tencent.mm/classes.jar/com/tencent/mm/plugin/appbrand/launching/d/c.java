package com.tencent.mm.plugin.appbrand.launching.d;

import com.tencent.luggage.sdk.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import d.v;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/AppBrandParallelTasksCollectionWC;", "Lcom/tencent/luggage/sdk/tasks/AppBrandParallelTasksCollection;", "()V", "reportAll", "", "qualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "Companion", "plugin-appbrand-integration_release"})
public final class c
  extends b
{
  public static final a kNZ;
  
  static
  {
    AppMethodBeat.i(196399);
    kNZ = new a((byte)0);
    AppMethodBeat.o(196399);
  }
  
  public static final g a(b paramb)
  {
    AppMethodBeat.i(196400);
    k.h(paramb, "parallelTasksCollection");
    com.tencent.luggage.sdk.e.a locala = (com.tencent.luggage.sdk.e.a)paramb.ciq.get(Integer.valueOf(0));
    if (locala == null) {
      paramb = null;
    }
    while (paramb == null)
    {
      ad.w("MicroMsg.AppBrand.AppBrandParallelTaskCollection", "getLaunchTask: ret == null!");
      AppMethodBeat.o(196400);
      return null;
      paramb = locala;
      if (locala == null)
      {
        paramb = new v("null cannot be cast to non-null type com.tencent.luggage.sdk.tasks.AppBrandBasePreFetchTask<T>");
        AppMethodBeat.o(196400);
        throw paramb;
      }
    }
    paramb = (g)paramb;
    AppMethodBeat.o(196400);
    return paramb;
  }
  
  public final void d(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(196398);
    k.h(paramQualitySession, "qualitySession");
    Iterator localIterator = ((Map)this.ciq).entrySet().iterator();
    while (localIterator.hasNext())
    {
      com.tencent.luggage.sdk.e.a locala = (com.tencent.luggage.sdk.e.a)((Map.Entry)localIterator.next()).getValue();
      if (locala.Ej()) {
        if (locala == null) {
          try
          {
            v localv = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.launching.parallel.AppBrandBasePreFetchTaskWC<out kotlin.Any?>");
            AppMethodBeat.o(196398);
            throw localv;
          }
          catch (Exception localException)
          {
            ad.e("MicroMsg.AppBrand.AppBrandParallelTaskCollection", "reportAll:report #" + locala.Ei() + " task fail %s", new Object[] { localException.getMessage() });
          }
        } else {
          ((a)locala).c(paramQualitySession);
        }
      }
    }
    AppMethodBeat.o(196398);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/AppBrandParallelTasksCollectionWC$Companion;", "", "()V", "TAG", "", "TASK_KEY_DOWNLOAD_INFO", "", "TASK_KEY_LAUNCH", "TASK_KEY_PRE_RETRIEVE_LAUNCH_PRAMS", "getLaunchTask", "Lcom/tencent/mm/plugin/appbrand/launching/parallel/PreFetchLaunchTask;", "parallelTasksCollection", "Lcom/tencent/luggage/sdk/tasks/AppBrandParallelTasksCollection;", "getPreGetPkgDownloadInfo", "Lcom/tencent/mm/plugin/appbrand/launching/parallel/PreFetchGetDownloadInfoTask;", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static f b(b paramb)
    {
      AppMethodBeat.i(196397);
      k.h(paramb, "parallelTasksCollection");
      com.tencent.luggage.sdk.e.a locala = (com.tencent.luggage.sdk.e.a)paramb.ciq.get(Integer.valueOf(1));
      if (locala == null) {
        paramb = null;
      }
      while (paramb == null)
      {
        ad.w("MicroMsg.AppBrand.AppBrandParallelTaskCollection", "getPreGetPkgDownloadInfo: ret == null!");
        AppMethodBeat.o(196397);
        return null;
        paramb = locala;
        if (locala == null)
        {
          paramb = new v("null cannot be cast to non-null type com.tencent.luggage.sdk.tasks.AppBrandBasePreFetchTask<T>");
          AppMethodBeat.o(196397);
          throw paramb;
        }
      }
      paramb = (f)paramb;
      AppMethodBeat.o(196397);
      return paramb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.d.c
 * JD-Core Version:    0.7.0.1
 */