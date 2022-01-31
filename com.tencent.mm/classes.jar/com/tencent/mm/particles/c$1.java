package com.tencent.mm.particles;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$1
  implements View.OnAttachStateChangeListener
{
  c$1(c paramc) {}
  
  public final void onViewAttachedToWindow(View paramView) {}
  
  public final void onViewDetachedFromWindow(View paramView)
  {
    AppMethodBeat.i(151573);
    this.ghB.anW();
    AppMethodBeat.o(151573);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.particles.c.1
 * JD-Core Version:    0.7.0.1
 */