package com.tencent.mm.plugin.game.luggage.g;

import android.os.Bundle;
import com.tencent.luggage.d.p;
import com.tencent.matrix.trace.core.AppMethodBeat;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/game/luggage/page/GameNoActionBarPreloadWebPage;", "Lcom/tencent/mm/plugin/game/luggage/page/PreloadGameWebPage;", "ctrl", "Lcom/tencent/luggage/container/LuggagePageContainerCtrl;", "wc", "Lcom/tencent/luggage/container/LuggageWebCore;", "params", "Landroid/os/Bundle;", "(Lcom/tencent/luggage/container/LuggagePageContainerCtrl;Lcom/tencent/luggage/container/LuggageWebCore;Landroid/os/Bundle;)V", "enableMinimize", "", "hideLoadingView", "", "noActionBar", "onForeground", "showLoadingView", "luggage-game_release"})
public final class c
  extends j
{
  public c(com.tencent.luggage.d.j paramj, p paramp, Bundle paramBundle)
  {
    super(paramj, paramp, paramBundle);
    AppMethodBeat.i(231202);
    AppMethodBeat.o(231202);
  }
  
  public final boolean cDX()
  {
    return false;
  }
  
  public final void dwZ() {}
  
  public final void ewK() {}
  
  public final void onForeground()
  {
    AppMethodBeat.i(231197);
    super.onForeground();
    this.PPw.gUR();
    AppMethodBeat.o(231197);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.g.c
 * JD-Core Version:    0.7.0.1
 */