package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.u.a;
import com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;

public final class c$1
  implements Runnable
{
  public c$1(c paramc, String paramString, AppStartupPerformanceReportBundle paramAppStartupPerformanceReportBundle) {}
  
  public final void run()
  {
    AppMethodBeat.i(162165);
    QualitySessionRuntime localQualitySessionRuntime = b.afZ(this.etl);
    if (localQualitySessionRuntime == null)
    {
      AppMethodBeat.o(162165);
      return;
    }
    Iterator localIterator = this.tRs.sYv.iterator();
    if (localIterator.hasNext())
    {
      kv_14609 localkv_14609 = (kv_14609)localIterator.next();
      a locala = new a();
      locala.setName("loadPackage");
      locala.startTime = localkv_14609.tQF;
      locala.endTime = (localkv_14609.tQF + localkv_14609.tQz);
      locala.y("packageName", Util.nullAsNil(localkv_14609.esT));
      if (localkv_14609.czT()) {
        locala.y("size", Integer.valueOf(localkv_14609.tQE));
      }
      for (;;)
      {
        try
        {
          locala.q(localQualitySessionRuntime.qxC.ccO());
        }
        catch (Exception localException) {}
        break;
        locala.y("size", Integer.valueOf(localException.tQD));
      }
    }
    AppMethodBeat.o(162165);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.c.1
 * JD-Core Version:    0.7.0.1
 */