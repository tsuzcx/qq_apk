package com.tencent.mm.plugin.game.commlib;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.g.a.mi;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.game.commlib.util.BatteryManager;
import com.tencent.mm.plugin.game.commlib.util.BatteryManager.BatteryChangedReceiver;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class PluginCommLib
  extends f
  implements c, com.tencent.mm.plugin.game.commlib.a.b
{
  private o.a appForegroundListener;
  private IListener sKr;
  
  public PluginCommLib()
  {
    AppMethodBeat.i(89944);
    this.sKr = new IListener() {};
    this.appForegroundListener = new o.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(89943);
        if ((com.tencent.mm.kernel.g.aAc()) && (com.tencent.mm.kernel.g.aAf().hpY))
        {
          com.tencent.mm.kernel.g.aAf();
          if (!com.tencent.mm.kernel.a.azj()) {
            com.tencent.mm.plugin.game.commlib.util.b.clean();
          }
        }
        AppMethodBeat.o(89943);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(89942);
        if ((com.tencent.mm.kernel.g.aAc()) && (com.tencent.mm.kernel.g.aAf().hpY))
        {
          com.tencent.mm.kernel.g.aAf();
          com.tencent.mm.kernel.a.azj();
        }
        AppMethodBeat.o(89942);
      }
    };
    AppMethodBeat.o(89944);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(89945);
    e.azp(paramg.mProcessName);
    AppMethodBeat.o(89945);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(89946);
    if (paramg.aBb()) {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.game.commlib.a.a.class, new d());
    }
    AppMethodBeat.o(89946);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(89947);
    EventCenter.instance.add(this.sKr);
    this.appForegroundListener.alive();
    if (BatteryManager.xvz == null) {
      BatteryManager.xvz = new BatteryManager.BatteryChangedReceiver((byte)0);
    }
    paramc = new IntentFilter();
    paramc.addAction("android.intent.action.BATTERY_OKAY");
    paramc.addAction("android.intent.action.BATTERY_LOW");
    MMApplicationContext.getContext().registerReceiver(BatteryManager.xvz, paramc);
    AppMethodBeat.o(89947);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(89948);
    EventCenter.instance.removeListener(this.sKr);
    com.tencent.mm.plugin.game.commlib.util.a.bZm();
    this.appForegroundListener.dead();
    if (BatteryManager.xvz != null) {
      MMApplicationContext.getContext().unregisterReceiver(BatteryManager.xvz);
    }
    BatteryManager.xvz = null;
    AppMethodBeat.o(89948);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.PluginCommLib
 * JD-Core Version:    0.7.0.1
 */