package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GameCategoryUI$3
  implements m.a
{
  GameCategoryUI$3(GameCategoryUI paramGameCategoryUI) {}
  
  public final void xe(int paramInt)
  {
    AppMethodBeat.i(111747);
    int i = GameCategoryUI.b(this.nvT).getFirstVisiblePosition();
    int j = GameCategoryUI.b(this.nvT).getLastVisiblePosition();
    if ((paramInt >= i) && (paramInt <= j))
    {
      View localView = GameCategoryUI.b(this.nvT).getChildAt(paramInt - i);
      GameCategoryUI.c(this.nvT).Y(localView, paramInt);
    }
    AppMethodBeat.o(111747);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCategoryUI.3
 * JD-Core Version:    0.7.0.1
 */