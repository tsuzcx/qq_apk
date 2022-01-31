package com.tencent.mm.plugin.game.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GameSearchUI$2
  implements View.OnTouchListener
{
  GameSearchUI$2(GameSearchUI paramGameSearchUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(112189);
    GameSearchUI.a(this.nDB).clearFocus();
    this.nDB.hideVKB();
    AppMethodBeat.o(112189);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameSearchUI.2
 * JD-Core Version:    0.7.0.1
 */