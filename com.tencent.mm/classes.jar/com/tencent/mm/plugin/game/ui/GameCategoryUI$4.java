package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

final class GameCategoryUI$4
  implements AbsListView.OnScrollListener
{
  GameCategoryUI$4(GameCategoryUI paramGameCategoryUI) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt != 0) || (paramAbsListView.getLastVisiblePosition() != paramAbsListView.getCount() - 1) || (!GameCategoryUI.d(this.kXR)) || (GameCategoryUI.e(this.kXR))) {
      return;
    }
    GameCategoryUI.f(this.kXR).setVisibility(0);
    GameCategoryUI.g(this.kXR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCategoryUI.4
 * JD-Core Version:    0.7.0.1
 */