package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av.a;

final class AppBrandRuntime$10
  implements av.a
{
  AppBrandRuntime$10(AppBrandRuntime paramAppBrandRuntime) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(134452);
    ad.i("MicroMsg.AppBrandRuntime", "onResourcePrepareTimeout appId[%s]", new Object[] { this.jxm.mAppId });
    this.jxm.aVY();
    AppMethodBeat.o(134452);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntime.10
 * JD-Core Version:    0.7.0.1
 */