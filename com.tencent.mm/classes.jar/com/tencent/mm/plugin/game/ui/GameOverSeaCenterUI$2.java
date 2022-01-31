package com.tencent.mm.plugin.game.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.d;
import com.tencent.mm.plugin.game.f.a;
import com.tencent.mm.plugin.game.f.a.a;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.af;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.b;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.al;

final class GameOverSeaCenterUI$2
  implements Runnable
{
  GameOverSeaCenterUI$2(GameOverSeaCenterUI paramGameOverSeaCenterUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(112129);
    Object localObject = ((com.tencent.mm.plugin.game.api.e)g.E(com.tencent.mm.plugin.game.api.e.class)).bET().PN("pb_over_sea");
    if (localObject == null) {
      al.d(new GameOverSeaCenterUI.2.1(this));
    }
    for (;;)
    {
      ((d)g.E(d.class)).bEP().init(this.nCm);
      c.ae(com.tencent.mm.plugin.game.model.e.bFS());
      al.d(new GameOverSeaCenterUI.2.3(this));
      localObject = new ap(aa.dsG(), com.tencent.mm.plugin.game.model.e.bFS(), this.nCm.nwb, this.nCm.nwc, this.nCm.nwd, this.nCm.nwa);
      g.Rc().a((m)localObject, 0);
      com.tencent.mm.plugin.game.model.e.bFX();
      a.a.bHB().bHz();
      AppMethodBeat.o(112129);
      return;
      al.d(new GameOverSeaCenterUI.2.2(this, new af((byte[])localObject)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameOverSeaCenterUI.2
 * JD-Core Version:    0.7.0.1
 */