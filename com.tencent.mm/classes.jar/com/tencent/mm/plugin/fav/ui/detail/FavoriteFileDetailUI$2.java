package com.tencent.mm.plugin.fav.ui.detail;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FavoriteFileDetailUI$2
  implements View.OnTouchListener
{
  FavoriteFileDetailUI$2(FavoriteFileDetailUI paramFavoriteFileDetailUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(74322);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(74322);
      return false;
      FavoriteFileDetailUI.a(this.mAf, (int)paramMotionEvent.getRawX());
      FavoriteFileDetailUI.b(this.mAf, (int)paramMotionEvent.getRawY());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.2
 * JD-Core Version:    0.7.0.1
 */