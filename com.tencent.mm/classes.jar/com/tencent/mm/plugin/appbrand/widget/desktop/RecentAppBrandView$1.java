package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RecentAppBrandView$1
  implements Runnable
{
  RecentAppBrandView$1(RecentAppBrandView paramRecentAppBrandView) {}
  
  public final void run()
  {
    AppMethodBeat.i(154353);
    if (this.jgf.getAdapter() != null) {
      this.jgf.getAdapter().ajb.notifyChanged();
    }
    AppMethodBeat.o(154353);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.RecentAppBrandView.1
 * JD-Core Version:    0.7.0.1
 */