package com.tencent.mm.plugin.fav.ui.detail;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.d;

final class FavoriteVoiceDetailUI$2
  implements MenuItem.OnMenuItemClickListener
{
  FavoriteVoiceDetailUI$2(FavoriteVoiceDetailUI paramFavoriteVoiceDetailUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(74483);
    paramMenuItem = new d(this.mBw.getContext(), 1, false);
    paramMenuItem.sao = new FavoriteVoiceDetailUI.2.1(this);
    paramMenuItem.sap = new FavoriteVoiceDetailUI.2.2(this);
    paramMenuItem.crd();
    AppMethodBeat.o(74483);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteVoiceDetailUI.2
 * JD-Core Version:    0.7.0.1
 */