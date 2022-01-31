package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.game.model.af;
import com.tencent.mm.sdk.platformtools.ai;

final class GameLibraryUI$9
  implements Runnable
{
  GameLibraryUI$9(GameLibraryUI paramGameLibraryUI, a parama) {}
  
  public final void run()
  {
    Object localObject = this.kYD;
    if ((GameLibraryUI.m(this.lcP) == 0) && (!GameLibraryUI.n(this.lcP))) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = new af((a)localObject, bool, GameLibraryUI.m(this.lcP));
      GameLibraryUI.o(this.lcP);
      ai.d(new GameLibraryUI.9.1(this, (af)localObject));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameLibraryUI.9
 * JD-Core Version:    0.7.0.1
 */