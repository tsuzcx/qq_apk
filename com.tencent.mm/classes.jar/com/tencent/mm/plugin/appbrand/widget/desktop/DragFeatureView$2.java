package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class DragFeatureView$2
  implements Runnable
{
  DragFeatureView$2(DragFeatureView paramDragFeatureView, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(133898);
    ab.i("MicroMsg.DragFeatureView", "alvinluo handleAttachEdge isTop: %b", new Object[] { Boolean.valueOf(this.jfP) });
    RecyclerView localRecyclerView = this.jfO.getRecyclerView();
    if (this.jfP)
    {
      i = -10;
      ab.i("MicroMsg.DragFeatureView", "alvinluo handleAttachEdge canScroll: %b", new Object[] { Boolean.valueOf(localRecyclerView.canScrollVertically(i)) });
      localRecyclerView = this.jfO.getRecyclerView();
      if (!this.jfP) {
        break label111;
      }
    }
    label111:
    for (int i = -20;; i = 20)
    {
      localRecyclerView.scrollBy(0, i);
      this.jfO.post(this);
      AppMethodBeat.o(133898);
      return;
      i = 10;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.DragFeatureView.2
 * JD-Core Version:    0.7.0.1
 */