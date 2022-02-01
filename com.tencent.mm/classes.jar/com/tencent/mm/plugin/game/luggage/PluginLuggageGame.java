package com.tencent.mm.plugin.game.luggage;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.network.n;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.game.luggage.h.a.7;
import com.tencent.mm.plugin.webview.ui.tools.game.BatteryManager;
import com.tencent.mm.plugin.webview.ui.tools.game.BatteryManager.BatteryChangedReceiver;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;

public class PluginLuggageGame
  extends com.tencent.mm.kernel.b.f
  implements c, com.tencent.mm.plugin.game.luggage.a.b
{
  private n tyc;
  
  public PluginLuggageGame()
  {
    AppMethodBeat.i(192985);
    this.tyc = new n.a()
    {
      private final byte[] fGy;
      
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(192984);
        synchronized (this.fGy)
        {
          if (com.tencent.mm.plugin.game.luggage.h.a.dao() != null)
          {
            com.tencent.mm.plugin.game.luggage.h.a locala = com.tencent.mm.plugin.game.luggage.h.a.dao();
            String str = az.iW(ak.getContext());
            locala.ugS.b(new a.7(locala, str));
            locala.ugT.evaluateJavascript(String.format("if (SystemInfo == 'undefined' || SystemInfo.networkType == 'undefined) {return;} SystemInfo.networkType=\"%s\"; console.log(SystemInfo.networkType);", new Object[] { str }), null);
          }
          AppMethodBeat.o(192984);
          return;
        }
      }
    };
    AppMethodBeat.o(192985);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(83013);
    if ((paramg.akL()) || (paramg.xO(":tools")) || (paramg.xO(":toolsmp")) || (paramg.xO(":lite"))) {
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.game.luggage.a.a.class, new e(new d()));
    }
    AppMethodBeat.o(83013);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(83014);
    if (BatteryManager.EAm == null) {
      BatteryManager.EAm = new BatteryManager.BatteryChangedReceiver((byte)0);
    }
    paramc = new IntentFilter();
    paramc.addAction("android.intent.action.BATTERY_OKAY");
    paramc.addAction("android.intent.action.BATTERY_LOW");
    ak.getContext().registerReceiver(BatteryManager.EAm, paramc);
    com.tencent.mm.kernel.g.ajQ().a(this.tyc);
    AppMethodBeat.o(83014);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(83015);
    if (BatteryManager.EAm != null) {
      ak.getContext().unregisterReceiver(BatteryManager.EAm);
    }
    BatteryManager.EAm = null;
    com.tencent.mm.kernel.g.ajQ().b(this.tyc);
    AppMethodBeat.o(83015);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.PluginLuggageGame
 * JD-Core Version:    0.7.0.1
 */