package com.tencent.mm.plugin.ipcall.ui;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class g$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  g$1(g paramg, View paramView) {}
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(25769);
    Object localObject = new Rect();
    this.val$rootView.getWindowVisibleDisplayFrame((Rect)localObject);
    if (this.val$rootView.getRootView().getHeight() - (((Rect)localObject).bottom - ((Rect)localObject).top) > 100)
    {
      localObject = this.DWk;
      ((g)localObject).mrI.postDelayed(new g.2((g)localObject), 100L);
    }
    AppMethodBeat.o(25769);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.g.1
 * JD-Core Version:    0.7.0.1
 */