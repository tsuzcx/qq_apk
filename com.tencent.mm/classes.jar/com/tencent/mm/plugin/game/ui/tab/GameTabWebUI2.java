package com.tencent.mm.plugin.game.ui.tab;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GameTabWebUI2
  extends GameTabWebUI
{
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.tab.GameTabWebUI2
 * JD-Core Version:    0.7.0.1
 */