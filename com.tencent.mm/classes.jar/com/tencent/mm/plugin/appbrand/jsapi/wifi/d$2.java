package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ad;

final class d$2
  extends g.c
{
  d$2(d paramd, Context paramContext, c paramc) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(144690);
    if (d.lwj != null) {
      ad.i("MicroMsg.JsApiStartWifi", "unregisterReceiver");
    }
    try
    {
      this.lwd.unregisterReceiver(d.lwj);
      d.lwi = false;
      d.lwj = null;
      g.b(this.cnJ.getAppId(), this);
      AppMethodBeat.o(144690);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.JsApiStartWifi", localException, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.d.2
 * JD-Core Version:    0.7.0.1
 */