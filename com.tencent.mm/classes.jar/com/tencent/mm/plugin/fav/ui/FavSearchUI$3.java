package com.tencent.mm.plugin.fav.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class FavSearchUI$3
  implements View.OnTouchListener
{
  FavSearchUI$3(FavSearchUI paramFavSearchUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106819);
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    a.b("com/tencent/mm/plugin/fav/ui/FavSearchUI$11", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      a.a(false, this, "com/tencent/mm/plugin/fav/ui/FavSearchUI$11", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(106819);
      return false;
      this.rFJ.hideVKB();
      FavSearchUI.c(this.rFJ)[0] = ((int)paramMotionEvent.getRawX());
      FavSearchUI.c(this.rFJ)[1] = ((int)paramMotionEvent.getRawY());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavSearchUI.3
 * JD-Core Version:    0.7.0.1
 */