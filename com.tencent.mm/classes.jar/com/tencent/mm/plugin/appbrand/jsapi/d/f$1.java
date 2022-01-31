package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.widget.input.n;

final class f$1
  implements Runnable
{
  f$1(f paramf, q paramq, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public final void run()
  {
    if (n.a(this.gkf, this.grq, this.grs, this.grt))
    {
      this.gkf.C(this.dIS, this.gru.h("ok", null));
      return;
    }
    this.gkf.C(this.dIS, this.gru.h("fail:invalid data", null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.f.1
 * JD-Core Version:    0.7.0.1
 */