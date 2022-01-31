package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

final class c$1
  implements a.a
{
  c$1(c paramc, com.tencent.mm.plugin.appbrand.jsapi.f paramf, a parama, JSONObject paramJSONObject, int paramInt) {}
  
  public final void XJ()
  {
    y.i("MicroMsg.AppBrand.BaseAuthJsApi", "about to call AuthInvoke, api[%s]", new Object[] { this.gjG.getName() });
    if (!this.gfy.isRunning())
    {
      y.e("MicroMsg.AppBrand.BaseAuthJsApi", "doAuth but component not running, api = %s", new Object[] { this.gjG.getName() });
      this.gjF.Ff(2);
      return;
    }
    this.gjG.a(this.gfy, this.gbZ, this.dIS, this.gjF);
  }
  
  public final String toString()
  {
    return hashCode() + "|" + this.gjG.getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.c.1
 * JD-Core Version:    0.7.0.1
 */