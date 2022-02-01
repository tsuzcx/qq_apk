package com.tencent.mm.plugin.game.luggage.g;

import android.os.Bundle;
import com.tencent.luggage.d.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/game/luggage/page/GameNoActionBarWebPage;", "Lcom/tencent/mm/plugin/game/luggage/page/GameWebPage;", "ctrl", "Lcom/tencent/luggage/container/LuggagePageContainerCtrl;", "wc", "Lcom/tencent/luggage/container/LuggageWebCore;", "params", "Landroid/os/Bundle;", "(Lcom/tencent/luggage/container/LuggagePageContainerCtrl;Lcom/tencent/luggage/container/LuggageWebCore;Landroid/os/Bundle;)V", "enableMinimize", "", "hideLoadingView", "", "noActionBar", "onForeground", "showLoadingView", "luggage-game_release"})
public final class d
  extends i
{
  public d(j paramj, Bundle paramBundle)
  {
    super(paramj, null, paramBundle);
    AppMethodBeat.i(231989);
    AppMethodBeat.o(231989);
  }
  
  public final boolean cDX()
  {
    return false;
  }
  
  public final void dwZ() {}
  
  public final void ewK() {}
  
  public final void onForeground()
  {
    AppMethodBeat.i(231982);
    super.onForeground();
    this.PPw.gUR();
    AppMethodBeat.o(231982);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.g.d
 * JD-Core Version:    0.7.0.1
 */