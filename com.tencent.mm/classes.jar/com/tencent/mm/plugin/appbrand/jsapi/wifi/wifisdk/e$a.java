package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

final class e$a
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(204981);
    ac.i("MicroMsg.WiFiManagerWrapper", "onReceive");
    if ((paramIntent == null) || (!"android.net.wifi.SCAN_RESULTS".equals(paramIntent.getAction())))
    {
      ac.w("MicroMsg.WiFiManagerWrapper", "onReceive, action not match");
      AppMethodBeat.o(204981);
      return;
    }
    paramContext = e.blI();
    if (paramContext == null)
    {
      ac.i("MicroMsg.WiFiManagerWrapper", "onReceive, getWiFiListCallback is null");
      AppMethodBeat.o(204981);
      return;
    }
    paramContext.a(e.blJ());
    AppMethodBeat.o(204981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.e.a
 * JD-Core Version:    0.7.0.1
 */