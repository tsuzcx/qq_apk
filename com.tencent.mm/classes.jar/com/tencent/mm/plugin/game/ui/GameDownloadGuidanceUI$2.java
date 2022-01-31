package com.tencent.mm.plugin.game.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.f.a;
import com.tencent.mm.plugin.game.f.a.a;
import com.tencent.mm.plugin.game.model.ab;
import com.tencent.mm.plugin.game.model.ao;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.al;

final class GameDownloadGuidanceUI$2
  implements Runnable
{
  GameDownloadGuidanceUI$2(GameDownloadGuidanceUI paramGameDownloadGuidanceUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(111882);
    Object localObject = ((com.tencent.mm.plugin.game.api.e)g.E(com.tencent.mm.plugin.game.api.e.class)).bET().PN("pb_download_guidance");
    if (localObject == null) {
      al.d(new GameDownloadGuidanceUI.2.1(this));
    }
    for (;;)
    {
      localObject = new ao(aa.dsG(), com.tencent.mm.plugin.game.model.e.bFS(), this.nyy.nwb, this.nyy.nwc, this.nyy.nwd, this.nyy.nwa);
      g.Rc().a((m)localObject, 0);
      com.tencent.mm.plugin.game.model.e.bFX();
      a.a.bHB().bHz();
      AppMethodBeat.o(111882);
      return;
      al.d(new GameDownloadGuidanceUI.2.2(this, new ab((byte[])localObject)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDownloadGuidanceUI.2
 * JD-Core Version:    0.7.0.1
 */