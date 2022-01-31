package com.tencent.mm.plugin.game.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;

final class GameDetailAutoScrollView$1
  implements ap.a
{
  GameDetailAutoScrollView$1(GameDetailAutoScrollView paramGameDetailAutoScrollView) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(111806);
    GameDetailAutoScrollView.a(this.nwO);
    AppMethodBeat.o(111806);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailAutoScrollView.1
 * JD-Core Version:    0.7.0.1
 */