package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.ViewParent;
import com.tencent.mm.sdk.platformtools.y;

final class q$3$1
  implements Runnable
{
  q$3$1(q.3 param3) {}
  
  public final void run()
  {
    if (!android.support.v4.view.q.al(this.gTZ.gTY.getContentView()))
    {
      y.d("MicroMsg.AppBrandPageView", "loadURL[page], PageView(%s) not laid out, forceLayout", new Object[] { this.gTZ.gTY.getURL() });
      this.gTZ.gTY.getContentView().forceLayout();
      Object localObject = this.gTZ.gTY.getContentView().getParent();
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.q.3.1
 * JD-Core Version:    0.7.0.1
 */