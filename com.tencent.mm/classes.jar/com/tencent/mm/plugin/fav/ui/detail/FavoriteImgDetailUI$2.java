package com.tencent.mm.plugin.fav.ui.detail;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;

final class FavoriteImgDetailUI$2
  implements View.OnTouchListener
{
  FavoriteImgDetailUI$2(FavoriteImgDetailUI paramFavoriteImgDetailUI)
  {
    AppMethodBeat.i(74375);
    AppMethodBeat.o(74375);
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(151527);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(151527);
      return false;
      paramView = v.aae().z("basescanui@datacenter", true);
      paramView.i("key_basescanui_screen_x", Integer.valueOf((int)paramMotionEvent.getRawX()));
      paramView.i("key_basescanui_screen_y", Integer.valueOf((int)paramMotionEvent.getRawY()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.2
 * JD-Core Version:    0.7.0.1
 */