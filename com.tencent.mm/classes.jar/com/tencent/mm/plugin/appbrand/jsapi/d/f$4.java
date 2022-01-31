package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.widget.input.AppBrandInputInvokeHandler;
import com.tencent.mm.plugin.appbrand.widget.input.d.e;
import com.tencent.mm.plugin.appbrand.widget.input.h;
import java.lang.ref.WeakReference;

final class f$4
  implements Runnable
{
  f$4(f paramf, WeakReference paramWeakReference, AppBrandInputInvokeHandler paramAppBrandInputInvokeHandler, e parame, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    q localq = (q)this.gro.get();
    if ((localq == null) || (localq.gTF == null)) {
      return;
    }
    h.arM().f(localq.gTF);
    this.grm.insertInput(this.grv, this.grw, this.grx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.f.4
 * JD-Core Version:    0.7.0.1
 */