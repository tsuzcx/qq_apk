package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.a.a.a;
import com.tencent.mm.plugin.appbrand.config.a.a.b;
import com.tencent.mm.sdk.platformtools.ab;

final class o$7
  implements a.a
{
  o$7(o paramo, i.c paramc) {}
  
  public final void a(a.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(128992);
    ab.i("MicroMsg.AppBrandRuntimeWC", "startPrepareOrientation, onOrientationChanged appId[%s], orientation[%s] success[%b]", new Object[] { this.gRv.mAppId, paramb, Boolean.valueOf(paramBoolean) });
    this.gRx.tT();
    AppMethodBeat.o(128992);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.7
 * JD-Core Version:    0.7.0.1
 */