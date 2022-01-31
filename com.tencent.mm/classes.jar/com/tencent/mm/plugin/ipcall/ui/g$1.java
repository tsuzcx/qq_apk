package com.tencent.mm.plugin.ipcall.ui;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

final class g$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  g$1(g paramg, View paramView) {}
  
  public final void onGlobalLayout()
  {
    Object localObject = new Rect();
    this.gOM.getWindowVisibleDisplayFrame((Rect)localObject);
    if (this.gOM.getRootView().getHeight() - (((Rect)localObject).bottom - ((Rect)localObject).top) > 100)
    {
      localObject = this.lwq;
      ((g)localObject).ipf.postDelayed(new g.2((g)localObject), 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.g.1
 * JD-Core Version:    0.7.0.1
 */