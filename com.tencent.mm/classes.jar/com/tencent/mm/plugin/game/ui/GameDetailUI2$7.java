package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.d.cz;
import com.tencent.mm.plugin.game.g.h;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class GameDetailUI2$7
  implements n.c
{
  GameDetailUI2$7(GameDetailUI2 paramGameDetailUI2, cz paramcz) {}
  
  public final void a(l paraml)
  {
    if (this.lar.kWh) {
      paraml.a(0, this.laq.getString(g.i.game_send_to_friend), g.h.bottomsheet_icon_transmit);
    }
    if (this.lar.kWi) {
      paraml.a(1, this.laq.getString(g.i.game_share_timeline), g.h.bottomsheet_icon_moment);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailUI2.7
 * JD-Core Version:    0.7.0.1
 */