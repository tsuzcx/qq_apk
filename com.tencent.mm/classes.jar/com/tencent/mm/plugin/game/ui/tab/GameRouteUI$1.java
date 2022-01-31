package com.tencent.mm.plugin.game.ui.tab;

import com.tencent.mm.plugin.game.d.bf;
import com.tencent.mm.plugin.game.model.ak.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class GameRouteUI$1
  implements ak.a
{
  GameRouteUI$1(GameRouteUI paramGameRouteUI) {}
  
  public final void b(bf parambf)
  {
    if ((parambf != null) && (!bk.dk(parambf.kTw)))
    {
      GameRouteUI.a(this.lfP, parambf.kTw);
      return;
    }
    y.e("MicroMsg.GameRouteUI", "get GameIndex4TabNavData err");
    GameRouteUI.a(this.lfP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.tab.GameRouteUI.1
 * JD-Core Version:    0.7.0.1
 */