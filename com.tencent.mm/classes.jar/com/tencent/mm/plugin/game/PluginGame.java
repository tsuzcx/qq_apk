package com.tencent.mm.plugin.game;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.bz;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.plugin.game.model.j;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;

public class PluginGame
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.game.api.h
{
  c niz;
  
  private void checkHaowanPublishState()
  {
    AppMethodBeat.i(151789);
    com.tencent.mm.sdk.g.d.ysm.r(new PluginGame.1(this), 10000L);
    AppMethodBeat.o(151789);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(111178);
    if (paramg.SD())
    {
      ab.i("MicroMsg.PluginGame", "PluginGame configure");
      b.a.a(new b());
      if (this.niz == null) {
        this.niz = new c();
      }
    }
    if (paramg.mI(":tools")) {
      com.tencent.mm.plugin.report.service.h.qsU.j(939L, 1L, 1L);
    }
    AppMethodBeat.o(111178);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(111179);
    if (paramg.SD())
    {
      ab.i("MicroMsg.PluginGame", "PluginGame execute");
      com.tencent.mm.bq.c.anb("game");
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.game.api.e.class, new e());
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.game.api.d.class, new d());
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.game.api.f.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.game.media.h()));
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.game.api.c.class, new com.tencent.mm.plugin.game.media.e());
      AppMethodBeat.o(111179);
      return;
    }
    if (!paramg.mI(":tools")) {
      if ((paramg.mProcessName == null) || (!paramg.mProcessName.contains(paramg.getPackageName() + ":appbrand"))) {
        break label164;
      }
    }
    label164:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.game.api.f.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.game.media.h()));
      }
      AppMethodBeat.o(111179);
      return;
    }
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(111180);
    ab.i("MicroMsg.PluginGame", "onAccountInitialized");
    if (this.niz != null)
    {
      paramc = this.niz;
      ((p)com.tencent.mm.kernel.g.G(p.class)).getSysCmdMsgExtension().a("gamecenter", paramc.lGp, true);
      a.ymk.c(paramc.nia);
      a.ymk.c(paramc.nib);
      a.ymk.c(paramc.nic);
      a.ymk.c(paramc.edW);
      a.ymk.c(paramc.nid);
      a.ymk.c(paramc.nie);
      a.ymk.c(paramc.nif);
      a.ymk.c(paramc.nig);
      a.ymk.c(paramc.nih);
      a.ymk.c(paramc.nik);
      a.ymk.c(paramc.nil);
      a.ymk.c(paramc.nii);
      a.ymk.c(paramc.nim);
      a.ymk.c(paramc.nin);
      a.ymk.c(paramc.mcm);
      a.ymk.c(paramc.nio);
      j.bje();
      com.tencent.mm.plugin.game.model.a.e.bje();
    }
    checkHaowanPublishState();
    AppMethodBeat.o(111180);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(111181);
    ab.i("MicroMsg.PluginGame", "onAccountRelease");
    if (this.niz != null)
    {
      c localc = this.niz;
      ((p)com.tencent.mm.kernel.g.G(p.class)).getSysCmdMsgExtension().b("gamecenter", localc.lGp, true);
      a.ymk.d(localc.nia);
      a.ymk.d(localc.nib);
      a.ymk.d(localc.nic);
      a.ymk.d(localc.edW);
      a.ymk.d(localc.nid);
      a.ymk.d(localc.nie);
      a.ymk.d(localc.nif);
      a.ymk.d(localc.nig);
      a.ymk.d(localc.nih);
      a.ymk.d(localc.nik);
      a.ymk.d(localc.nil);
      a.ymk.d(localc.nii);
      a.ymk.d(localc.nim);
      a.ymk.d(localc.nin);
      a.ymk.d(localc.mcm);
      a.ymk.d(localc.nio);
      j.bjf();
      com.tencent.mm.plugin.game.model.a.e.bjf();
    }
    com.tencent.mm.plugin.game.f.c.aNR();
    AppMethodBeat.o(111181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.PluginGame
 * JD-Core Version:    0.7.0.1
 */