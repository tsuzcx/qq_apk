package com.tencent.mm.plugin.appbrand.networking;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/networking/NetworkServiceBySystemReceiver;", "Lcom/tencent/mm/plugin/appbrand/networking/NetworkServiceImpl;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "TAG", "", "appContext", "Landroid/content/Context;", "getAppContext", "()Landroid/content/Context;", "mNetworkStateChangedReceiver", "com/tencent/mm/plugin/appbrand/networking/NetworkServiceBySystemReceiver$mNetworkStateChangedReceiver$1", "Lcom/tencent/mm/plugin/appbrand/networking/NetworkServiceBySystemReceiver$mNetworkStateChangedReceiver$1;", "onRegister", "", "onUnregister", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends g
{
  private final String TAG;
  private final NetworkServiceBySystemReceiver.mNetworkStateChangedReceiver.1 tpW;
  
  public f(AppBrandRuntime paramAppBrandRuntime)
  {
    super(paramAppBrandRuntime);
    AppMethodBeat.i(135584);
    this.TAG = "Luggage.WXA.NetworkServiceBySystemReceiver";
    this.tpW = new NetworkServiceBySystemReceiver.mNetworkStateChangedReceiver.1(this);
    AppMethodBeat.o(135584);
  }
  
  public final void bbB()
  {
    AppMethodBeat.i(135582);
    super.bbB();
    try
    {
      Context localContext = MMApplicationContext.getContext();
      s.checkNotNull(localContext);
      BroadcastReceiver localBroadcastReceiver = (BroadcastReceiver)this.tpW;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      ah localah = ah.aiuX;
      localContext.registerReceiver(localBroadcastReceiver, localIntentFilter);
      AppMethodBeat.o(135582);
      return;
    }
    finally
    {
      Log.e(this.TAG, s.X("register network receiver, t=", localObject));
      AppMethodBeat.o(135582);
    }
  }
  
  public final void bbC()
  {
    AppMethodBeat.i(135583);
    super.bbC();
    try
    {
      Context localContext = MMApplicationContext.getContext();
      s.checkNotNull(localContext);
      localContext.unregisterReceiver((BroadcastReceiver)this.tpW);
      AppMethodBeat.o(135583);
      return;
    }
    finally
    {
      Log.e(this.TAG, s.X("unregister network receiver, t=", localObject));
      AppMethodBeat.o(135583);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.networking.f
 * JD-Core Version:    0.7.0.1
 */