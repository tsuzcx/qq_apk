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
    AppMethodBeat.i(73931);
    this.mvK.hideVKB();
    AppMethodBeat.o(73931);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavBaseUI.6
 * JD-Core Version:    0.7.0.1
 */