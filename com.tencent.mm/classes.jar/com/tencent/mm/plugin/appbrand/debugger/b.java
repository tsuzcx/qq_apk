package com.tencent.mm.plugin.appbrand.debugger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/debugger/DebuggerShellClientProcessHelper;", "", "()V", "ACTION_RELOAD_CONFIG", "", "receiver", "com/tencent/mm/plugin/appbrand/debugger/DebuggerShellClientProcessHelper$receiver$1", "Lcom/tencent/mm/plugin/appbrand/debugger/DebuggerShellClientProcessHelper$receiver$1;", "beforeKillProcess", "", "notifyReloadConfigs", "setup", "plugin-appbrand-integration_release"})
public final class b
{
  private static final DebuggerShellClientProcessHelper.receiver.1 kaG;
  public static final b kaH;
  
  static
  {
    AppMethodBeat.i(189030);
    kaH = new b();
    kaG = new DebuggerShellClientProcessHelper.receiver.1();
    AppMethodBeat.o(189030);
  }
  
  public static final void beC()
  {
    AppMethodBeat.i(189028);
    aj.getContext().unregisterReceiver((BroadcastReceiver)kaG);
    AppMethodBeat.o(189028);
  }
  
  public static final void beD()
  {
    AppMethodBeat.i(189029);
    aj.getContext().sendBroadcast(new Intent().setAction("com.tencent.mm.appbrand.debugger.appbrand_process_reload_configs"));
    AppMethodBeat.o(189029);
  }
  
  public static final void setup()
  {
    AppMethodBeat.i(189027);
    Context localContext = aj.getContext();
    BroadcastReceiver localBroadcastReceiver = (BroadcastReceiver)kaG;
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mm.appbrand.debugger.appbrand_process_reload_configs");
    localContext.registerReceiver(localBroadcastReceiver, localIntentFilter);
    AppMethodBeat.o(189027);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.b
 * JD-Core Version:    0.7.0.1
 */