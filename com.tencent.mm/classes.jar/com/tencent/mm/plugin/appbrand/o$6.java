package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.version.a;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.b;
import com.tencent.mm.plugin.appbrand.task.e.b;
import com.tencent.mm.sdk.platformtools.ab;

final class o$6
  implements AppBrandPrepareTask.b<AppBrandSysConfigWC>
{
  o$6(o paramo, long paramLong, i.c paramc) {}
  
  public final void a(a parama)
  {
    AppMethodBeat.i(128990);
    this.gRv.z(new o.6.3(this, parama));
    AppMethodBeat.o(128990);
  }
  
  public final void aub()
  {
    AppMethodBeat.i(128987);
    if (this.gRv.mFinished)
    {
      AppMethodBeat.o(128987);
      return;
    }
    j localj = o.l(this.gRv);
    if (localj != null) {
      localj.a(e.b.iKo);
    }
    AppMethodBeat.o(128987);
  }
  
  public final void ho(long paramLong)
  {
    AppMethodBeat.i(128988);
    if (this.gRv.mFinished)
    {
      AppMethodBeat.o(128988);
      return;
    }
    this.gRv.gRo = true;
    if (o.n(this.gRv) != null) {
      o.n(this.gRv).iHJ = true;
    }
    o.dE(this.gRv.gRo);
    j localj = o.l(this.gRv);
    if (localj != null) {
      localj.a(e.b.iKp);
    }
    AppMethodBeat.o(128988);
  }
  
  public final void ng(int paramInt)
  {
    AppMethodBeat.i(128986);
    this.gRv.ng(paramInt);
    AppMethodBeat.o(128986);
  }
  
  public final void nh(int paramInt)
  {
    AppMethodBeat.i(128989);
    ab.i("MicroMsg.AppBrandRuntimeWC", "appId[%s] onDownloadProgress %d", new Object[] { this.gRv.mAppId, Integer.valueOf(paramInt) });
    o localo = this.gRv;
    localo.k(new i.9(localo, paramInt), 0L);
    AppMethodBeat.o(128989);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.6
 * JD-Core Version:    0.7.0.1
 */