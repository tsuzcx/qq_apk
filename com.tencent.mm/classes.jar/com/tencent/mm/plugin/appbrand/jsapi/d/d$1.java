package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.widget.input.ac;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import java.lang.ref.WeakReference;

final class d$1
  implements Runnable
{
  d$1(d paramd, WeakReference paramWeakReference, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    q localq = (q)this.gro.get();
    if (localq == null) {
      return;
    }
    if (localq.anc() != null) {
      localq.anc().XM();
    }
    if (n.b(localq, this.grq)) {}
    for (String str = "ok";; str = "fail")
    {
      localq.C(this.dIS, this.grr.h(str, null));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.d.1
 * JD-Core Version:    0.7.0.1
 */