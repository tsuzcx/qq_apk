package com.tencent.mm.plugin.appbrand.widget.h;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$c
  implements View.OnAttachStateChangeListener, Runnable
{
  private final View sro;
  
  public b$c(View paramView)
  {
    AppMethodBeat.i(324096);
    this.sro = paramView;
    this.sro.addOnAttachStateChangeListener(this);
    AppMethodBeat.o(324096);
  }
  
  public final void onViewAttachedToWindow(View paramView) {}
  
  public final void onViewDetachedFromWindow(View paramView)
  {
    AppMethodBeat.i(324105);
    this.sro.removeCallbacks(this);
    AppMethodBeat.o(324105);
  }
  
  public final void run()
  {
    AppMethodBeat.i(324108);
    this.sro.setVisibility(8);
    if ((this.sro.getParent() instanceof ViewGroup)) {
      ((ViewGroup)this.sro.getParent()).removeView(this.sro);
    }
    AppMethodBeat.o(324108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.h.b.c
 * JD-Core Version:    0.7.0.1
 */