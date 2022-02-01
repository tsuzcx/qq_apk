package com.tencent.mm.plugin.appbrand.performance;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends AppBrandPerformanceManager
{
  public static void P(w paramw)
  {
    AppMethodBeat.i(47986);
    String str = paramw.mAppId;
    Log.d("MicroMsg.AppBrandPerformanceManagerWC", "startMonitoring, appId: %s", new Object[] { str });
    AppBrandPerformanceManager.a locala = (AppBrandPerformanceManager.a)tDz.get(str.hashCode());
    Object localObject = locala;
    if (!(locala instanceof b.b))
    {
      if (locala != null) {
        locala.stop();
      }
      localObject = new b.b(paramw);
      tDz.put(str.hashCode(), localObject);
    }
    ((AppBrandPerformanceManager.a)localObject).start();
    AppMethodBeat.o(47986);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.performance.b
 * JD-Core Version:    0.7.0.1
 */