package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.jsapi.t;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bh.a;

public final class d
{
  public c joJ;
  public bh.a lLZ;
  
  public d()
  {
    AppMethodBeat.i(135348);
    this.lLZ = new bh.a()
    {
      public final void P(String paramAnonymousString, long paramAnonymousLong)
      {
        AppMethodBeat.i(194534);
        ad.i("MicroMsg.AppBrandUserCaptureScreenMonitor", "onScreenShot callback");
        paramAnonymousString = d.this.joJ;
        ad.i("MicroMsg.AppBrandOnUserCaptureScreenEvent", "user capture screen event dispatch, appId:%s", new Object[] { paramAnonymousString.getAppId() });
        new t().g(paramAnonymousString).aXQ();
        AppMethodBeat.o(194534);
      }
    };
    AppMethodBeat.o(135348);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.d
 * JD-Core Version:    0.7.0.1
 */