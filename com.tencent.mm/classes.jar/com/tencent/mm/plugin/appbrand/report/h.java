package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.e.a;
import com.tencent.mm.plugin.performance.watchdogs.c.a;
import kotlin.l;
import kotlin.n.n;
import org.xwalk.core.XWalkEnvironment;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandMemoryWatchDogReporter;", "Lcom/tencent/mm/plugin/performance/watchdogs/MemoryWatchDog$IExtraMemoryInfoFactory;", "()V", "extra", "", "extra1", "extra2", "extra3", "extra4", "plugin-appbrand-integration_release"})
public final class h
  implements c.a
{
  public static final h qJl;
  
  static
  {
    AppMethodBeat.i(278567);
    qJl = new h();
    AppMethodBeat.o(278567);
  }
  
  public final String chA()
  {
    AppMethodBeat.i(278565);
    Object localObject = a.oce;
    localObject = a.bLO();
    AppMethodBeat.o(278565);
    return localObject;
  }
  
  public final String chB()
  {
    AppMethodBeat.i(278566);
    Object localObject = a.oce;
    localObject = n.l(a.bLP(), ",", " ", true);
    AppMethodBeat.o(278566);
    return localObject;
  }
  
  public final String chx()
  {
    AppMethodBeat.i(278562);
    Object localObject = a.oce;
    localObject = a.bLQ();
    AppMethodBeat.o(278562);
    return localObject;
  }
  
  public final String chy()
  {
    AppMethodBeat.i(278563);
    int i = XWalkEnvironment.getAvailableVersion();
    AppMethodBeat.o(278563);
    return String.valueOf(i);
  }
  
  public final String chz()
  {
    AppMethodBeat.i(278564);
    Object localObject = WxaCommLibRuntimeReader.bHd();
    if (localObject != null)
    {
      String str = ((ICommLibReader)localObject).bGg();
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "unknown";
    }
    AppMethodBeat.o(278564);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.h
 * JD-Core Version:    0.7.0.1
 */