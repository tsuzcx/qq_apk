package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.jsapi.t;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bg.a;

public final class d
{
  public c jOV;
  public bg.a mnW;
  
  public d()
  {
    AppMethodBeat.i(135348);
    this.mnW = new bg.a()
    {
      public final void Q(String paramAnonymousString, long paramAnonymousLong)
      {
        AppMethodBeat.i(193524);
        ac.i("MicroMsg.AppBrandUserCaptureScreenMonitor", "onScreenShot callback");
        paramAnonymousString = d.this.jOV;
        ac.i("MicroMsg.AppBrandOnUserCaptureScreenEvent", "user capture screen event dispatch, appId:%s", new Object[] { paramAnonymousString.getAppId() });
        new t().g(paramAnonymousString).beN();
        AppMethodBeat.o(193524);
      }
    };
    AppMethodBeat.o(135348);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.d
 * JD-Core Version:    0.7.0.1
 */