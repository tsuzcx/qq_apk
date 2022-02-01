package com.tencent.mm.plugin.game;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cc;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.plugin.game.media.o;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.sdk.platformtools.ac;

public class PluginGame
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.game.api.h
{
  c sVj;
  
  private void checkHaowanPublishState()
  {
    AppMethodBeat.i(40859);
    com.tencent.e.h.JZN.q(new PluginGame.1(this), 500L);
    AppMethodBeat.o(40859);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(40855);
    if (paramg.ahL())
    {
      ac.i("MicroMsg.PluginGame", "PluginGame configure");
      b.a.a(new b());
      if (this.sVj == null) {
        this.sVj = new c();
      }
    }
    if (paramg.up(":tools")) {
      com.tencent.mm.plugin.report.service.h.wUl.n(939L, 1L, 1L);
    }
    if (paramg.up(":toolsmp")) {
      com.tencent.mm.plugin.report.service.h.wUl.n(939L, 10L, 1L);
    }
    AppMethodBeat.o(40855);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(40856);
    if (paramg.ahL())
    {
      ac.i("MicroMsg.PluginGame", "PluginGame execute");
      com.tencent.mm.br.c.aIn("game");
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.game.api.e.class, new e());
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.game.api.d.class, new d());
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.game.api.f.class, new com.tencent.mm.kernel.c.e(new o()));
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.game.api.c.class, new com.tencent.mm.plugin.game.media.f());
      AppMethodBeat.o(40856);
      return;
    }
    if ((paramg.up(":tools")) || (paramg.up(":toolsmp")) || (paramg.uq(":appbrand"))) {
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.game.api.f.class, new com.tencent.mm.kernel.c.e(new o()));
    }
    AppMethodBeat.o(40856);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(40857);
    ac.i("MicroMsg.PluginGame", "onAccountInitialized");
    if (this.sVj != null)
    {
      paramc = this.sVj;
      ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().a("gamecenter", paramc.pAl, true);
      com.tencent.mm.sdk.b.a.GpY.c(paramc.sUK);
      com.tencent.mm.sdk.b.a.GpY.c(paramc.sUM);
      com.tencent.mm.sdk.b.a.GpY.c(paramc.sUN);
      com.tencent.mm.sdk.b.a.GpY.c(paramc.frK);
      com.tencent.mm.sdk.b.a.GpY.c(paramc.sUO);
      com.tencent.mm.sdk.b.a.GpY.c(paramc.sUP);
      com.tencent.mm.sdk.b.a.GpY.c(paramc.sUQ);
      com.tencent.mm.sdk.b.a.GpY.c(paramc.sUR);
      com.tencent.mm.sdk.b.a.GpY.c(paramc.sUS);
      com.tencent.mm.sdk.b.a.GpY.c(paramc.sUV);
      com.tencent.mm.sdk.b.a.GpY.c(paramc.sUW);
      com.tencent.mm.sdk.b.a.GpY.c(paramc.sUT);
      com.tencent.mm.sdk.b.a.GpY.c(paramc.sUX);
      com.tencent.mm.sdk.b.a.GpY.c(paramc.sUY);
      com.tencent.mm.sdk.b.a.GpY.c(paramc.qrq);
      com.tencent.mm.sdk.b.a.GpY.c(paramc.sUZ);
      k.bXA();
      com.tencent.mm.plugin.game.model.a.e.bXA();
      c.appForegroundListener.alive();
      com.tencent.mm.plugin.recordvideo.background.a locala = com.tencent.mm.plugin.recordvideo.background.a.wme;
      com.tencent.mm.plugin.recordvideo.background.a.a(5, paramc.sUL);
    }
    checkHaowanPublishState();
    AppMethodBeat.o(40857);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(40858);
    ac.i("MicroMsg.PluginGame", "onAccountRelease");
    if (this.sVj != null)
    {
      c localc = this.sVj;
      ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().b("gamecenter", localc.pAl, true);
      com.tencent.mm.sdk.b.a.GpY.d(localc.sUK);
      com.tencent.mm.sdk.b.a.GpY.d(localc.sUM);
      com.tencent.mm.sdk.b.a.GpY.d(localc.sUN);
      com.tencent.mm.sdk.b.a.GpY.d(localc.frK);
      com.tencent.mm.sdk.b.a.GpY.d(localc.sUO);
      com.tencent.mm.sdk.b.a.GpY.d(localc.sUP);
      com.tencent.mm.sdk.b.a.GpY.d(localc.sUQ);
      com.tencent.mm.sdk.b.a.GpY.d(localc.sUR);
      com.tencent.mm.sdk.b.a.GpY.d(localc.sUS);
      com.tencent.mm.sdk.b.a.GpY.d(localc.sUV);
      com.tencent.mm.sdk.b.a.GpY.d(localc.sUW);
      com.tencent.mm.sdk.b.a.GpY.d(localc.sUT);
      com.tencent.mm.sdk.b.a.GpY.d(localc.sUX);
      com.tencent.mm.sdk.b.a.GpY.d(localc.sUY);
      com.tencent.mm.sdk.b.a.GpY.d(localc.qrq);
      com.tencent.mm.sdk.b.a.GpY.d(localc.sUZ);
      k.bXB();
      com.tencent.mm.plugin.game.model.a.e.bXB();
      c.appForegroundListener.dead();
      com.tencent.mm.plugin.recordvideo.background.a locala = com.tencent.mm.plugin.recordvideo.background.a.wme;
      com.tencent.mm.plugin.recordvideo.background.a.b(5, localc.sUL);
    }
    com.tencent.mm.plugin.game.f.c.bxi();
    AppMethodBeat.o(40858);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.PluginGame
 * JD-Core Version:    0.7.0.1
 */