package com.tencent.mm.plugin.location.ui.impl;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$6
  implements View.OnTouchListener
{
  c$6(c paramc) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(113600);
    this.ogD.hideVKB();
    AppMethodBeat.o(113600);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.c.6
 * JD-Core Version:    0.7.0.1
 */