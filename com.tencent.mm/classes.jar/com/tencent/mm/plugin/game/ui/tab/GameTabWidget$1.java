package com.tencent.mm.plugin.game.ui.tab;

import android.database.DataSetObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GameTabWidget$1
  extends DataSetObserver
{
  GameTabWidget$1(GameTabWidget paramGameTabWidget) {}
  
  public final void onChanged()
  {
    AppMethodBeat.i(112272);
    GameTabWidget.a(this.nDW);
    AppMethodBeat.o(112272);
  }
  
  public final void onInvalidated()
  {
    AppMethodBeat.i(112271);
    GameTabWidget.a(this.nDW);
    AppMethodBeat.o(112271);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.tab.GameTabWidget.1
 * JD-Core Version:    0.7.0.1
 */