package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;

final class d$2
  extends e.c
{
  d$2(d paramd, Context paramContext, c paramc) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(94375);
    if (d.ihA != null) {
      ab.i("MicroMsg.JsApiStartWifi", "unregisterReceiver");
    }
    try
    {
      this.ihC.unregisterReceiver(d.ihA);
      d.ihz = false;
      d.ihA = null;
      e.b(this.hxW.getAppId(), this);
      AppMethodBeat.o(94375);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.JsApiStartWifi", localException, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.d.2
 * JD-Core Version:    0.7.0.1
 */