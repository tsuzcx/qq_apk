package com.tencent.mm.plugin.appbrand.launching.d;

import com.tencent.luggage.sdk.f.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/AppBrandParallelTasksCollectionWC;", "Lcom/tencent/luggage/sdk/tasks/AppBrandParallelTasksCollection;", "()V", "reportAll", "", "qualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "Companion", "plugin-appbrand-integration_release"})
public final class c
  extends b
{
  public static final a pYZ;
  
  static
  {
    AppMethodBeat.i(243262);
    pYZ = new a((byte)0);
    AppMethodBeat.o(243262);
  }
  
  public static final g a(b paramb)
  {
    AppMethodBeat.i(243263);
    p.k(paramb, "parallelTasksCollection");
    com.tencent.luggage.sdk.f.a locala = (com.tencent.luggage.sdk.f.a)paramb.cDb.get(Integer.valueOf(0));
    if (locala == null) {
      paramb = null;
    }
    while (paramb == null)
    {
      Log.w("MicroMsg.AppBrand.AppBrandParallelTaskCollection", "getLaunchTask: ret == null!");
      AppMethodBeat.o(243263);
      return null;
      paramb = locala;
      if (locala == null)
      {
        paramb = new t("null cannot be cast to non-null type com.tencent.luggage.sdk.tasks.AppBrandBasePreFetchTask<T>");
        AppMethodBeat.o(243263);
        throw paramb;
      }
    }
    paramb = (g)paramb;
    AppMethodBeat.o(243263);
    return paramb;
  }
  
  public final void b(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(243261);
    p.k(paramQualitySession, "qualitySession");
    Iterator localIterator = ((Map)this.cDb).entrySet().iterator();
    while (localIterator.hasNext())
    {
      com.tencent.luggage.sdk.f.a locala = (com.tencent.luggage.sdk.f.a)((Map.Entry)localIterator.next()).getValue();
      if (locala.Sx()) {
        if (locala == null) {
          try
          {
            t localt = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.launching.parallel.AppBrandBasePreFetchTaskWC<*>");
            AppMethodBeat.o(243261);
            throw localt;
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.AppBrand.AppBrandParallelTaskCollection", "reportAll:report #" + locala.Sw() + " task fail %s", new Object[] { localException.getMessage() });
          }
        } else {
          ((a)locala).a(paramQualitySession);
        }
      }
    }
    AppMethodBeat.o(243261);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/AppBrandParallelTasksCollectionWC$Companion;", "", "()V", "TAG", "", "TASK_KEY_DOWNLOAD_INFO", "", "TASK_KEY_LAUNCH", "TASK_KEY_PRE_RETRIEVE_LAUNCH_PRAMS", "getLaunchTask", "Lcom/tencent/mm/plugin/appbrand/launching/parallel/PreFetchLaunchTask;", "parallelTasksCollection", "Lcom/tencent/luggage/sdk/tasks/AppBrandParallelTasksCollection;", "getPreGetPkgDownloadInfo", "Lcom/tencent/mm/plugin/appbrand/launching/parallel/PreFetchGetDownloadInfoTask;", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.d.c
 * JD-Core Version:    0.7.0.1
 */