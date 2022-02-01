package com.tencent.mm.plugin.game.commlib;

import android.content.Context;
import android.content.IntentFilter;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.q.a;
import com.tencent.mm.autogen.a.og;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.commlib.e.a.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class PluginCommLib
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.game.commlib.a.b
{
  private q.a appForegroundListener;
  private IListener zMr;
  
  public PluginCommLib()
  {
    AppMethodBeat.i(89944);
    this.zMr = new IListener(com.tencent.mm.app.f.hfK) {};
    this.appForegroundListener = new q.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(89943);
        if ((h.baz()) && (h.baC().mBZ))
        {
          h.baC();
          if (!com.tencent.mm.kernel.b.aZG()) {
            com.tencent.mm.plugin.game.commlib.e.c.clean();
          }
        }
        AppMethodBeat.o(89943);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(89942);
        if ((h.baz()) && (h.baC().mBZ))
        {
          h.baC();
          com.tencent.mm.kernel.b.aZG();
        }
        AppMethodBeat.o(89942);
      }
    };
    AppMethodBeat.o(89944);
  }
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(89945);
    e.aFK(paramg.mProcessName);
    AppMethodBeat.o(89945);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(89946);
    if (paramg.bbA()) {
      h.b(com.tencent.mm.plugin.game.commlib.a.a.class, new d());
    }
    AppMethodBeat.o(89946);
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(89947);
    this.zMr.alive();
    this.appForegroundListener.alive();
    if (com.tencent.mm.plugin.game.commlib.e.a.Ite == null) {
      com.tencent.mm.plugin.game.commlib.e.a.Ite = new a.a((byte)0);
    }
    paramc = new IntentFilter();
    paramc.addAction("android.intent.action.BATTERY_OKAY");
    paramc.addAction("android.intent.action.BATTERY_LOW");
    MMApplicationContext.getContext().registerReceiver(com.tencent.mm.plugin.game.commlib.e.a.Ite, paramc);
    AppMethodBeat.o(89947);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(89948);
    this.zMr.dead();
    com.tencent.mm.plugin.game.commlib.e.b.cNl();
    this.appForegroundListener.dead();
    if (com.tencent.mm.plugin.game.commlib.e.a.Ite != null) {
      MMApplicationContext.getContext().unregisterReceiver(com.tencent.mm.plugin.game.commlib.e.a.Ite);
    }
    com.tencent.mm.plugin.game.commlib.e.a.Ite = null;
    AppMethodBeat.o(89948);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.PluginCommLib
 * JD-Core Version:    0.7.0.1
 */