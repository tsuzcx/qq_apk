package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;

final class d$2
  extends h.c
{
  d$2(d paramd, Context paramContext, f paramf) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(144690);
    if (d.mHV != null) {
      Log.i("MicroMsg.JsApiStartWifi", "unregisterReceiver");
    }
    try
    {
      this.mHP.unregisterReceiver(d.mHV);
      d.mHU = false;
      d.mHV = null;
      h.b(this.czN.getAppId(), this);
      AppMethodBeat.o(144690);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.JsApiStartWifi", localException, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.d.2
 * JD-Core Version:    0.7.0.1
 */