package com.tencent.mm.plugin.appbrand;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class i$6
  implements ViewTreeObserver.OnPreDrawListener
{
  i$6(i parami, View paramView, i.d paramd) {}
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(86658);
    this.gQc.getViewTreeObserver().removeOnPreDrawListener(this);
    this.gQc.post(new i.6.1(this));
    AppMethodBeat.o(86658);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.i.6
 * JD-Core Version:    0.7.0.1
 */