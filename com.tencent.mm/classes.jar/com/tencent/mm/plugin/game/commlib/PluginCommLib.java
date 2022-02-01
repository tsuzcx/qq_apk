package com.tencent.mm.plugin.game.commlib;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.g.a.lr;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.game.commlib.util.BatteryManager;
import com.tencent.mm.plugin.game.commlib.util.BatteryManager.BatteryChangedReceiver;
import com.tencent.mm.sdk.platformtools.aj;

public class PluginCommLib
  extends f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.game.commlib.a.b
{
  private n.a appForegroundListener;
  private com.tencent.mm.sdk.b.c raJ;
  
  public PluginCommLib()
  {
    AppMethodBeat.i(89944);
    this.raJ = new com.tencent.mm.sdk.b.c() {};
    this.appForegroundListener = new n.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(89943);
        if ((com.tencent.mm.kernel.g.ajx()) && (com.tencent.mm.kernel.g.ajA().gAD))
        {
          com.tencent.mm.kernel.g.ajA();
          if (!com.tencent.mm.kernel.a.aiE()) {
            com.tencent.mm.plugin.game.commlib.util.b.clean();
          }
        }
        AppMethodBeat.o(89943);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(89942);
        if ((com.tencent.mm.kernel.g.ajx()) && (com.tencent.mm.kernel.g.ajA().gAD))
        {
          com.tencent.mm.kernel.g.ajA();
          com.tencent.mm.kernel.a.aiE();
        }
        AppMethodBeat.o(89942);
      }
    };
    AppMethodBeat.o(89944);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(89945);
    e.aln(paramg.mProcessName);
    AppMethodBeat.o(89945);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(89946);
    if (paramg.akw()) {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.game.commlib.a.a.class, new d());
    }
    AppMethodBeat.o(89946);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(89947);
    com.tencent.mm.sdk.b.a.IbL.b(this.raJ);
    this.appForegroundListener.alive();
    if (BatteryManager.tSW == null) {
      BatteryManager.tSW = new BatteryManager.BatteryChangedReceiver((byte)0);
    }
    paramc = new IntentFilter();
    paramc.addAction("android.intent.action.BATTERY_OKAY");
    paramc.addAction("android.intent.action.BATTERY_LOW");
    aj.getContext().registerReceiver(BatteryManager.tSW, paramc);
    AppMethodBeat.o(89947);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(89948);
    com.tencent.mm.sdk.b.a.IbL.d(this.raJ);
    com.tencent.mm.plugin.game.commlib.util.a.bBo();
    this.appForegroundListener.dead();
    if (BatteryManager.tSW != null) {
      aj.getContext().unregisterReceiver(BatteryManager.tSW);
    }
    BatteryManager.tSW = null;
    AppMethodBeat.o(89948);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.PluginCommLib
 * JD-Core Version:    0.7.0.1
 */