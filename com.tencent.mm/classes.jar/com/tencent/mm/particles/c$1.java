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
    AppMethodBeat.i(151348);
    this.hPy.aFE();
    AppMethodBeat.o(151348);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.particles.c.1
 * JD-Core Version:    0.7.0.1
 */