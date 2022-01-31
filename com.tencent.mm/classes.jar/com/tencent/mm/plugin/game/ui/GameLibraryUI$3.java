package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GameLibraryUI$3
  implements m.a
{
  GameLibraryUI$3(GameLibraryUI paramGameLibraryUI) {}
  
  public final void xe(int paramInt)
  {
    AppMethodBeat.i(112032);
    int i = GameLibraryUI.b(this.nAK).getFirstVisiblePosition() - GameLibraryUI.c(this.nAK);
    int j = GameLibraryUI.b(this.nAK).getLastVisiblePosition();
    int k = GameLibraryUI.c(this.nAK);
    if ((paramInt >= i) && (paramInt <= j - k))
    {
      View localView = GameLibraryUI.b(this.nAK).getChildAt(paramInt - i);
      GameLibraryUI.d(this.nAK).Y(localView, paramInt);
    }
    AppMethodBeat.o(112032);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameLibraryUI.3
 * JD-Core Version:    0.7.0.1
 */