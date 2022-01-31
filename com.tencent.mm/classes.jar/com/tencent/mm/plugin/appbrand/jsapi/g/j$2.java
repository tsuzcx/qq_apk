package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.mm.plugin.appbrand.jsapi.e.d;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

final class j$2
  implements e.d
{
  j$2(j paramj, b paramb, JSONObject paramJSONObject) {}
  
  public final void pY()
  {
    y.i("MicroMsg.JsApiInsertMap", "onForeground");
    if (this.gto != null)
    {
      this.gto.onResume();
      this.gto.jdMethod_do(this.gbZ.optBoolean("showLocation"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.j.2
 * JD-Core Version:    0.7.0.1
 */