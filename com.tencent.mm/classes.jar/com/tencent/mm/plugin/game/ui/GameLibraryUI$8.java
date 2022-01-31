package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GameLibraryUI$8
  implements AbsListView.OnScrollListener
{
  GameLibraryUI$8(GameLibraryUI paramGameLibraryUI) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(112038);
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1))
    {
      if ((!GameLibraryUI.j(this.nAK)) || (GameLibraryUI.k(this.nAK)))
      {
        AppMethodBeat.o(112038);
        return;
      }
      GameLibraryUI.l(this.nAK).setVisibility(0);
      GameLibraryUI.h(this.nAK);
    }
    AppMethodBeat.o(112038);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameLibraryUI.8
 * JD-Core Version:    0.7.0.1
 */