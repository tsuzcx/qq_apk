package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GameCenterListView$1
  implements AbsListView.OnScrollListener
{
  GameCenterListView$1(GameCenterListView paramGameCenterListView) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(111776);
    if ((paramInt1 == 0) && (GameCenterListView.a(this.nwq) != null) && (GameCenterListView.a(this.nwq).getTop() == 0))
    {
      GameCenterListView.a(this.nwq, true);
      AppMethodBeat.o(111776);
      return;
    }
    GameCenterListView.a(this.nwq, false);
    AppMethodBeat.o(111776);
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCenterListView.1
 * JD-Core Version:    0.7.0.1
 */