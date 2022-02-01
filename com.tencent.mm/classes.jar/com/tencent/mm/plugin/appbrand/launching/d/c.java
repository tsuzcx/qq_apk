package com.tencent.mm.plugin.appbrand.launching.d;

import com.tencent.luggage.sdk.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import d.v;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/AppBrandParallelTasksCollectionWC;", "Lcom/tencent/luggage/sdk/tasks/AppBrandParallelTasksCollection;", "()V", "reportAll", "", "qualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "Companion", "plugin-appbrand-integration_release"})
public final class c
  extends b
{
  public static final a lpy;
  
  static
  {
    AppMethodBeat.i(187337);
    lpy = new a((byte)0);
    AppMethodBeat.o(187337);
  }
  
  public static final g a(b paramb)
  {
    AppMethodBeat.i(187338);
    k.h(paramb, "parallelTasksCollection");
    com.tencent.luggage.sdk.e.a locala = (com.tencent.luggage.sdk.e.a)paramb.cfm.get(Integer.valueOf(0));
    if (locala == null) {
      paramb = null;
    }
    while (paramb == null)
    {
      ac.w("MicroMsg.AppBrand.AppBrandParallelTaskCollection", "getLaunchTask: ret == null!");
      AppMethodBeat.o(187338);
      return null;
      paramb = locala;
      if (locala == null)
      {
        paramb = new v("null cannot be cast to non-null type com.tencent.luggage.sdk.tasks.AppBrandBasePreFetchTask<T>");
        AppMethodBeat.o(187338);
        throw paramb;
      }
    }
    paramb = (g)paramb;
    AppMethodBeat.o(187338);
    return paramb;
  }
  
  public final void d(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(187336);
    k.h(paramQualitySession, "qualitySession");
    Iterator localIterator = ((Map)this.cfm).entrySet().iterator();
    while (localIterator.hasNext())
    {
      com.tencent.luggage.sdk.e.a locala = (com.tencent.luggage.sdk.e.a)((Map.Entry)localIterator.next()).getValue();
      if (locala.DM()) {
        if (locala == null) {
          try
          {
            v localv = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.launching.parallel.AppBrandBasePreFetchTaskWC<out kotlin.Any?>");
            AppMethodBeat.o(187336);
            throw localv;
          }
          catch (Exception localException)
          {
            ac.e("MicroMsg.AppBrand.AppBrandParallelTaskCollection", "reportAll:report #" + locala.DL() + " task fail %s", new Object[] { localException.getMessage() });
          }
        } else {
          ((a)locala).c(paramQualitySession);
        }
      }
    }
    AppMethodBeat.o(187336);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/AppBrandParallelTasksCollectionWC$Companion;", "", "()V", "TAG", "", "TASK_KEY_DOWNLOAD_INFO", "", "TASK_KEY_LAUNCH", "TASK_KEY_PRE_RETRIEVE_LAUNCH_PRAMS", "getLaunchTask", "Lcom/tencent/mm/plugin/appbrand/launching/parallel/PreFetchLaunchTask;", "parallelTasksCollection", "Lcom/tencent/luggage/sdk/tasks/AppBrandParallelTasksCollection;", "getPreGetPkgDownloadInfo", "Lcom/tencent/mm/plugin/appbrand/launching/parallel/PreFetchGetDownloadInfoTask;", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static f b(b paramb)
    {
      AppMethodBeat.i(187335);
      k.h(paramb, "parallelTasksCollection");
      com.tencent.luggage.sdk.e.a locala = (com.tencent.luggage.sdk.e.a)paramb.cfm.get(Integer.valueOf(1));
      if (locala == null) {
        paramb = null;
      }
      while (paramb == null)
      {
        ac.w("MicroMsg.AppBrand.AppBrandParallelTaskCollection", "getPreGetPkgDownloadInfo: ret == null!");
        AppMethodBeat.o(187335);
        return null;
        paramb = locala;
        if (locala == null)
        {
          paramb = new v("null cannot be cast to non-null type com.tencent.luggage.sdk.tasks.AppBrandBasePreFetchTask<T>");
          AppMethodBeat.o(187335);
          throw paramb;
        }
      }
      paramb = (f)paramb;
      AppMethodBeat.o(187335);
      return paramb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.d.c
 * JD-Core Version:    0.7.0.1
 */