package com.tencent.mm.plugin.game.luggage;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.game.luggage.a.a;
import com.tencent.mm.plugin.game.luggage.a.b;
import com.tencent.mm.plugin.webview.ui.tools.game.BatteryManager;
import com.tencent.mm.plugin.webview.ui.tools.game.BatteryManager.BatteryChangedReceiver;
import com.tencent.mm.sdk.platformtools.ai;

public class PluginLuggageGame
  extends f
  implements com.tencent.mm.kernel.api.bucket.c, b
{
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(83013);
    if ((paramg.ahL()) || (paramg.up(":tools")) || (paramg.up(":toolsmp"))) {
      com.tencent.mm.kernel.g.a(a.class, new e(new c()));
    }
    AppMethodBeat.o(83013);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(83014);
    if (BatteryManager.CEy == null) {
      BatteryManager.CEy = new BatteryManager.BatteryChangedReceiver((byte)0);
    }
    paramc = new IntentFilter();
    paramc.addAction("android.intent.action.BATTERY_OKAY");
    paramc.addAction("android.intent.action.BATTERY_LOW");
    ai.getContext().registerReceiver(BatteryManager.CEy, paramc);
    AppMethodBeat.o(83014);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(83015);
    if (BatteryManager.CEy != null) {
      ai.getContext().unregisterReceiver(BatteryManager.CEy);
    }
    BatteryManager.CEy = null;
    AppMethodBeat.o(83015);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.PluginLuggageGame
 * JD-Core Version:    0.7.0.1
 */