package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.o;

final class a$1
  extends e.c
{
  a$1(o paramo) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(132675);
    d.i("MicroMsg.AppBrandQualitySystem", "[QualitySystem] closeSession appId = [%s] runtime.hashCode = [%d]", new Object[] { this.gOJ.mAppId, Integer.valueOf(this.gOJ.hashCode()) });
    a.r(this.gOJ);
    AppMethodBeat.o(132675);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.a.1
 * JD-Core Version:    0.7.0.1
 */