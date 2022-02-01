package com.tencent.mm.plugin.appbrand.launching.d;

import com.tencent.luggage.sdk.e.b;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/AppBrandParallelTasksCollectionWC;", "Lcom/tencent/luggage/sdk/tasks/AppBrandParallelTasksCollection;", "()V", "reportAll", "", "qualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "Companion", "plugin-appbrand-integration_release"})
public final class c
  extends b
{
  public static final a mYA;
  
  static
  {
    AppMethodBeat.i(228749);
    mYA = new a((byte)0);
    AppMethodBeat.o(228749);
  }
  
  public static final g a(b paramb)
  {
    AppMethodBeat.i(228750);
    p.h(paramb, "parallelTasksCollection");
    com.tencent.luggage.sdk.e.a locala = (com.tencent.luggage.sdk.e.a)paramb.cCy.get(Integer.valueOf(0));
    if (locala == null) {
      paramb = null;
    }
    while (paramb == null)
    {
      Log.w("MicroMsg.AppBrand.AppBrandParallelTaskCollection", "getLaunchTask: ret == null!");
      AppMethodBeat.o(228750);
      return null;
      paramb = locala;
      if (locala == null)
      {
        paramb = new t("null cannot be cast to non-null type com.tencent.luggage.sdk.tasks.AppBrandBasePreFetchTask<T>");
        AppMethodBeat.o(228750);
        throw paramb;
      }
    }
    paramb = (g)paramb;
    AppMethodBeat.o(228750);
    return paramb;
  }
  
  public final void c(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(228748);
    p.h(paramQualitySession, "qualitySession");
    Iterator localIterator = ((Map)this.cCy).entrySet().iterator();
    while (localIterator.hasNext())
    {
      com.tencent.luggage.sdk.e.a locala = (com.tencent.luggage.sdk.e.a)((Map.Entry)localIterator.next()).getValue();
      if (locala.OZ()) {
        if (locala == null) {
          try
          {
            t localt = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.launching.parallel.AppBrandBasePreFetchTaskWC<*>");
            AppMethodBeat.o(228748);
            throw localt;
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.AppBrand.AppBrandParallelTaskCollection", "reportAll:report #" + locala.OY() + " task fail %s", new Object[] { localException.getMessage() });
          }
        } else {
          ((a)locala).b(paramQualitySession);
        }
      }
    }
    AppMethodBeat.o(228748);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/AppBrandParallelTasksCollectionWC$Companion;", "", "()V", "TAG", "", "TASK_KEY_DOWNLOAD_INFO", "", "TASK_KEY_LAUNCH", "TASK_KEY_PRE_RETRIEVE_LAUNCH_PRAMS", "getLaunchTask", "Lcom/tencent/mm/plugin/appbrand/launching/parallel/PreFetchLaunchTask;", "parallelTasksCollection", "Lcom/tencent/luggage/sdk/tasks/AppBrandParallelTasksCollection;", "getPreGetPkgDownloadInfo", "Lcom/tencent/mm/plugin/appbrand/launching/parallel/PreFetchGetDownloadInfoTask;", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.d.c
 * JD-Core Version:    0.7.0.1
 */