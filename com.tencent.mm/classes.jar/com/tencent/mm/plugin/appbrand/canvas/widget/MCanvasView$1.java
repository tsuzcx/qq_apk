package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.view.View;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MCanvasView$1
  implements Runnable
{
  MCanvasView$1(MCanvasView paramMCanvasView) {}
  
  public final void run()
  {
    AppMethodBeat.i(103711);
    Object localObject = this.hgc.getParent();
    ViewParent localViewParent;
    do
    {
      ((View)localObject).forceLayout();
      localViewParent = ((ViewParent)localObject).getParent();
      localObject = localViewParent;
    } while ((localViewParent instanceof View));
    if (localViewParent != null)
    {
      localViewParent.requestLayout();
      this.hgc.invalidate();
    }
    AppMethodBeat.o(103711);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.canvas.widget.MCanvasView.1
 * JD-Core Version:    0.7.0.1
 */