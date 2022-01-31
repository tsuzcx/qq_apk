package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

final class GameLibraryUI$8
  implements AbsListView.OnScrollListener
{
  GameLibraryUI$8(GameLibraryUI paramGameLibraryUI) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt != 0) || (paramAbsListView.getLastVisiblePosition() != paramAbsListView.getCount() - 1) || (!GameLibraryUI.j(this.lcP)) || (GameLibraryUI.k(this.lcP))) {
      return;
    }
    GameLibraryUI.l(this.lcP).setVisibility(0);
    GameLibraryUI.h(this.lcP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameLibraryUI.8
 * JD-Core Version:    0.7.0.1
 */