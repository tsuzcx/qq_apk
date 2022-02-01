package com.tencent.mm.plugin.appbrand.debugger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/debugger/DebuggerShellClientProcessHelper;", "", "()V", "ACTION_RELOAD_CONFIG", "", "TAG", "receiver", "com/tencent/mm/plugin/appbrand/debugger/DebuggerShellClientProcessHelper$receiver$1", "Lcom/tencent/mm/plugin/appbrand/debugger/DebuggerShellClientProcessHelper$receiver$1;", "beforeKillProcess", "", "notifyReloadConfigs", "setup", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b rdd;
  private static final DebuggerShellClientProcessHelper.receiver.1 rde;
  
  static
  {
    AppMethodBeat.i(319690);
    rdd = new b();
    rde = new DebuggerShellClientProcessHelper.receiver.1();
    AppMethodBeat.o(319690);
  }
  
  public static final void cly()
  {
    AppMethodBeat.i(319684);
    try
    {
      MMApplicationContext.getContext().unregisterReceiver((BroadcastReceiver)rde);
      AppMethodBeat.o(319684);
      return;
    }
    finally
    {
      Log.e("MicroMsg.AppBrand.DebuggerShellClientProcessHelper", s.X("unregisterReceiver get exception ", localObject));
      AppMethodBeat.o(319684);
    }
  }
  
  public static final void clz()
  {
    AppMethodBeat.i(319687);
    MMApplicationContext.getContext().sendBroadcast(new Intent().setAction("com.tencent.mm.appbrand.debugger.appbrand_process_reload_configs"));
    AppMethodBeat.o(319687);
  }
  
  public static final void setup()
  {
    AppMethodBeat.i(319682);
    try
    {
      Context localContext = MMApplicationContext.getContext();
      BroadcastReceiver localBroadcastReceiver = (BroadcastReceiver)rde;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mm.appbrand.debugger.appbrand_process_reload_configs");
      ah localah = ah.aiuX;
      localContext.registerReceiver(localBroadcastReceiver, localIntentFilter);
      AppMethodBeat.o(319682);
      return;
    }
    finally
    {
      Log.e("MicroMsg.AppBrand.DebuggerShellClientProcessHelper", s.X("setup get exception ", localObject));
      AppMethodBeat.o(319682);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.b
 * JD-Core Version:    0.7.0.1
 */