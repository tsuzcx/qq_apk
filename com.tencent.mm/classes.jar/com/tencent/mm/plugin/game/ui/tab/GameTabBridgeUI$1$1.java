package com.tencent.mm.plugin.game.ui.tab;

import com.tencent.mm.sdk.platformtools.y;

final class GameTabBridgeUI$1$1
  implements Runnable
{
  GameTabBridgeUI$1$1(GameTabBridgeUI.1 param1) {}
  
  public final void run()
  {
    y.i("MicroMsg.GameTabBridgeUI", "load tools process, web page load time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - this.lfV.eow) });
    if (GameTabWidget.lfZ == this.lfV.lfU.hashCode())
    {
      GameTabWidget.a(this.lfV.lfU, this.lfV.val$intent, false, true, true, false);
      return;
    }
    y.i("MicroMsg.GameTabBridgeUI", "GameTabWidget.mHashCode(%d) != hashCode(%d), dont need turn page!", new Object[] { Integer.valueOf(GameTabWidget.lfZ), Integer.valueOf(this.lfV.lfU.hashCode()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.tab.GameTabBridgeUI.1.1
 * JD-Core Version:    0.7.0.1
 */