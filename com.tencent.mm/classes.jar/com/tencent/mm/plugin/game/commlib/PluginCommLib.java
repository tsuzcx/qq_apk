package com.tencent.mm.plugin.game.commlib;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.g.a.li;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;

public class PluginCommLib
  extends f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.game.commlib.a.b
{
  private n.a appForegroundListener;
  private com.tencent.mm.sdk.b.c qrq;
  
  public PluginCommLib()
  {
    AppMethodBeat.i(89944);
    this.qrq = new com.tencent.mm.sdk.b.c() {};
    this.appForegroundListener = new n.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(89943);
        if ((com.tencent.mm.kernel.g.agM()) && (com.tencent.mm.kernel.g.agP().ggT))
        {
          com.tencent.mm.kernel.g.agP();
          if (!com.tencent.mm.kernel.a.afS()) {
            com.tencent.mm.plugin.game.commlib.e.b.clean();
          }
        }
        AppMethodBeat.o(89943);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(89942);
        if ((com.tencent.mm.kernel.g.agM()) && (com.tencent.mm.kernel.g.agP().ggT))
        {
          com.tencent.mm.kernel.g.agP();
          com.tencent.mm.kernel.a.afS();
        }
        AppMethodBeat.o(89942);
      }
    };
    AppMethodBeat.o(89944);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(89945);
    e.agQ(paramg.mProcessName);
    AppMethodBeat.o(89945);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(89946);
    if (paramg.ahL()) {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.game.commlib.a.a.class, new d());
    }
    AppMethodBeat.o(89946);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(89947);
    com.tencent.mm.sdk.b.a.GpY.b(this.qrq);
    this.appForegroundListener.alive();
    AppMethodBeat.o(89947);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(89948);
    com.tencent.mm.sdk.b.a.GpY.d(this.qrq);
    com.tencent.mm.plugin.game.commlib.e.a.bxi();
    this.appForegroundListener.dead();
    AppMethodBeat.o(89948);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.PluginCommLib
 * JD-Core Version:    0.7.0.1
 */