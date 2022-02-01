package com.tencent.mm.plugin.appbrand.launching.d;

import com.tencent.luggage.sdk.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.v;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/AppBrandParallelTasksCollectionWC;", "Lcom/tencent/luggage/sdk/tasks/AppBrandParallelTasksCollection;", "()V", "reportAll", "", "qualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "Companion", "plugin-appbrand-integration_release"})
public final class c
  extends b
{
  public static final a lRr;
  
  static
  {
    AppMethodBeat.i(223588);
    lRr = new a((byte)0);
    AppMethodBeat.o(223588);
  }
  
  public static final g a(b paramb)
  {
    AppMethodBeat.i(223589);
    p.h(paramb, "parallelTasksCollection");
    com.tencent.luggage.sdk.e.a locala = (com.tencent.luggage.sdk.e.a)paramb.cqf.get(Integer.valueOf(0));
    if (locala == null) {
      paramb = null;
    }
    while (paramb == null)
    {
      ae.w("MicroMsg.AppBrand.AppBrandParallelTaskCollection", "getLaunchTask: ret == null!");
      AppMethodBeat.o(223589);
      return null;
      paramb = locala;
      if (locala == null)
      {
        paramb = new v("null cannot be cast to non-null type com.tencent.luggage.sdk.tasks.AppBrandBasePreFetchTask<T>");
        AppMethodBeat.o(223589);
        throw paramb;
      }
    }
    paramb = (g)paramb;
    AppMethodBeat.o(223589);
    return paramb;
  }
  
  public final void d(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(223587);
    p.h(paramQualitySession, "qualitySession");
    Iterator localIterator = ((Map)this.cqf).entrySet().iterator();
    while (localIterator.hasNext())
    {
      com.tencent.luggage.sdk.e.a locala = (com.tencent.luggage.sdk.e.a)((Map.Entry)localIterator.next()).getValue();
      if (locala.Fq()) {
        if (locala == null) {
          try
          {
            v localv = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.launching.parallel.AppBrandBasePreFetchTaskWC<*>");
            AppMethodBeat.o(223587);
            throw localv;
          }
          catch (Exception localException)
          {
            ae.e("MicroMsg.AppBrand.AppBrandParallelTaskCollection", "reportAll:report #" + locala.Fp() + " task fail %s", new Object[] { localException.getMessage() });
          }
        } else {
          ((a)locala).c(paramQualitySession);
        }
      }
    }
    AppMethodBeat.o(223587);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/AppBrandParallelTasksCollectionWC$Companion;", "", "()V", "TAG", "", "TASK_KEY_DOWNLOAD_INFO", "", "TASK_KEY_LAUNCH", "TASK_KEY_PRE_RETRIEVE_LAUNCH_PRAMS", "getLaunchTask", "Lcom/tencent/mm/plugin/appbrand/launching/parallel/PreFetchLaunchTask;", "parallelTasksCollection", "Lcom/tencent/luggage/sdk/tasks/AppBrandParallelTasksCollection;", "getPreGetPkgDownloadInfo", "Lcom/tencent/mm/plugin/appbrand/launching/parallel/PreFetchGetDownloadInfoTask;", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static f b(b paramb)
    {
      AppMethodBeat.i(223586);
      p.h(paramb, "parallelTasksCollection");
      com.tencent.luggage.sdk.e.a locala = (com.tencent.luggage.sdk.e.a)paramb.cqf.get(Integer.valueOf(1));
      if (locala == null) {
        paramb = null;
      }
      while (paramb == null)
      {
        ae.w("MicroMsg.AppBrand.AppBrandParallelTaskCollection", "getPreGetPkgDownloadInfo: ret == null!");
        AppMethodBeat.o(223586);
        return null;
        paramb = locala;
        if (locala == null)
        {
          paramb = new v("null cannot be cast to non-null type com.tencent.luggage.sdk.tasks.AppBrandBasePreFetchTask<T>");
          AppMethodBeat.o(223586);
          throw paramb;
        }
      }
      paramb = (f)paramb;
      AppMethodBeat.o(223586);
      return paramb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.d.c
 * JD-Core Version:    0.7.0.1
 */