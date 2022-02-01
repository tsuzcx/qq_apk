package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.jsapi.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil.ScreenShotCallback;

public final class e
{
  public f lqg;
  public ScreenShotUtil.ScreenShotCallback ogG;
  
  public e()
  {
    AppMethodBeat.i(135348);
    this.ogG = new ScreenShotUtil.ScreenShotCallback()
    {
      public final void onScreenShot(String paramAnonymousString, long paramAnonymousLong)
      {
        AppMethodBeat.i(219590);
        Log.i("MicroMsg.AppBrandUserCaptureScreenMonitor", "onScreenShot callback");
        paramAnonymousString = e.this.lqg;
        Log.i("MicroMsg.AppBrandOnUserCaptureScreenEvent", "user capture screen event dispatch, appId:%s", new Object[] { paramAnonymousString.getAppId() });
        new w().g(paramAnonymousString).bEo();
        AppMethodBeat.o(219590);
      }
    };
    AppMethodBeat.o(135348);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.e
 * JD-Core Version:    0.7.0.1
 */