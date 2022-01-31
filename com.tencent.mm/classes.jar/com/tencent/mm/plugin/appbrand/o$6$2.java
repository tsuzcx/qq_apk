package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class o$6$2
  implements Runnable
{
  o$6$2(o.6 param6) {}
  
  public final void run()
  {
    AppMethodBeat.i(128984);
    ab.i("MicroMsg.AppBrandRuntimeWC", "AppBrandPrepareTask done. runOnUiThread appId = %s, finished[%B]", new Object[] { this.gRA.gRv.mAppId, Boolean.valueOf(this.gRA.gRv.mFinished) });
    if (this.gRA.gRv.mFinished)
    {
      AppMethodBeat.o(128984);
      return;
    }
    j localj = o.l(this.gRA.gRv);
    if (!localj.gQo) {
      localj.tT();
    }
    o.d(this.gRA.gRv, this.gRA.gRx);
    o.m(this.gRA.gRv);
    AppMethodBeat.o(128984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.6.2
 * JD-Core Version:    0.7.0.1
 */