package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.support.v7.widget.RecyclerView.v;
import com.tencent.mm.plugin.appbrand.widget.desktop.a.b;
import com.tencent.mm.sdk.platformtools.y;

final class DragFeatureView$a
  implements Runnable
{
  final RecyclerView.v abY;
  
  DragFeatureView$a(DragFeatureView paramDragFeatureView, RecyclerView.v paramv)
  {
    this.abY = paramv;
  }
  
  public final void run()
  {
    if (this.abY == null) {}
    int i;
    int j;
    do
    {
      return;
      i = DragFeatureView.a(this.hqW);
      j = this.abY.id();
    } while (j < 0);
    if (DragFeatureView.b(this.hqW) != this.abY) {}
    for (boolean bool = true;; bool = false)
    {
      b localb = DragFeatureView.c(this.hqW);
      this.hqW.getRecyclerView();
      y.i("MicroMsg.DragFeatureView", "alvinluo move run %b, onMove: %b, from: %d, to: %d", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(localb.M(this.abY)), Integer.valueOf(i), Integer.valueOf(j) });
      if (DragFeatureView.b(this.hqW) == this.abY) {
        break;
      }
      localb = DragFeatureView.c(this.hqW);
      this.hqW.getRecyclerView();
      if (!localb.M(this.abY)) {
        break;
      }
      DragFeatureView.c(this.hqW).a(this.hqW.getRecyclerView(), DragFeatureView.b(this.hqW), this.abY, i, j);
      DragFeatureView.a(this.hqW, j);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.DragFeatureView.a
 * JD-Core Version:    0.7.0.1
 */