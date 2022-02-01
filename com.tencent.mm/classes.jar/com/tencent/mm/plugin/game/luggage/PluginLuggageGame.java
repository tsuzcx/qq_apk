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
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;

public class PluginLuggageGame
  extends com.tencent.mm.kernel.b.f
  implements c, com.tencent.mm.plugin.game.luggage.a.b
{
  private n tnk;
  
  public PluginLuggageGame()
  {
    AppMethodBeat.i(211596);
    this.tnk = new n.a()
    {
      private final byte[] fEu;
      
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(211595);
        synchronized (this.fEu)
        {
          if (com.tencent.mm.plugin.game.luggage.h.a.cXE() != null)
          {
            com.tencent.mm.plugin.game.luggage.h.a locala = com.tencent.mm.plugin.game.luggage.h.a.cXE();
            String str = ay.iR(aj.getContext());
            locala.tVU.b(new a.7(locala, str));
            locala.tVV.evaluateJavascript(String.format("if (SystemInfo == 'undefined' || SystemInfo.networkType == 'undefined) {return;} SystemInfo.networkType=\"%s\"; console.log(SystemInfo.networkType);", new Object[] { str }), null);
          }
          AppMethodBeat.o(211595);
          return;
        }
      }
    };
    AppMethodBeat.o(211596);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(83013);
    if ((paramg.akw()) || (paramg.xf(":tools")) || (paramg.xf(":toolsmp")) || (paramg.xf(":lite"))) {
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.game.luggage.a.a.class, new e(new d()));
    }
    AppMethodBeat.o(83013);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(83014);
    if (BatteryManager.Eii == null) {
      BatteryManager.Eii = new BatteryManager.BatteryChangedReceiver((byte)0);
    }
    paramc = new IntentFilter();
    paramc.addAction("android.intent.action.BATTERY_OKAY");
    paramc.addAction("android.intent.action.BATTERY_LOW");
    aj.getContext().registerReceiver(BatteryManager.Eii, paramc);
    com.tencent.mm.kernel.g.ajB().a(this.tnk);
    AppMethodBeat.o(83014);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(83015);
    if (BatteryManager.Eii != null) {
      aj.getContext().unregisterReceiver(BatteryManager.Eii);
    }
    BatteryManager.Eii = null;
    com.tencent.mm.kernel.g.ajB().b(this.tnk);
    AppMethodBeat.o(83015);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.PluginLuggageGame
 * JD-Core Version:    0.7.0.1
 */