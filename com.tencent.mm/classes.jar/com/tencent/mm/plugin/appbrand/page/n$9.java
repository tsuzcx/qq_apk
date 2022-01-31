package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.sdk.platformtools.y;

final class n$9
  implements Runnable
{
  n$9(n paramn) {}
  
  public final void run()
  {
    if ((!this.gTa.getRuntime().dNk) || (this.gTa.getRuntime().mFinished)) {}
    while (n.b(this.gTa) != null) {
      return;
    }
    long l = System.currentTimeMillis();
    q localq2 = this.gTa.amZ();
    q localq1 = localq2;
    if (localq2 == null) {
      localq1 = new q();
    }
    localq1.a(this.gTa.getContext(), n.c(this.gTa));
    localq1.hide();
    this.gTa.addView(localq1.getContentView(), 0);
    n.a(this.gTa, localq1);
    y.i("MicroMsg.AppBrandPageContainer", "preloadNextPageView: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.n.9
 * JD-Core Version:    0.7.0.1
 */