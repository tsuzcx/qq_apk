package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.View;
import com.tencent.mm.sdk.platformtools.y;

final class m$1
  implements Runnable
{
  m$1(m paramm) {}
  
  public final void run()
  {
    int i = 0;
    y.i("MicroMsg.AppBrandUIdRootFrameLayout", "hideInactivePanelView, mPanel %s", new Object[] { m.b(this.htZ).getClass().getSimpleName() });
    if (m.b(this.htZ) == null) {}
    for (;;)
    {
      return;
      while (i < this.htZ.getChildCount())
      {
        View localView = this.htZ.getChildAt(i);
        if ((localView != null) && (localView != m.c(this.htZ)) && (localView != m.b(this.htZ))) {
          m.cj(localView);
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.m.1
 * JD-Core Version:    0.7.0.1
 */