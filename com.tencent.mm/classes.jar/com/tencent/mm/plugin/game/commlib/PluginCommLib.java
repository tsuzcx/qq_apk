package com.tencent.mm.plugin.game.commlib;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.f.a.mz;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.commlib.e.a.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class PluginCommLib
  extends f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.game.commlib.a.b
{
  private o.a appForegroundListener;
  private IListener wqp;
  
  public PluginCommLib()
  {
    AppMethodBeat.i(89944);
    this.wqp = new IListener() {};
    this.appForegroundListener = new o.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(89943);
        if ((h.aHB()) && (h.aHE().kbT))
        {
          h.aHE();
          if (!com.tencent.mm.kernel.b.aGE()) {
            com.tencent.mm.plugin.game.commlib.e.c.clean();
          }
        }
        AppMethodBeat.o(89943);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(89942);
        if ((h.aHB()) && (h.aHE().kbT))
        {
          h.aHE();
          com.tencent.mm.kernel.b.aGE();
        }
        AppMethodBeat.o(89942);
      }
    };
    AppMethodBeat.o(89944);
  }
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(89945);
    e.aIZ(paramg.mProcessName);
    AppMethodBeat.o(89945);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(89946);
    if (paramg.aIE()) {
      h.b(com.tencent.mm.plugin.game.commlib.a.a.class, new d());
    }
    AppMethodBeat.o(89946);
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(89947);
    EventCenter.instance.add(this.wqp);
    this.appForegroundListener.alive();
    if (com.tencent.mm.plugin.game.commlib.e.a.Czp == null) {
      com.tencent.mm.plugin.game.commlib.e.a.Czp = new a.a((byte)0);
    }
    paramc = new IntentFilter();
    paramc.addAction("android.intent.action.BATTERY_OKAY");
    paramc.addAction("android.intent.action.BATTERY_LOW");
    MMApplicationContext.getContext().registerReceiver(com.tencent.mm.plugin.game.commlib.e.a.Czp, paramc);
    AppMethodBeat.o(89947);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(89948);
    EventCenter.instance.removeListener(this.wqp);
    com.tencent.mm.plugin.game.commlib.e.b.clU();
    this.appForegroundListener.dead();
    if (com.tencent.mm.plugin.game.commlib.e.a.Czp != null) {
      MMApplicationContext.getContext().unregisterReceiver(com.tencent.mm.plugin.game.commlib.e.a.Czp);
    }
    com.tencent.mm.plugin.game.commlib.e.a.Czp = null;
    AppMethodBeat.o(89948);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.PluginCommLib
 * JD-Core Version:    0.7.0.1
 */