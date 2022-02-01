package com.tencent.mm.plugin.appbrand.networking;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/networking/NetworkServiceBySystemReceiver$mNetworkStateChangedReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "luggage-wxa-app_release"})
public final class NetworkServiceBySystemReceiver$mNetworkStateChangedReceiver$1
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(135581);
    p.h(paramContext, "context");
    p.h(paramIntent, "intent");
    e.a(this.lXk);
    AppMethodBeat.o(135581);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.networking.NetworkServiceBySystemReceiver.mNetworkStateChangedReceiver.1
 * JD-Core Version:    0.7.0.1
 */