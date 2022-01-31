package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.b;
import com.tencent.mm.plugin.game.f.a;
import com.tencent.mm.plugin.game.f.a.a;
import com.tencent.mm.plugin.game.model.ag;
import com.tencent.mm.plugin.game.model.aq;
import com.tencent.mm.plugin.game.model.f;
import com.tencent.mm.sdk.platformtools.ai;

final class GameOverSeaCenterUI$2
  implements Runnable
{
  GameOverSeaCenterUI$2(GameOverSeaCenterUI paramGameOverSeaCenterUI) {}
  
  public final void run()
  {
    Object localObject = ((com.tencent.mm.plugin.game.a.c)g.r(com.tencent.mm.plugin.game.a.c.class)).aYg().Ey("pb_over_sea");
    if (localObject == null) {
      ai.d(new GameOverSeaCenterUI.2.1(this));
    }
    for (;;)
    {
      ((b)g.r(b.class)).aYc().init(this.ler);
      com.tencent.mm.plugin.game.f.c.X(f.aYT());
      ai.d(new Runnable()
      {
        public final void run()
        {
          GameOverSeaCenterUI.b(GameOverSeaCenterUI.2.this.ler).fD(true);
        }
      });
      localObject = new aq(com.tencent.mm.sdk.platformtools.x.cqJ(), f.aYT(), this.ler.kYd, this.ler.kYe, this.ler.kYf, this.ler.kYc);
      g.Dk().a((m)localObject, 0);
      f.aYY();
      a.a.bau().bas();
      return;
      ai.d(new GameOverSeaCenterUI.2.2(this, new ag((byte[])localObject)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameOverSeaCenterUI.2
 * JD-Core Version:    0.7.0.1
 */