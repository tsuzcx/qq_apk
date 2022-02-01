package com.tencent.mm.plugin.appbrand.networking;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/networking/NetworkServiceBySystemReceiver$mNetworkStateChangedReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class NetworkServiceBySystemReceiver$mNetworkStateChangedReceiver$1
  extends BroadcastReceiver
{
  NetworkServiceBySystemReceiver$mNetworkStateChangedReceiver$1(f paramf) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(135581);
    s.u(paramContext, "context");
    s.u(paramIntent, "intent");
    f.a(this.tpX);
    AppMethodBeat.o(135581);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.networking.NetworkServiceBySystemReceiver.mNetworkStateChangedReceiver.1
 * JD-Core Version:    0.7.0.1
 */