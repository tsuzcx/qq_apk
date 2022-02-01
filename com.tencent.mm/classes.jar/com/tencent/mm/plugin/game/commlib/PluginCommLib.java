package com.tencent.mm.plugin.game.commlib;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.g.a.ls;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.game.commlib.util.BatteryManager;
import com.tencent.mm.plugin.game.commlib.util.BatteryManager.BatteryChangedReceiver;
import com.tencent.mm.sdk.platformtools.ak;

public class PluginCommLib
  extends f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.game.commlib.a.b
{
  private o.a appForegroundListener;
  private com.tencent.mm.sdk.b.c riP;
  
  public PluginCommLib()
  {
    AppMethodBeat.i(89944);
    this.riP = new com.tencent.mm.sdk.b.c() {};
    this.appForegroundListener = new o.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(89943);
        if ((com.tencent.mm.kernel.g.ajM()) && (com.tencent.mm.kernel.g.ajP().gDk))
        {
          com.tencent.mm.kernel.g.ajP();
          if (!com.tencent.mm.kernel.a.aiT()) {
            com.tencent.mm.plugin.game.commlib.util.b.clean();
          }
        }
        AppMethodBeat.o(89943);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(89942);
        if ((com.tencent.mm.kernel.g.ajM()) && (com.tencent.mm.kernel.g.ajP().gDk))
        {
          com.tencent.mm.kernel.g.ajP();
          com.tencent.mm.kernel.a.aiT();
        }
        AppMethodBeat.o(89942);
      }
    };
    AppMethodBeat.o(89944);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(89945);
    e.aml(paramg.mProcessName);
    AppMethodBeat.o(89945);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(89946);
    if (paramg.akL()) {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.game.commlib.a.a.class, new d());
    }
    AppMethodBeat.o(89946);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(89947);
    com.tencent.mm.sdk.b.a.IvT.b(this.riP);
    this.appForegroundListener.alive();
    if (BatteryManager.udN == null) {
      BatteryManager.udN = new BatteryManager.BatteryChangedReceiver((byte)0);
    }
    paramc = new IntentFilter();
    paramc.addAction("android.intent.action.BATTERY_OKAY");
    paramc.addAction("android.intent.action.BATTERY_LOW");
    ak.getContext().registerReceiver(BatteryManager.udN, paramc);
    AppMethodBeat.o(89947);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(89948);
    com.tencent.mm.sdk.b.a.IvT.d(this.riP);
    com.tencent.mm.plugin.game.commlib.util.a.bCi();
    this.appForegroundListener.dead();
    if (BatteryManager.udN != null) {
      ak.getContext().unregisterReceiver(BatteryManager.udN);
    }
    BatteryManager.udN = null;
    AppMethodBeat.o(89948);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.PluginCommLib
 * JD-Core Version:    0.7.0.1
 */