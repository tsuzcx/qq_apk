package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.support.v7.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.desktop.a.c;
import com.tencent.mm.sdk.platformtools.ab;

final class DragFeatureView$a
  implements Runnable
{
  final RecyclerView.v acJ;
  
  DragFeatureView$a(DragFeatureView paramDragFeatureView, RecyclerView.v paramv)
  {
    this.acJ = paramv;
  }
  
  public final void run()
  {
    AppMethodBeat.i(133901);
    if (this.acJ == null)
    {
      AppMethodBeat.o(133901);
      return;
    }
    int i = DragFeatureView.a(this.jfO);
    int j = this.acJ.jN();
    if (j < 0)
    {
      AppMethodBeat.o(133901);
      return;
    }
    if (DragFeatureView.b(this.jfO) != this.acJ) {}
    for (boolean bool = true;; bool = false)
    {
      c localc = DragFeatureView.c(this.jfO);
      this.jfO.getRecyclerView();
      DragFeatureView.b(this.jfO);
      ab.i("MicroMsg.DragFeatureView", "alvinluo move run %b, onMove: %b, from: %d, to: %d", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(localc.R(this.acJ)), Integer.valueOf(i), Integer.valueOf(j) });
      if (DragFeatureView.b(this.jfO) != this.acJ)
      {
        localc = DragFeatureView.c(this.jfO);
        this.jfO.getRecyclerView();
        DragFeatureView.b(this.jfO);
        if (localc.R(this.acJ))
        {
          DragFeatureView.c(this.jfO).a(this.jfO.getRecyclerView(), DragFeatureView.b(this.jfO), this.acJ, i, j);
          DragFeatureView.a(this.jfO, j);
        }
      }
      AppMethodBeat.o(133901);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.DragFeatureView.a
 * JD-Core Version:    0.7.0.1
 */