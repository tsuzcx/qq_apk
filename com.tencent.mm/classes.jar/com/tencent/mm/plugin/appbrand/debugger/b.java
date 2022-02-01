package com.tencent.mm.plugin.appbrand.debugger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/debugger/DebuggerShellClientProcessHelper;", "", "()V", "ACTION_RELOAD_CONFIG", "", "TAG", "receiver", "com/tencent/mm/plugin/appbrand/debugger/DebuggerShellClientProcessHelper$receiver$1", "Lcom/tencent/mm/plugin/appbrand/debugger/DebuggerShellClientProcessHelper$receiver$1;", "beforeKillProcess", "", "notifyReloadConfigs", "setup", "plugin-appbrand-integration_release"})
public final class b
{
  private static final DebuggerShellClientProcessHelper.receiver.1 ocl;
  public static final b ocm;
  
  static
  {
    AppMethodBeat.i(250099);
    ocm = new b();
    ocl = new DebuggerShellClientProcessHelper.receiver.1();
    AppMethodBeat.o(250099);
  }
  
  public static final void bLY()
  {
    AppMethodBeat.i(250096);
    MMApplicationContext.getContext().unregisterReceiver((BroadcastReceiver)ocl);
    AppMethodBeat.o(250096);
  }
  
  public static final void bLZ()
  {
    AppMethodBeat.i(250097);
    MMApplicationContext.getContext().sendBroadcast(new Intent().setAction("com.tencent.mm.appbrand.debugger.appbrand_process_reload_configs"));
    AppMethodBeat.o(250097);
  }
  
  public static final void setup()
  {
    AppMethodBeat.i(250095);
    try
    {
      Context localContext = MMApplicationContext.getContext();
      BroadcastReceiver localBroadcastReceiver = (BroadcastReceiver)ocl;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mm.appbrand.debugger.appbrand_process_reload_configs");
      localContext.registerReceiver(localBroadcastReceiver, localIntentFilter);
      AppMethodBeat.o(250095);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.AppBrand.DebuggerShellClientProcessHelper", "setup get exception ".concat(String.valueOf(localThrowable)));
      AppMethodBeat.o(250095);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.b
 * JD-Core Version:    0.7.0.1
 */