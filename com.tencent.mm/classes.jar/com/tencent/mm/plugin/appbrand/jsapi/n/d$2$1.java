package com.tencent.mm.plugin.appbrand.jsapi.n;

import com.tencent.mm.model.u;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.widget.input.m;
import com.tencent.mm.plugin.appbrand.widget.input.m.a;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Set;

final class d$2$1
  implements am.a
{
  d$2$1(d.2 param2) {}
  
  public final boolean tC()
  {
    d.bT(this.gAz.gAt.gAr);
    this.gAz.gAt.gAr = null;
    u.Hc().ii(this.gAz.gcp.hashCode() + "toast_name");
    y.d("MicroMsg.JsApiShowToast", "on timer expired!");
    m localm = m.ch(this.gAz.gjp.aha());
    if (localm != null)
    {
      m.a locala = this.gAz.gAt.gAs;
      if ((locala != null) && (localm.htY.contains(locala))) {
        localm.htY.remove(locala);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.d.2.1
 * JD-Core Version:    0.7.0.1
 */