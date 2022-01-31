package com.tencent.mm.plugin.appbrand.dynamic.d.a;

import android.os.Bundle;
import com.tencent.mm.aa.b.b;
import com.tencent.mm.aa.b.b.a;
import com.tencent.mm.aa.c.a;
import com.tencent.mm.plugin.appbrand.dynamic.h.d;
import org.json.JSONObject;

final class c$2
  implements Runnable
{
  c$2(c paramc, String paramString1, boolean paramBoolean, String paramString2, b.a parama, String paramString3, b paramb, a parama1) {}
  
  public final void run()
  {
    com.tencent.mm.plugin.appbrand.collector.c.j(this.fVG, "parse_json_start", this.fVH);
    JSONObject localJSONObject = this.fVF.tg(this.val$data);
    if (localJSONObject == null)
    {
      this.fVb.ab(this.fVF.K(this.fVI, "fail:invalid data"));
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("rawJsapiData", this.val$data);
    com.tencent.mm.plugin.appbrand.collector.c.j(this.fVG, "parse_json_end", this.fVH);
    d.a(this.fVG, this.val$data, localJSONObject);
    this.fVJ.a(this.fVK, localJSONObject, localBundle, this.fVb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.a.c.2
 * JD-Core Version:    0.7.0.1
 */