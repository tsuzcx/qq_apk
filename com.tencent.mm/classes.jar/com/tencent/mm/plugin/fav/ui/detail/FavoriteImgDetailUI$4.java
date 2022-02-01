package com.tencent.mm.plugin.fav.ui.detail;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;

final class FavoriteImgDetailUI$4
  implements View.OnTouchListener
{
  FavoriteImgDetailUI$4(FavoriteImgDetailUI paramFavoriteImgDetailUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(164096);
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteImgDetailUI$12", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      a.a(false, this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteImgDetailUI$12", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(164096);
      return false;
      paramView = y.aBq().F("basescanui@datacenter", true);
      paramView.k("key_basescanui_screen_x", Integer.valueOf((int)paramMotionEvent.getRawX()));
      paramView.k("key_basescanui_screen_y", Integer.valueOf((int)paramMotionEvent.getRawY()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteImgDetailUI.4
 * JD-Core Version:    0.7.0.1
 */