package com.tencent.mm.plugin.game.ui.tab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class GameTabBridgeUI$1$1
  implements Runnable
{
  GameTabBridgeUI$1$1(GameTabBridgeUI.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(112237);
    ab.i("MicroMsg.GameTabBridgeUI", "load tools process, web page load time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - this.nDQ.fET) });
    if (GameTabWidget.nDU == this.nDQ.nDP.hashCode())
    {
      GameTabWidget.a(this.nDQ.nDP, this.nDQ.val$intent, false, true, true, false);
      AppMethodBeat.o(112237);
      return;
    }
    ab.i("MicroMsg.GameTabBridgeUI", "GameTabWidget.mHashCode(%d) != hashCode(%d), dont need turn page!", new Object[] { Integer.valueOf(GameTabWidget.nDU), Integer.valueOf(this.nDQ.nDP.hashCode()) });
    AppMethodBeat.o(112237);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.tab.GameTabBridgeUI.1.1
 * JD-Core Version:    0.7.0.1
 */