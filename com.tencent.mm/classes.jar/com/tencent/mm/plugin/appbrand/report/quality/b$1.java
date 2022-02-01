package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.sdk.platformtools.Log;

final class b$1
  extends k.c
{
  b$1(t paramt) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(48184);
    Log.i("MicroMsg.AppBrandQualitySystem", "[QualitySystem] closeSession appId = [%s] runtime.hashCode = [%d]", new Object[] { this.nsw.mAppId, Integer.valueOf(this.nsw.hashCode()) });
    b.M(this.nsw);
    AppMethodBeat.o(48184);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.b.1
 * JD-Core Version:    0.7.0.1
 */