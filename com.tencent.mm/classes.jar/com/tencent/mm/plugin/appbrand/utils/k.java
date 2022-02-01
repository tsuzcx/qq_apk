package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.jsapi.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil.ScreenShotCallback;

public final class k
{
  public f rot;
  public ScreenShotUtil.ScreenShotCallback uqE;
  
  public k()
  {
    AppMethodBeat.i(135348);
    this.uqE = new ScreenShotUtil.ScreenShotCallback()
    {
      public final void onScreenShot(String paramAnonymousString, long paramAnonymousLong)
      {
        AppMethodBeat.i(317470);
        Log.i("MicroMsg.AppBrandUserCaptureScreenMonitor", "onScreenShot callback");
        paramAnonymousString = k.this.rot;
        Log.i("MicroMsg.AppBrandOnUserCaptureScreenEvent", "user capture screen event dispatch, appId:%s", new Object[] { paramAnonymousString.getAppId() });
        new x().h(paramAnonymousString).cpV();
        AppMethodBeat.o(317470);
      }
    };
    AppMethodBeat.o(135348);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.k
 * JD-Core Version:    0.7.0.1
 */