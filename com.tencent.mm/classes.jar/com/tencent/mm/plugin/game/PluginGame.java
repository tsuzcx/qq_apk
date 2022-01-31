package com.tencent.mm.plugin.game;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.bx;
import com.tencent.mm.plugin.game.a.a.a;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;

public class PluginGame
  extends f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.game.a.d
{
  c kLT;
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    if (paramg.Ex())
    {
      y.i("MicroMsg.PluginGame", "PluginGame configure");
      a.a.a(new b());
      if (this.kLT == null) {
        this.kLT = new c();
      }
    }
    if (paramg.gn(":tools")) {
      h.nFQ.h(939L, 1L, 1L);
    }
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    if (paramg.Ex())
    {
      y.i("MicroMsg.PluginGame", "PluginGame execute");
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.game.a.c.class, new e());
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.game.a.b.class, new d());
    }
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    y.i("MicroMsg.PluginGame", "onAccountInitialized");
    if (this.kLT != null)
    {
      paramc = this.kLT;
      ((p)com.tencent.mm.kernel.g.t(p.class)).getSysCmdMsgExtension().a("gamecenter", paramc.jwQ, true);
      a.udP.c(paramc.kLv);
      a.udP.c(paramc.kLw);
      a.udP.c(paramc.kLx);
      a.udP.c(paramc.dmt);
      a.udP.c(paramc.kLy);
      a.udP.c(paramc.kLz);
      a.udP.c(paramc.kLA);
      a.udP.c(paramc.kLB);
      a.udP.c(paramc.kLC);
      a.udP.c(paramc.kLF);
      a.udP.c(paramc.kLG);
      a.udP.c(paramc.kLD);
      a.udP.c(paramc.kLH);
      a.udP.c(paramc.kLI);
      a.udP.c(paramc.kLJ);
      a.udP.c(paramc.kLK);
      k.aFI();
      com.tencent.mm.plugin.game.model.a.d.aFI();
    }
  }
  
  public void onAccountRelease()
  {
    y.i("MicroMsg.PluginGame", "onAccountRelease");
    if (this.kLT != null)
    {
      c localc = this.kLT;
      ((p)com.tencent.mm.kernel.g.t(p.class)).getSysCmdMsgExtension().b("gamecenter", localc.jwQ, true);
      a.udP.d(localc.kLv);
      a.udP.d(localc.kLw);
      a.udP.d(localc.kLx);
      a.udP.d(localc.dmt);
      a.udP.d(localc.kLy);
      a.udP.d(localc.kLz);
      a.udP.d(localc.kLA);
      a.udP.d(localc.kLB);
      a.udP.d(localc.kLC);
      a.udP.d(localc.kLF);
      a.udP.d(localc.kLG);
      a.udP.d(localc.kLD);
      a.udP.d(localc.kLH);
      a.udP.d(localc.kLI);
      a.udP.d(localc.kLJ);
      a.udP.d(localc.kLK);
      k.aFJ();
      com.tencent.mm.plugin.game.model.a.d.aFJ();
    }
    com.tencent.mm.plugin.game.f.c.aqp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.PluginGame
 * JD-Core Version:    0.7.0.1
 */