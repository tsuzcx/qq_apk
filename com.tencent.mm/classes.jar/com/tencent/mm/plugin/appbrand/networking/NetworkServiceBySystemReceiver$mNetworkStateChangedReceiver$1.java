package com.tencent.mm.plugin.appbrand.networking;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/networking/NetworkServiceBySystemReceiver$mNetworkStateChangedReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "luggage-wxa-app_release"})
public final class NetworkServiceBySystemReceiver$mNetworkStateChangedReceiver$1
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(135581);
    p.h(paramContext, "context");
    p.h(paramIntent, "intent");
    f.a(this.njC);
    AppMethodBeat.o(135581);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.networking.NetworkServiceBySystemReceiver.mNetworkStateChangedReceiver.1
 * JD-Core Version:    0.7.0.1
 */