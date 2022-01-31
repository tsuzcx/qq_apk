package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.widget.ListView;

final class GameCategoryUI$3
  implements m.a
{
  GameCategoryUI$3(GameCategoryUI paramGameCategoryUI) {}
  
  public final void sf(int paramInt)
  {
    int i = GameCategoryUI.b(this.kXR).getFirstVisiblePosition();
    int j = GameCategoryUI.b(this.kXR).getLastVisiblePosition();
    if ((paramInt >= i) && (paramInt <= j))
    {
      View localView = GameCategoryUI.b(this.kXR).getChildAt(paramInt - i);
      GameCategoryUI.c(this.kXR).I(localView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameCategoryUI.3
 * JD-Core Version:    0.7.0.1
 */