package com.tencent.mm.plugin.appbrand.networking;

import a.l;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/networking/NetworkServiceBySystemReceiver;", "Lcom/tencent/mm/plugin/appbrand/networking/NetworkServiceImpl;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "mNetworkStateChangedReceiver", "com/tencent/mm/plugin/appbrand/networking/NetworkServiceBySystemReceiver$mNetworkStateChangedReceiver$1", "Lcom/tencent/mm/plugin/appbrand/networking/NetworkServiceBySystemReceiver$mNetworkStateChangedReceiver$1;", "onRegister", "", "onUnregister", "luggage-wxa-app_release"})
public final class d
  extends e
{
  private final NetworkServiceBySystemReceiver.mNetworkStateChangedReceiver.1 itN;
  
  public d(i parami)
  {
    super(parami);
    AppMethodBeat.i(87583);
    this.itN = new NetworkServiceBySystemReceiver.mNetworkStateChangedReceiver.1(this);
    AppMethodBeat.o(87583);
  }
  
  public final void xM()
  {
    AppMethodBeat.i(87581);
    super.xM();
    Activity localActivity = this.gRG.getContext();
    BroadcastReceiver localBroadcastReceiver = (BroadcastReceiver)this.itN;
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    localActivity.registerReceiver(localBroadcastReceiver, localIntentFilter);
    AppMethodBeat.o(87581);
  }
  
  public final void xN()
  {
    AppMethodBeat.i(87582);
    super.xN();
    this.gRG.getContext().unregisterReceiver((BroadcastReceiver)this.itN);
    AppMethodBeat.o(87582);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.networking.d
 * JD-Core Version:    0.7.0.1
 */