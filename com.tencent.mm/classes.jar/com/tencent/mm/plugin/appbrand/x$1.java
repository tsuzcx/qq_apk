package com.tencent.mm.plugin.appbrand;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class x$1
  implements Runnable
{
  public final void run()
  {
    AppMethodBeat.i(129134);
    long l = bo.aoy();
    new n().init();
    ab.d("MicroMsg.AppBrandXWebPreloader", "x509 init cost %d", new Object[] { Long.valueOf(bo.aoy() - l) });
    x.access$000();
    Looper.myLooper().quit();
    AppMethodBeat.o(129134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.x.1
 * JD-Core Version:    0.7.0.1
 */