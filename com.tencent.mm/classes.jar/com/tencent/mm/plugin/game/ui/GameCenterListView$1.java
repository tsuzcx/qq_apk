package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

final class GameCenterListView$1
  implements AbsListView.OnScrollListener
{
  GameCenterListView$1(GameCenterListView paramGameCenterListView) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 == 0) && (GameCenterListView.a(this.kYs) != null) && (GameCenterListView.a(this.kYs).getTop() == 0))
    {
      GameCenterListView.a(this.kYs, true);
      return;
    }
    GameCenterListView.a(this.kYs, false);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCenterListView.1
 * JD-Core Version:    0.7.0.1
 */