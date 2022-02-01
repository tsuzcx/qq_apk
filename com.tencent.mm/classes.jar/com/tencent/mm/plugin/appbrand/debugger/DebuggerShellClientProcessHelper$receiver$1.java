package com.tencent.mm.plugin.appbrand.debugger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.quality.n;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/debugger/DebuggerShellClientProcessHelper$receiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "plugin-appbrand-integration_release"})
public final class DebuggerShellClientProcessHelper$receiver$1
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(223285);
    DebuggerShell.bfh();
    n.byS();
    AppMethodBeat.o(223285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.DebuggerShellClientProcessHelper.receiver.1
 * JD-Core Version:    0.7.0.1
 */