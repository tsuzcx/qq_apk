package com.tencent.mm.plugin.game.commlib;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.g.a.kz;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;

public class PluginCommLib
  extends f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.game.commlib.a.b
{
  private n.a appForegroundListener;
  private com.tencent.mm.sdk.b.c pIJ;
  
  public PluginCommLib()
  {
    AppMethodBeat.i(89944);
    this.pIJ = new com.tencent.mm.sdk.b.c() {};
    this.appForegroundListener = new n.a()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(89943);
        if ((com.tencent.mm.kernel.g.afw()) && (com.tencent.mm.kernel.g.afz().gcn))
        {
          com.tencent.mm.kernel.g.afz();
          if (!com.tencent.mm.kernel.a.aeC()) {
            com.tencent.mm.plugin.game.commlib.e.b.clean();
          }
        }
        AppMethodBeat.o(89943);
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(89942);
        if ((com.tencent.mm.kernel.g.afw()) && (com.tencent.mm.kernel.g.afz().gcn))
        {
          com.tencent.mm.kernel.g.afz();
          com.tencent.mm.kernel.a.aeC();
        }
        AppMethodBeat.o(89942);
      }
    };
    AppMethodBeat.o(89944);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(89945);
    e.abY(paramg.mProcessName);
    AppMethodBeat.o(89945);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(89946);
    if (paramg.agu()) {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.game.commlib.a.a.class, new d());
    }
    AppMethodBeat.o(89946);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(89947);
    com.tencent.mm.sdk.b.a.ESL.b(this.pIJ);
    this.appForegroundListener.alive();
    AppMethodBeat.o(89947);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(89948);
    com.tencent.mm.sdk.b.a.ESL.d(this.pIJ);
    com.tencent.mm.plugin.game.commlib.e.a.bql();
    this.appForegroundListener.dead();
    AppMethodBeat.o(89948);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.PluginCommLib
 * JD-Core Version:    0.7.0.1
 */