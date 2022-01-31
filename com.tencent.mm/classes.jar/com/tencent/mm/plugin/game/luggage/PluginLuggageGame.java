package com.tencent.mm.plugin.game.luggage;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.game.luggage.a.a;
import com.tencent.mm.plugin.webview.ui.tools.game.BatteryManager;
import com.tencent.mm.plugin.webview.ui.tools.game.BatteryManager.BatteryChangedReceiver;
import com.tencent.mm.sdk.platformtools.ah;

public class PluginLuggageGame
  extends f
  implements c, a
{
  public void execute(g paramg) {}
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(135829);
    if (BatteryManager.vmf == null) {
      BatteryManager.vmf = new BatteryManager.BatteryChangedReceiver((byte)0);
    }
    paramc = new IntentFilter();
    paramc.addAction("android.intent.action.BATTERY_OKAY");
    paramc.addAction("android.intent.action.BATTERY_LOW");
    ah.getContext().registerReceiver(BatteryManager.vmf, paramc);
    AppMethodBeat.o(135829);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(135830);
    if (BatteryManager.vmf != null) {
      ah.getContext().unregisterReceiver(BatteryManager.vmf);
    }
    BatteryManager.vmf = null;
    AppMethodBeat.o(135830);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.PluginLuggageGame
 * JD-Core Version:    0.7.0.1
 */