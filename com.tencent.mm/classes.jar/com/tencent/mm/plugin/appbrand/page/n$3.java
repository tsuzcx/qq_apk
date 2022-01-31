package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.plugin.appbrand.jsapi.e.e;

final class n$3
  implements e.e
{
  n$3(n paramn, k paramk, Runnable paramRunnable) {}
  
  public final void onReady()
  {
    this.gTd.getCurrentPageView().b(this);
    this.gTa.removeCallbacks(this.gTe);
    this.gTa.post(this.gTe);
    this.gTa.anb();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.n.3
 * JD-Core Version:    0.7.0.1
 */