package com.tencent.mm.plugin.game.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.ui.r.a;

final class GameMessageUI$4
  implements AbsListView.OnScrollListener
{
  GameMessageUI$4(GameMessageUI paramGameMessageUI) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1) && (!GameMessageUI.b(this.lee).aCc()))
    {
      paramAbsListView = GameMessageUI.b(this.lee);
      if (!paramAbsListView.aCc()) {
        break label74;
      }
      if (paramAbsListView.uMi != null) {
        paramAbsListView.uMi.Wp();
      }
    }
    for (;;)
    {
      GameMessageUI.b(this.lee).a(null, null);
      return;
      label74:
      paramAbsListView.iwi += 15;
      if (paramAbsListView.iwi > paramAbsListView.dsw) {
        paramAbsListView.iwi = paramAbsListView.dsw;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameMessageUI.4
 * JD-Core Version:    0.7.0.1
 */