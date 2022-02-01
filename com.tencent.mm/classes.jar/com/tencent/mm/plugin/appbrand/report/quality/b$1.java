package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.List;

public final class b$1
  implements Runnable
{
  public b$1(b paramb, String paramString, AppStartupPerformanceReportBundle paramAppStartupPerformanceReportBundle) {}
  
  public final void run()
  {
    AppMethodBeat.i(162165);
    QualitySessionRuntime localQualitySessionRuntime = a.ME(this.val$appId);
    if (localQualitySessionRuntime == null)
    {
      AppMethodBeat.o(162165);
      return;
    }
    Iterator localIterator = this.lsH.kHF.iterator();
    if (localIterator.hasNext())
    {
      kv_14609 localkv_14609 = (kv_14609)localIterator.next();
      com.tencent.mm.plugin.appbrand.jsapi.m.a locala = new com.tencent.mm.plugin.appbrand.jsapi.m.a();
      locala.setName("loadPackage");
      locala.startTime = localkv_14609.lsd;
      locala.endTime = (localkv_14609.lsd + localkv_14609.lrX);
      locala.t("packageName", bt.nullAsNil(localkv_14609.chK));
      if (localkv_14609.bgr()) {
        locala.t("size", Integer.valueOf(localkv_14609.lsc));
      }
      for (;;)
      {
        try
        {
          locala.c(localQualitySessionRuntime.joZ.aNe());
        }
        catch (Exception localException) {}
        break;
        locala.t("size", Integer.valueOf(localException.lsb));
      }
    }
    AppMethodBeat.o(162165);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.b.1
 * JD-Core Version:    0.7.0.1
 */