package com.tencent.mm.plugin.game.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GameMessageUI$4
  implements AbsListView.OnScrollListener
{
  GameMessageUI$4(GameMessageUI paramGameMessageUI) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(112103);
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1) && (!GameMessageUI.b(this.nBZ).bem()))
    {
      GameMessageUI.b(this.nBZ).bHr();
      GameMessageUI.b(this.nBZ).a(null, null);
    }
    AppMethodBeat.o(112103);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameMessageUI.4
 * JD-Core Version:    0.7.0.1
 */