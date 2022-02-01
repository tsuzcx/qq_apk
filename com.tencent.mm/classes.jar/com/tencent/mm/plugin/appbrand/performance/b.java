package com.tencent.mm.plugin.appbrand.performance;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  extends AppBrandPerformanceManager
{
  public static void I(o paramo)
  {
    AppMethodBeat.i(47986);
    String str = paramo.mAppId;
    ad.d("MicroMsg.AppBrandPerformanceManagerWC", "startMonitoring, appId: %s", new Object[] { str });
    AppBrandPerformanceManager.a locala = (AppBrandPerformanceManager.a)lhz.get(str.hashCode());
    Object localObject = locala;
    if (!(locala instanceof b.a))
    {
      if (locala != null) {
        locala.stop();
      }
      localObject = new b.a(paramo);
      lhz.put(str.hashCode(), localObject);
    }
    ((AppBrandPerformanceManager.a)localObject).start();
    AppMethodBeat.o(47986);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.b
 * JD-Core Version:    0.7.0.1
 */