package com.tencent.mm.plugin.appbrand.debugger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/debugger/DebuggerShellClientProcessHelper;", "", "()V", "ACTION_RELOAD_CONFIG", "", "TAG", "receiver", "com/tencent/mm/plugin/appbrand/debugger/DebuggerShellClientProcessHelper$receiver$1", "Lcom/tencent/mm/plugin/appbrand/debugger/DebuggerShellClientProcessHelper$receiver$1;", "beforeKillProcess", "", "notifyReloadConfigs", "setup", "plugin-appbrand-integration_release"})
public final class b
{
  private static final DebuggerShellClientProcessHelper.receiver.1 kdW;
  public static final b kdX;
  
  static
  {
    AppMethodBeat.i(223289);
    kdX = new b();
    kdW = new DebuggerShellClientProcessHelper.receiver.1();
    AppMethodBeat.o(223289);
  }
  
  public static final void bfk()
  {
    AppMethodBeat.i(223287);
    ak.getContext().unregisterReceiver((BroadcastReceiver)kdW);
    AppMethodBeat.o(223287);
  }
  
  public static final void bfl()
  {
    AppMethodBeat.i(223288);
    ak.getContext().sendBroadcast(new Intent().setAction("com.tencent.mm.appbrand.debugger.appbrand_process_reload_configs"));
    AppMethodBeat.o(223288);
  }
  
  public static final void setup()
  {
    AppMethodBeat.i(223286);
    try
    {
      Context localContext = ak.getContext();
      BroadcastReceiver localBroadcastReceiver = (BroadcastReceiver)kdW;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mm.appbrand.debugger.appbrand_process_reload_configs");
      localContext.registerReceiver(localBroadcastReceiver, localIntentFilter);
      AppMethodBeat.o(223286);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.e("MicroMsg.AppBrand.DebuggerShellClientProcessHelper", "setup get exception ".concat(String.valueOf(localThrowable)));
      AppMethodBeat.o(223286);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.b
 * JD-Core Version:    0.7.0.1
 */