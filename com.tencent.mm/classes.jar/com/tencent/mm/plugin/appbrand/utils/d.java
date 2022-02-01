package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.jsapi.t;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bh.a;

public final class d
{
  public c kjg;
  public bh.a mOy;
  
  public d()
  {
    AppMethodBeat.i(135348);
    this.mOy = new bh.a()
    {
      public final void X(String paramAnonymousString, long paramAnonymousLong)
      {
        AppMethodBeat.i(197445);
        ad.i("MicroMsg.AppBrandUserCaptureScreenMonitor", "onScreenShot callback");
        paramAnonymousString = d.this.kjg;
        ad.i("MicroMsg.AppBrandOnUserCaptureScreenEvent", "user capture screen event dispatch, appId:%s", new Object[] { paramAnonymousString.getAppId() });
        new t().g(paramAnonymousString).bir();
        AppMethodBeat.o(197445);
      }
    };
    AppMethodBeat.o(135348);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.d
 * JD-Core Version:    0.7.0.1
 */