package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.widget.ListView;

final class GameLibraryUI$3
  implements m.a
{
  GameLibraryUI$3(GameLibraryUI paramGameLibraryUI) {}
  
  public final void sf(int paramInt)
  {
    int i = GameLibraryUI.b(this.lcP).getFirstVisiblePosition() - GameLibraryUI.c(this.lcP);
    int j = GameLibraryUI.b(this.lcP).getLastVisiblePosition();
    int k = GameLibraryUI.c(this.lcP);
    if ((paramInt >= i) && (paramInt <= j - k))
    {
      View localView = GameLibraryUI.b(this.lcP).getChildAt(paramInt - i);
      GameLibraryUI.d(this.lcP).I(localView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameLibraryUI.3
 * JD-Core Version:    0.7.0.1
 */