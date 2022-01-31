package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GameSearchUI$3
  implements AbsListView.OnScrollListener
{
  GameSearchUI$3(GameSearchUI paramGameSearchUI) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(112190);
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1) && (GameSearchUI.b(this.nDB).nCH))
    {
      if (GameSearchUI.c(this.nDB) != null) {
        GameSearchUI.c(this.nDB).setVisibility(0);
      }
      GameSearchUI.a(this.nDB, GameSearchUI.d(this.nDB));
    }
    AppMethodBeat.o(112190);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameSearchUI.3
 * JD-Core Version:    0.7.0.1
 */