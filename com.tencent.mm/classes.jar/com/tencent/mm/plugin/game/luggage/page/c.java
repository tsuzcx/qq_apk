package com.tencent.mm.plugin.game.luggage.page;

import android.os.Bundle;
import com.tencent.luggage.d.j;
import com.tencent.luggage.d.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.m;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/luggage/page/GameNoActionBarPreloadWebPage;", "Lcom/tencent/mm/plugin/game/luggage/page/PreloadGameWebPage;", "ctrl", "Lcom/tencent/luggage/container/LuggagePageContainerCtrl;", "wc", "Lcom/tencent/luggage/container/LuggageWebCore;", "params", "Landroid/os/Bundle;", "(Lcom/tencent/luggage/container/LuggagePageContainerCtrl;Lcom/tencent/luggage/container/LuggageWebCore;Landroid/os/Bundle;)V", "enableMinimize", "", "hideLoadingView", "", "noActionBar", "()Ljava/lang/Boolean;", "onForeground", "showLoadingView", "luggage-game_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends i
{
  public c(j paramj, p paramp, Bundle paramBundle)
  {
    super(paramj, paramp, paramBundle);
    AppMethodBeat.i(277039);
    AppMethodBeat.o(277039);
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
    AppMethodBeat.i(277042);
    super.onForeground();
    this.WFP.iuC();
    AppMethodBeat.o(277042);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.page.c
 * JD-Core Version:    0.7.0.1
 */