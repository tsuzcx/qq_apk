package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.LinkedList;

final class GameLibraryUI$7
  implements GameDropdownView.a
{
  GameLibraryUI$7(GameLibraryUI paramGameLibraryUI) {}
  
  public final void si(int paramInt)
  {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(GameLibraryUI.f(this.lcP).keySet());
    if (paramInt > localLinkedList.size() - 1) {
      return;
    }
    GameLibraryUI.a(this.lcP, ((Integer)localLinkedList.get(paramInt)).intValue());
    y.i("MicroMsg.GameLibraryUI", "Selected SortType: %d", new Object[] { Integer.valueOf(GameLibraryUI.g(this.lcP)) });
    GameLibraryUI.b(this.lcP, 0);
    GameLibraryUI.h(this.lcP);
    b.a(this.lcP, 11, 1111, GameLibraryUI.g(this.lcP) + GameLibraryUI.i(this.lcP), 2, GameLibraryUI.e(this.lcP), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameLibraryUI.7
 * JD-Core Version:    0.7.0.1
 */