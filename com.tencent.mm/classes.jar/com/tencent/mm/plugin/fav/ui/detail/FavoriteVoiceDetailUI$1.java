package com.tencent.mm.plugin.fav.ui.detail;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FavoriteVoiceDetailUI$1
  implements MenuItem.OnMenuItemClickListener
{
  FavoriteVoiceDetailUI$1(FavoriteVoiceDetailUI paramFavoriteVoiceDetailUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(74478);
    this.mBw.finish();
    AppMethodBeat.o(74478);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteVoiceDetailUI.1
 * JD-Core Version:    0.7.0.1
 */