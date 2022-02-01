package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.jsapi.t;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bi.a;

public final class e
{
  public c kmw;
  public bi.a mTD;
  
  public e()
  {
    AppMethodBeat.i(135348);
    this.mTD = new bi.a()
    {
      public final void X(String paramAnonymousString, long paramAnonymousLong)
      {
        AppMethodBeat.i(207986);
        ae.i("MicroMsg.AppBrandUserCaptureScreenMonitor", "onScreenShot callback");
        paramAnonymousString = e.this.kmw;
        ae.i("MicroMsg.AppBrandOnUserCaptureScreenEvent", "user capture screen event dispatch, appId:%s", new Object[] { paramAnonymousString.getAppId() });
        new t().g(paramAnonymousString).bja();
        AppMethodBeat.o(207986);
      }
    };
    AppMethodBeat.o(135348);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.e
 * JD-Core Version:    0.7.0.1
 */