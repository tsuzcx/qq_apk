package com.tencent.mm.plugin.appbrand.page;

import android.support.v4.view.t;
import android.view.View;
import android.view.ViewParent;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class av$1$1
  implements Runnable
{
  av$1$1(av.1 param1, View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(140886);
    if (!t.aw(this.izs))
    {
      AppMethodBeat.o(140886);
      return;
    }
    if (!t.as(this.izs))
    {
      d.d("Luggage.MPPageViewRenderer", "loadURL[page], PageView(%s) not laid out, forceLayout", new Object[] { this.izt.izr.hzM });
      this.izs.forceLayout();
      Object localObject = this.izs.getParent();
      ViewParent localViewParent;
      do
      {
        ((View)localObject).forceLayout();
        localViewParent = ((ViewParent)localObject).getParent();
        localObject = localViewParent;
      } while ((localViewParent instanceof View));
      if (localViewParent != null) {
        localViewParent.requestLayout();
      }
    }
    AppMethodBeat.o(140886);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.av.1.1
 * JD-Core Version:    0.7.0.1
 */