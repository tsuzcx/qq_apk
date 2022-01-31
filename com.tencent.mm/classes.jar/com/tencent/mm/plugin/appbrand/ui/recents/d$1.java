package com.tencent.mm.plugin.appbrand.ui.recents;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$1
  implements ViewTreeObserver.OnPreDrawListener
{
  d$1(d paramd) {}
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(133325);
    d.a(this.iSy).getViewTreeObserver().removeOnPreDrawListener(this);
    d.b(this.iSy);
    AppMethodBeat.o(133325);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.d.1
 * JD-Core Version:    0.7.0.1
 */