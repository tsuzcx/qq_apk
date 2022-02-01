package com.tencent.mm.plugin.appbrand.networking;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/networking/NetworkServiceBySystemReceiver;", "Lcom/tencent/mm/plugin/appbrand/networking/NetworkServiceImpl;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "TAG", "", "appContext", "Landroid/content/Context;", "getAppContext", "()Landroid/content/Context;", "mNetworkStateChangedReceiver", "com/tencent/mm/plugin/appbrand/networking/NetworkServiceBySystemReceiver$mNetworkStateChangedReceiver$1", "Lcom/tencent/mm/plugin/appbrand/networking/NetworkServiceBySystemReceiver$mNetworkStateChangedReceiver$1;", "onRegister", "", "onUnregister", "luggage-wxa-app_release"})
public final class f
  extends g
{
  private final String TAG;
  private final NetworkServiceBySystemReceiver.mNetworkStateChangedReceiver.1 mbQ;
  
  public f(AppBrandRuntime paramAppBrandRuntime)
  {
    super(paramAppBrandRuntime);
    AppMethodBeat.i(135584);
    this.TAG = "Luggage.WXA.NetworkServiceBySystemReceiver";
    this.mbQ = new NetworkServiceBySystemReceiver.mNetworkStateChangedReceiver.1(this);
    AppMethodBeat.o(135584);
  }
  
  private static Context getAppContext()
  {
    AppMethodBeat.i(176454);
    Context localContext = ak.getContext();
    if (localContext == null) {
      p.gkB();
    }
    AppMethodBeat.o(176454);
    return localContext;
  }
  
  public final void akM()
  {
    AppMethodBeat.i(135582);
    super.akM();
    try
    {
      Context localContext = getAppContext();
      BroadcastReceiver localBroadcastReceiver = (BroadcastReceiver)this.mbQ;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      localContext.registerReceiver(localBroadcastReceiver, localIntentFilter);
      AppMethodBeat.o(135582);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.e(this.TAG, "register network receiver, t=".concat(String.valueOf(localThrowable)));
      AppMethodBeat.o(135582);
    }
  }
  
  public final void akN()
  {
    AppMethodBeat.i(135583);
    super.akN();
    try
    {
      getAppContext().unregisterReceiver((BroadcastReceiver)this.mbQ);
      AppMethodBeat.o(135583);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.e(this.TAG, "unregister network receiver, t=".concat(String.valueOf(localThrowable)));
      AppMethodBeat.o(135583);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.networking.f
 * JD-Core Version:    0.7.0.1
 */