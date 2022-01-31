package com.tencent.luggage.game.page;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.luggage.g.d;
import com.tencent.magicbrush.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class h$1
  implements View.OnAttachStateChangeListener
{
  h$1(h paramh) {}
  
  public final void onViewAttachedToWindow(View paramView)
  {
    AppMethodBeat.i(140506);
    d.i("Luggage.Game.WAGamePageViewRenderer", "WAGamePageView onAttachedToWindow, notify mb foreground once");
    h.a(this.bCd).notifyForeground();
    h.a(this.bCd).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(140505);
        h.b(h.1.this.bCd).removeOnAttachStateChangeListener(jdField_this);
        AppMethodBeat.o(140505);
      }
    });
    AppMethodBeat.o(140506);
  }
  
  public final void onViewDetachedFromWindow(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.game.page.h.1
 * JD-Core Version:    0.7.0.1
 */