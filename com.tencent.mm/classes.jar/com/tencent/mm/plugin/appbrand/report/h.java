package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.crash_report.a;
import com.tencent.mm.plugin.performance.watchdogs.d.a;
import com.tencent.xweb.ao;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandMemoryWatchDogReporter;", "Lcom/tencent/mm/plugin/performance/watchdogs/MemoryWatchDog$IExtraMemoryInfoFactory;", "()V", "extra", "", "extra1", "extra2", "extra3", "extra4", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  implements d.a
{
  public static final h tNO;
  
  static
  {
    AppMethodBeat.i(321361);
    tNO = new h();
    AppMethodBeat.o(321361);
  }
  
  public final String cIr()
  {
    AppMethodBeat.i(321364);
    Object localObject = a.rcS;
    localObject = a.clq();
    AppMethodBeat.o(321364);
    return localObject;
  }
  
  public final String cIs()
  {
    AppMethodBeat.i(321366);
    String str = String.valueOf(ao.getAvailableVersion());
    Object localObject = a.rcS;
    localObject = str;
    if (a.clp() != 0) {
      localObject = s.X(str, "(skyline)");
    }
    AppMethodBeat.o(321366);
    return localObject;
  }
  
  public final String cIt()
  {
    AppMethodBeat.i(321369);
    Object localObject = WxaCommLibRuntimeReader.cgz();
    if (localObject == null)
    {
      AppMethodBeat.o(321369);
      return "unknown";
    }
    localObject = ((ICommLibReader)localObject).cfD();
    if (localObject == null)
    {
      AppMethodBeat.o(321369);
      return "unknown";
    }
    AppMethodBeat.o(321369);
    return localObject;
  }
  
  public final String cIu()
  {
    AppMethodBeat.i(321373);
    Object localObject = a.rcS;
    localObject = a.clm();
    AppMethodBeat.o(321373);
    return localObject;
  }
  
  public final String cIv()
  {
    AppMethodBeat.i(321378);
    Object localObject = a.rcS;
    localObject = n.m(a.clo(), ",", " ", true);
    AppMethodBeat.o(321378);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.h
 * JD-Core Version:    0.7.0.1
 */