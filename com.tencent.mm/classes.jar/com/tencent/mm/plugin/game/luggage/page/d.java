package com.tencent.mm.plugin.game.luggage.page;

import android.os.Bundle;
import com.tencent.luggage.d.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.m;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/luggage/page/GameNoActionBarWebPage;", "Lcom/tencent/mm/plugin/game/luggage/page/GameWebPage;", "ctrl", "Lcom/tencent/luggage/container/LuggagePageContainerCtrl;", "wc", "Lcom/tencent/luggage/container/LuggageWebCore;", "params", "Landroid/os/Bundle;", "(Lcom/tencent/luggage/container/LuggagePageContainerCtrl;Lcom/tencent/luggage/container/LuggageWebCore;Landroid/os/Bundle;)V", "enableMinimize", "", "hideLoadingView", "", "noActionBar", "()Ljava/lang/Boolean;", "onForeground", "showLoadingView", "luggage-game_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends GameWebPage
{
  public d(j paramj, Bundle paramBundle)
  {
    super(paramj, null, paramBundle);
    AppMethodBeat.i(277038);
    AppMethodBeat.o(277038);
  }
  
  public final boolean dhz()
  {
    return false;
  }
  
  public final void ehG() {}
  
  public final Boolean fEB()
  {
    return Boolean.TRUE;
  }
  
  public final void fEC() {}
  
  public final void onForeground()
  {
    AppMethodBeat.i(277044);
    super.onForeground();
    this.WFP.iuC();
    AppMethodBeat.o(277044);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.page.d
 * JD-Core Version:    0.7.0.1
 */