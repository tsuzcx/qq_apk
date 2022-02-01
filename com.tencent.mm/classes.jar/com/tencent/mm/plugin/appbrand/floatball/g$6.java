package com.tencent.mm.plugin.appbrand.floatball;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.openvoice.AppBrandVoIP1v1FloatBallEvent;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.Log;

final class g$6
  implements com.tencent.mm.plugin.ball.c.e
{
  public final void b(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(226582);
    g.f(paramBallInfo);
    AppMethodBeat.o(226582);
  }
  
  public final void c(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(226583);
    if ((paramBallInfo != null) && (paramBallInfo.type == 19))
    {
      Log.i("MicroMsg.AppBrand.AppBrandVoIP1v1FloatBallHelper", "handleBallInfoClicked, appbrand voip float ball");
      paramBallInfo = paramBallInfo.jkf.getString("appId");
      AppBrandVoIP1v1FloatBallEvent localAppBrandVoIP1v1FloatBallEvent = new AppBrandVoIP1v1FloatBallEvent();
      localAppBrandVoIP1v1FloatBallEvent.dRq = 1;
      com.tencent.mm.plugin.appbrand.ipc.e.b(paramBallInfo, localAppBrandVoIP1v1FloatBallEvent);
    }
    AppMethodBeat.o(226583);
  }
  
  public final void d(BallInfo paramBallInfo) {}
  
  public final void g(BallInfo paramBallInfo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.floatball.g.6
 * JD-Core Version:    0.7.0.1
 */