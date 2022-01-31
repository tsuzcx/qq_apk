package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.bv.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.game.d.bd;
import com.tencent.mm.plugin.game.model.ad;
import com.tencent.mm.plugin.game.model.x;
import com.tencent.mm.sdk.platformtools.ai;

final class GameCenterUI5$2
  implements Runnable
{
  GameCenterUI5$2(GameCenterUI5 paramGameCenterUI5, a parama, long paramLong) {}
  
  public final void run()
  {
    bd localbd;
    if (this.kYD == null) {
      localbd = new bd();
    }
    for (;;)
    {
      ai.d(new GameCenterUI5.2.1(this, new ad(localbd)));
      return;
      localbd = (bd)this.kYD;
      ((c)g.r(c.class)).aYg().b("pb_index_4", localbd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCenterUI5.2
 * JD-Core Version:    0.7.0.1
 */