package com.tencent.mm.plugin.fav.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FavoriteIndexUI$12
  implements View.OnTouchListener
{
  FavoriteIndexUI$12(FavoriteIndexUI paramFavoriteIndexUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(74238);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(74238);
      return false;
      FavoriteIndexUI.c(this.myP)[0] = ((int)paramMotionEvent.getRawX());
      FavoriteIndexUI.c(this.myP)[1] = ((int)paramMotionEvent.getRawY());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavoriteIndexUI.12
 * JD-Core Version:    0.7.0.1
 */