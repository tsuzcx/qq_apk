package com.tencent.mm.plugin.fav.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FavBaseUI$6
  implements View.OnTouchListener
{
  FavBaseUI$6(FavBaseUI paramFavBaseUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106616);
    this.tdo.hideVKB();
    AppMethodBeat.o(106616);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavBaseUI.6
 * JD-Core Version:    0.7.0.1
 */