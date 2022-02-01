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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/parallel/AppBrandParallelTasksCollectionWC;", "Lcom/tencent/luggage/sdk/tasks/AppBrandParallelTasksCollection;", "()V", "reportAll", "", "qualitySession", "Lcom/tencent/mm/plugin/appbrand/report/quality/QualitySession;", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends b
{
  public static final c.a tdM;
  
  static
  {
    AppMethodBeat.i(321058);
    tdM = new c.a((byte)0);
    AppMethodBeat.o(321058);
  }
  
  public static final g a(b paramb)
  {
    AppMethodBeat.i(321055);
    s.u(paramb, "parallelTasksCollection");
    com.tencent.luggage.sdk.f.a locala = (com.tencent.luggage.sdk.f.a)paramb.evD.get(Integer.valueOf(0));
    paramb = locala;
    if (locala == null) {
      paramb = null;
    }
    if (paramb == null)
    {
      Log.w("MicroMsg.AppBrand.AppBrandParallelTaskCollection", "getLaunchTask: ret == null!");
      AppMethodBeat.o(321055);
      return null;
    }
    paramb = (g)paramb;
    AppMethodBeat.o(321055);
    return paramb;
  }
  
  public final void b(QualitySession paramQualitySession)
  {
    AppMethodBeat.i(321063);
    s.u(paramQualitySession, "qualitySession");
    Iterator localIterator = ((Map)this.evD).entrySet().iterator();
    while (localIterator.hasNext())
    {
      com.tencent.luggage.sdk.f.a locala = (com.tencent.luggage.sdk.f.a)((Map.Entry)localIterator.next()).getValue();
      if (locala.asN()) {
        try
        {
          ((a)locala).a(paramQualitySession);
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.AppBrand.AppBrandParallelTaskCollection", "reportAll:report #" + locala.asL() + " task fail %s", new Object[] { localException.getMessage() });
        }
      }
    }
    AppMethodBeat.o(321063);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.d.c
 * JD-Core Version:    0.7.0.1
 */