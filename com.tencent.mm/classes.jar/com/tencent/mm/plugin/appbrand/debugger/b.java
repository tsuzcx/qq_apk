package com.tencent.mm.plugin.appbrand.debugger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/debugger/DebuggerShellClientProcessHelper;", "", "()V", "ACTION_RELOAD_CONFIG", "", "TAG", "receiver", "com/tencent/mm/plugin/appbrand/debugger/DebuggerShellClientProcessHelper$receiver$1", "Lcom/tencent/mm/plugin/appbrand/debugger/DebuggerShellClientProcessHelper$receiver$1;", "beforeKillProcess", "", "notifyReloadConfigs", "setup", "plugin-appbrand-integration_release"})
public final class b
{
  private static final DebuggerShellClientProcessHelper.receiver.1 lhD;
  public static final b lhE;
  
  static
  {
    AppMethodBeat.i(228193);
    lhE = new b();
    lhD = new DebuggerShellClientProcessHelper.receiver.1();
    AppMethodBeat.o(228193);
  }
  
  public static final void bAD()
  {
    AppMethodBeat.i(228191);
    MMApplicationContext.getContext().unregisterReceiver((BroadcastReceiver)lhD);
    AppMethodBeat.o(228191);
  }
  
  public static final void bAE()
  {
    AppMethodBeat.i(228192);
    MMApplicationContext.getContext().sendBroadcast(new Intent().setAction("com.tencent.mm.appbrand.debugger.appbrand_process_reload_configs"));
    AppMethodBeat.o(228192);
  }
  
  public static final void setup()
  {
    AppMethodBeat.i(228190);
    try
    {
      Context localContext = MMApplicationContext.getContext();
      BroadcastReceiver localBroadcastReceiver = (BroadcastReceiver)lhD;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mm.appbrand.debugger.appbrand_process_reload_configs");
      localContext.registerReceiver(localBroadcastReceiver, localIntentFilter);
      AppMethodBeat.o(228190);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.AppBrand.DebuggerShellClientProcessHelper", "setup get exception ".concat(String.valueOf(localThrowable)));
      AppMethodBeat.o(228190);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.b
 * JD-Core Version:    0.7.0.1
 */