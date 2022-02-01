package com.tencent.mm.plugin.fav.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FavFilterUI$10
  implements View.OnTouchListener
{
  FavFilterUI$10(FavFilterUI paramFavFilterUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(235297);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(235297);
      return false;
      this.tek.hideVKB();
      FavFilterUI.c(this.tek)[0] = ((int)paramMotionEvent.getRawX());
      FavFilterUI.c(this.tek)[1] = ((int)paramMotionEvent.getRawY());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavFilterUI.10
 * JD-Core Version:    0.7.0.1
 */