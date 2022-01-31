package com.tencent.mm.plugin.appbrand.jsapi.n;

import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.widget.input.m.a;
import com.tencent.mm.sdk.platformtools.y;

final class d$1
  implements m.a
{
  d$1(d paramd, o paramo) {}
  
  public final void ajU()
  {
    if (this.gAt.gAr == null) {
      return;
    }
    Object localObject = this.gcp.E(q.class);
    if (localObject == null)
    {
      y.w("MicroMsg.JsApiShowToast", "current page view is null.");
      return;
    }
    localObject = ((q)localObject).aha();
    if (localObject == null)
    {
      y.w("MicroMsg.JsApiShowToast", "pageArea is null, err");
      return;
    }
    d.a(this.gAt, (FrameLayout)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.d.1
 * JD-Core Version:    0.7.0.1
 */